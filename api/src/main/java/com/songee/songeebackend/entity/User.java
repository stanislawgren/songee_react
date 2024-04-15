package com.songee.songeebackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 64)
    private String username;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

    @Column(name = "mail", nullable = false, length = 64)
    private String mail;

    @Column(name = "permissions", nullable = false)
    private int permissions;

    // getters, setters, etc.
}
