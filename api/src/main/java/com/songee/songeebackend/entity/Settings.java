package com.songee.songeebackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_settings")
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "spotify", nullable = false)
    private int spotify;

    @Column(name = "x2fa", nullable = false)
    private int x2fa;

    @Column(name = "phone", nullable = false)
    private int phone;
}
