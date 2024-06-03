package com.songee.songeebackend.controller;

import com.songee.songeebackend.dto.BanRequest;
import com.songee.songeebackend.dto.CommonResponse;
import com.songee.songeebackend.dto.LikeRequest;
import com.songee.songeebackend.dto.UserDto;
import com.songee.songeebackend.entity.Likes;
import com.songee.songeebackend.entity.User;
import com.songee.songeebackend.entity.UserProfile;
import com.songee.songeebackend.repository.UserProfileRepository;
import com.songee.songeebackend.repository.UserRepository;
import com.songee.songeebackend.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AdminController {
    private final UserRepository repo;
    private final UserProfileRepository profileRepo;
    private final AdminService adminService;

    @PostMapping("/ban")
    public ResponseEntity<CommonResponse> test (@RequestBody BanRequest banRequest){
        return ResponseEntity.ok(adminService.banUser(banRequest));
    }

    @GetMapping("/users/list")
    public ResponseEntity<List<UserDto>> getAllUsers(Principal principal) {
        List<UserDto> userDtoList = new ArrayList<>();

        User userOptional = repo.findByUsername(principal.getName()).orElseThrow();

        List<User> users = repo.findAll();


        for (User user : users) {

                Optional<UserProfile> userProfile = profileRepo.findByUserId(user.getId());

                UserProfile profile = userProfile.orElse(null); // Zwróć null, jeśli brak profilu

                userDtoList.add(UserDto.builder()
                        .username(user.getUsername())
                        .id(user.getId())
                        .mail(user.getMail())
                        .age(profile != null ? profile.getAge() : null)
                        .location(profile != null ? profile.getLocation() : null)
                        .description(profile != null ? profile.getDescription() : null)
                        .favouriteArtist(profile != null ? profile.getFavouriteArtist() : null)
                        .favouriteSongTitle(profile != null ? profile.getFavouriteSongTitle() : null)
                        .favouriteSongArtist(profile != null ? profile.getFavouriteSongArtist() : null)
                        .lastName(profile != null ? profile.getLastName() : null)
                        .firstName(profile != null ? profile.getFirstName() : null)
                        .gender(profile != null ? profile.getGender() : null)
                        .avatar(profile != null ? profile.getAvatar() : null)
                        .status(user.getStatus())
                        .build());
            }
        return ResponseEntity.ok(userDtoList);
    }
}
