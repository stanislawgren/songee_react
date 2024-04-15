package com.songee.songeebackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "liked_id", referencedColumnName = "id")
    private User likedUser;

    @Column(name = "value")
    private Integer value;

    // getters, setters, etc.
}