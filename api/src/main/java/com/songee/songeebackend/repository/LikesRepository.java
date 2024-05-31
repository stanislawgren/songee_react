package com.songee.songeebackend.repository;

import com.songee.songeebackend.entity.Likes;
import com.songee.songeebackend.entity.Settings;
import com.songee.songeebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Integer> {
    Optional<List<Likes>> findByUserId(Long id);
    @Query(value = "SELECT l FROM Likes l WHERE l.user = :user_id AND l.likedUser = :liked_id AND l.value = 1")
    Optional<Likes> findByUserIdAndLikedId(@Param("user_id") User user, @Param("liked_id") User liked);
}