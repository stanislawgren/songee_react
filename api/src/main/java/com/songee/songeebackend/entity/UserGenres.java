package com.songee.songeebackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users_genres")
public class UserGenres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genres_id", referencedColumnName = "id")
    private Genre genre;

    // getters, setters, etc.
}