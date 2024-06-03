package com.songee.songeebackend.service;


import com.songee.songeebackend.dto.BanRequest;
import com.songee.songeebackend.dto.CommonResponse;
import com.songee.songeebackend.dto.LikeRequest;
import com.songee.songeebackend.entity.User;
import com.songee.songeebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;

    public CommonResponse banUser (BanRequest ban){
        User user = userRepository.findUserById(ban.user_id).orElseThrow();

        user.setStatus(2);

        userRepository.save(user);

        return CommonResponse.builder().status("ok").message("USER_BANNED").build();
    }
}
