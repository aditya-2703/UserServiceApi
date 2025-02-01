package com.ideabazaar.user.userserviceapi.service;

import com.ideabazaar.user.userserviceapi.model.Role;
import com.ideabazaar.user.userserviceapi.model.User;
import com.ideabazaar.user.userserviceapi.repository.UserRepository;
import com.ideabazaar.user.userserviceapi.service.AuthService;
import com.ideabazaar.user.userserviceapi.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class GoogleAuthServiceImpl implements AuthService {

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String clientSecret;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<?> handleCallback(String code) {
        try {
            String idToken = fetchGoogleToken(code);
            if (idToken == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
            return authenticateUser(idToken);
        } catch (Exception e) {
//            log.error("Exception occurred while handleGoogleCallback ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private String fetchGoogleToken(String code) {
        String tokenEndpoint = "https://oauth2.googleapis.com/token";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", "https://developers.google.com/oauthplayground");
        params.add("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<Map> tokenResponse = restTemplate.postForEntity(tokenEndpoint, request, Map.class);
        return (tokenResponse.getBody() != null) ? (String) tokenResponse.getBody().get("id_token") : null;
    }

    private ResponseEntity<?> authenticateUser(String idToken) {
        String userInfoUrl = "https://oauth2.googleapis.com/tokeninfo?id_token=" + idToken;
        ResponseEntity<Map> userInfoResponse = restTemplate.getForEntity(userInfoUrl, Map.class);

        if (userInfoResponse.getStatusCode() != HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Map<String, Object> userInfo = userInfoResponse.getBody();
        String email = (String) userInfo.get("email");

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> createNewUser(email));

        String jwtToken = jwtUtil.generateToken(email);
        return ResponseEntity.ok(Collections.singletonMap("token", jwtToken));
    }

    private User createNewUser(String email) {
        User user = new User();
        user.setEmail(email);
        user.setName(email);
        user.setPasswordHash(passwordEncoder.encode(UUID.randomUUID().toString()));
//        PENDING - SETROLE
        return userRepository.save(user);
    }
}
