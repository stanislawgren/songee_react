package com.songee.songeebackend.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "user_profiles")
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Setter
    @Getter
    @Column(name = "location", length = 250)
    private String location;

    @Setter
    @Getter
    @Column(name = "avatar", length = 250)
    private String avatar;

    @Setter
    @Getter
    @Column(name = "first_name", length = 250)
    private String firstName;

    @Setter
    @Getter
    @Column(name = "last_name", length = 250)
    private String lastName;

    @Setter
    @Getter
    @Column(name = "gender", length = 1)
    private Character gender;

    @Setter
    @Getter
    @Column(name = "age")
    private Integer age;

    @Setter
    @Getter
    @Column(name = "favourite_song_title", length = 100)
    private String favouriteSongTitle;

    @Setter
    @Getter
    @Column(name = "favourite_artist", length = 250)
    private String favouriteArtist;

    @Setter
    @Getter
    @Column(name = "description", length = 1024)
    private String description;

    @Setter
    @Getter
    @Column(name = "favourite_song_artist", length = 100)
    private String favouriteSongArtist;

}