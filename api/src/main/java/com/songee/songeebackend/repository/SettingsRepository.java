package com.songee.songeebackend.repository;

import com.songee.songeebackend.entity.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SettingsRepository extends JpaRepository<Settings, Integer> {
    Optional<Settings> findByUserId(Long id);
}
