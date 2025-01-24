package com.ideabazaar.user.userserviceapi.dto;

import com.ideabazaar.user.userserviceapi.model.User;
import jakarta.persistence.*;

import java.util.Set;

public class RoleDTO {

    private Long id;

    private String name;

    private Set<User> users;

    // Getters and setters

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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
