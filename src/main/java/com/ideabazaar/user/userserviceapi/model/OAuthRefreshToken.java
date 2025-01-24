package com.ideabazaar.user.userserviceapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "oauth_refresh_token")
public class OAuthRefreshToken {

    @Id
    @Column(name = "token_id", nullable = false)
    private String tokenId;

    @Lob
    @Column(name = "token")
    private byte[] token;

    @Lob
    @Column(name = "authentication")
    private byte[] authentication;

    // Getters and setters

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }
}