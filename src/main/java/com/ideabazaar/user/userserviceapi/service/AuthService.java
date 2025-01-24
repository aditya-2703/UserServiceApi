package com.ideabazaar.user.userserviceapi.service;

public interface AuthService {
    /**
     * Registers a new user in the system
     *
     * @param request Registration details of the user
     * @return Authentication response containing access token
     */
//    AuthenticationResponse register(RegisterRequest request);

    /**
     * Authenticates a user and generates access and refresh tokens
     *
     * @param request Authentication credentials
     * @return Authentication response with tokens
     */
//    AuthenticationResponse authenticate(AuthenticationRequest request);

    /**
     * Refreshes an expired access token using a valid refresh token
     *
     * @param refreshToken Existing refresh token
     * @return New authentication response with fresh tokens
     */
//    AuthenticationResponse refreshToken(String refreshToken);

    /**
     * Validates and extracts username from the provided token
     *
     * @param token JWT token to validate
     * @return Username extracted from the token
     */
    String extractUsername(String token);

    /**
     * Checks if a given token is valid for the specified username
     *
     * @param token JWT token to validate
     * @param username Username to validate against
     * @return true if token is valid, false otherwise
     */
    boolean isTokenValid(String token, String username);

    /**
     * Logs out the user by invalidating tokens
     *
     * @param token Token to be invalidated
     */
    void logout(String token);
}