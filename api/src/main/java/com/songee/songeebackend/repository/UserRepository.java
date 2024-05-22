package com.songee.songeebackend.repository;

import com.songee.songeebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findUserByMail(String mail);
    Optional<User> findUserById(int id);
}
