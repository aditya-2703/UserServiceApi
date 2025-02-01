package com.ideabazaar.user.userserviceapi.service;

import com.ideabazaar.user.userserviceapi.model.User;
import com.ideabazaar.user.userserviceapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user != null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.get().getName())
                    .password(user.get().getPasswordHash())
                    .roles(user.get().getRoles().toArray(new String[0]))
                    .build();
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}