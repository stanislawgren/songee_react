package com.songee.songeebackend.service;

import com.songee.songeebackend.dto.PairResponse;
import com.songee.songeebackend.entity.Pairs;
import com.songee.songeebackend.entity.User;
import com.songee.songeebackend.entity.UserProfile;
import com.songee.songeebackend.repository.PairsRepository;
import com.songee.songeebackend.repository.UserProfileRepository;
import com.songee.songeebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PairsService {
    private final UserRepository userRepository;
    private final PairsRepository pairsRepository;
    private final UserProfileRepository userProfileRepository;

    public List<PairResponse> getPairs (String username){
        User user = userRepository.findByUsername(username).orElseThrow(()->new RuntimeException("User not found"));

        List<Pairs> pairs = pairsRepository.findUserPairs(user).orElseThrow(()->new RuntimeException("Pairs not found"));

        List<Integer> userIds = new ArrayList<>();

        for(Pairs pair : pairs){
            if(pair.getUser1().equals(user)) {
                userIds.add(pair.getUser2().getId().intValue());
            }else {
                userIds.add(pair.getUser1().getId().intValue());
            }
        }

        List<PairResponse> userPairs = new ArrayList<>();

        userIds.forEach(id -> {
            User xuser = userRepository.findUserById(id).orElseThrow(()->new RuntimeException("User not found"));
            UserProfile xuserProfile = userProfileRepository.findByUserId(id.longValue()).orElseThrow(() ->new RuntimeException("UserProfile not found"));
            userPairs.add(PairResponse.builder()
                            .username(xuser.getUsername())
                            .firstName(xuserProfile.getFirstName())
                            .avatar(xuserProfile.getAvatar())
                            .id(id.longValue())
                    .build()
            );
        });

        return userPairs;
    }
}
