package com.songee.songeebackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pairs")
public class Pairs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_1", referencedColumnName = "id")
    private User user1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_2", referencedColumnName = "id")
    private User user2;

    // getters, setters, etc.
}

