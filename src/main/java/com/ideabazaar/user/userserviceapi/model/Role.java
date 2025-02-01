package com.ideabazaar.user.userserviceapi.model;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String role;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private User users;


    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return role;
    }

    public void setName(String name) {
        this.role = name;
    }

}
