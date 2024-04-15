package com.songee.songeebackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "location", length = 250)
    private String location;

    @Column(name = "avatar", length = 250)
    private String avatar;

    @Column(name = "first_name", length = 250)
    private String firstName;

    @Column(name = "last_name", length = 250)
    private String lastName;

    @Column(name = "gender", length = 1)
    private Character gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "favourite_song_title", length = 100)
    private String favouriteSongTitle;

    @Column(name = "favourite_artist", length = 250)
    private String favouriteArtist;

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "favourite_song_artist", length = 100)
    private String favouriteSongArtist;

    // getters, setters, etc.
}