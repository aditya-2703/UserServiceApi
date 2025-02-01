package com.ideabazaar.user.userserviceapi.service;

import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<?> handleCallback(String code);

}
