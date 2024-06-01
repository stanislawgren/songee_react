package com.songee.songeebackend.repository;

import com.songee.songeebackend.entity.Pairs;
import com.songee.songeebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PairsRepository extends JpaRepository<Pairs, Integer> {
    @Query(value = "SELECT p FROM Pairs p WHERE p.user1 = :id OR p.user2 = :id")
    Optional<List<Pairs>> findUserPairs(@Param("id")User user);
}
