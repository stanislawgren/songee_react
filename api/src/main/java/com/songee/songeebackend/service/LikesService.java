package com.songee.songeebackend.service;

import com.songee.songeebackend.dto.CommonResponse;
import com.songee.songeebackend.dto.LikeRequest;
import com.songee.songeebackend.entity.Likes;
import com.songee.songeebackend.entity.Pairs;
import com.songee.songeebackend.entity.User;
import com.songee.songeebackend.repository.LikesRepository;
import com.songee.songeebackend.repository.PairsRepository;
import com.songee.songeebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikesService {

    private final UserRepository userRepository;
    private final LikesRepository likesRepository;
    private final PairsRepository pairsRepository;

    public CommonResponse likeUser (LikeRequest like){

        User user = userRepository.findById(like.user_id).orElseThrow();
        User likedUser = userRepository.findById(like.liked_id).orElseThrow();

        Optional<Likes> pairCheck = likesRepository.findByUserIdAndLikedId(likedUser, user);

        Boolean pairDetected = false;

        if(pairCheck.isPresent()){
            pairDetected = true;
        }

        if(pairDetected){
            likesRepository.save(Likes.builder()
                    .user(user)
                    .likedUser(likedUser)
                    .value(1)
                    .build()
            );

            pairsRepository.save(Pairs.builder().user1(user).user2(likedUser).build());

            return CommonResponse.builder().status("ok").message("NEW_PAIR").build();

        } else{
            likesRepository.save(Likes.builder()
                    .user(user)
                    .likedUser(likedUser)
                    .value(1)
                    .build()
            );
            return CommonResponse.builder().status("ok").build();
        }
    }

    public CommonResponse dislikeUser (LikeRequest like){

        User user = userRepository.findById(like.user_id).orElseThrow();
        User likedUser = userRepository.findById(like.liked_id).orElseThrow();

        likesRepository.save(Likes.builder()
                .user(user)
                .likedUser(likedUser)
                .value(0)
                .build()
        );

        return CommonResponse.builder().status("ok").build();
    }
}
