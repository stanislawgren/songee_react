package com.songee.songeebackend.repository;

import com.songee.songeebackend.entity.Messages;
import com.songee.songeebackend.entity.Pairs;
import com.songee.songeebackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MessagesRepository extends JpaRepository<Messages, Integer> {
    @Query(value = "SELECT m FROM Messages m WHERE (m.sender = :sender AND m.receiver = :receiver) OR (m.sender = :receiver AND m.receiver = :sender)")
    Optional<List<Messages>> findRoomMessages(@Param("sender") User user1, @Param("receiver") User user2);
}
