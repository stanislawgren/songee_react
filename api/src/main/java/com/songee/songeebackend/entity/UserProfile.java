package com.songee.songeebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "user_profiles")
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Getter
    @Column(name = "location", length = 250)
    private String location;

    @Getter
    @Column(name = "avatar", length = 250)
    private String avatar;

    @Getter
    @Column(name = "first_name", length = 250)
    private String firstName;

    @Getter
    @Column(name = "last_name", length = 250)
    private String lastName;

    @Getter
    @Column(name = "gender", length = 1)
    private Character gender;

    @Getter
    @Column(name = "age")
    private Integer age;

    @Getter
    @Column(name = "favourite_song_title", length = 100)
    private String favouriteSongTitle;

    @Getter
    @Column(name = "favourite_artist", length = 250)
    private String favouriteArtist;

    @Getter
    @Column(name = "description", length = 1024)
    private String description;

    @Getter
    @Column(name = "favourite_song_artist", length = 100)
    private String favouriteSongArtist;

}