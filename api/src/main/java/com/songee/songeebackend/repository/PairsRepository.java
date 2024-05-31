package com.songee.songeebackend.repository;

import com.songee.songeebackend.entity.Pairs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PairsRepository extends JpaRepository<Pairs, Integer> {
}
