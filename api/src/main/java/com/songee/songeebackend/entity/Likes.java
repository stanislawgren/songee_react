package com.songee.songeebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "likes")
@NoArgsConstructor
@AllArgsConstructor
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "liked_id", referencedColumnName = "id")
    private User likedUser;

    @Getter
    @Column(name = "value")
    private Integer value;

    // getters, setters, etc.
}