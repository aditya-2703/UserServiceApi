package com.ideabazaar.user.userserviceapi.dto;

import com.ideabazaar.user.userserviceapi.model.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class UserDTO {


    private Long id;

    private String name;

    private String email;

    private String authType; // For OAuth2 providers (e.g., Google, Facebook, etc.)

    private String passwordHash;

    private String profilePicUrl;

    private Date createdAt;

    private List<ProjectDTO> projects_details;

    private Set<Role> roles = new HashSet<>();

    public List<ProjectDTO> getProjects_details() {
        return projects_details;
    }

    public void setProjects_details(List<ProjectDTO> projects_details) {
        this.projects_details = projects_details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
