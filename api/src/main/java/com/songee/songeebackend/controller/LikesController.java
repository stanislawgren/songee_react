package com.songee.songeebackend.controller;

import com.songee.songeebackend.dto.CommonResponse;
import com.songee.songeebackend.dto.LikeRequest;
import com.songee.songeebackend.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/likes")
@CrossOrigin("*")
@RequiredArgsConstructor
public class LikesController {

    private final LikesService likesService;

    @PostMapping("/like")
    public ResponseEntity<CommonResponse> likeUser (@RequestBody LikeRequest like){

        CommonResponse response;

        try {
            response = likesService.likeUser(like);
        } catch (Exception e){
            return ResponseEntity.status(500).body(CommonResponse.builder().status("error").message(e.getMessage()).build());
        }
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/dislike")
    public ResponseEntity<CommonResponse> dislikeUser (@RequestBody LikeRequest like){
        try {
            likesService.dislikeUser(like);
        } catch (Exception e){
            return ResponseEntity.status(500).body(CommonResponse.builder().status("error").message(e.getMessage()).build());
        }
        return ResponseEntity.status(200).body(CommonResponse.builder().status("ok").build());
    }
}
