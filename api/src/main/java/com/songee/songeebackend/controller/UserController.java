package com.songee.songeebackend.controller;

import com.songee.songeebackend.dto.UserDto;
import com.songee.songeebackend.entity.User;
import com.songee.songeebackend.entity.UserProfile;
import com.songee.songeebackend.repository.UserProfileRepository;
import com.songee.songeebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.security.Principal;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repo;
    private final UserProfileRepository profileRepo;


    @GetMapping("/user")
    public ResponseEntity<UserDto> getUser(Principal principal) {

        Optional<User> userOptional = repo.findByUsername(principal.getName());

        System.out.println(userOptional);


        if (userOptional.isPresent()) {

            User user = userOptional.get();

            Optional<UserProfile> userProfile = profileRepo.findByUserId(user.getId());


            if (userProfile.isPresent()) {

                UserProfile profile = userProfile.get();


                if (profile != null) {
                    return ResponseEntity.ok(UserDto
                            .builder()
                            .username(user.getUsername())
                            .id(user.getId())
                            .mail(user.getMail())
                            .age(profile.getAge())
                            .location(profile.getLocation())
                            .description(profile.getDescription())
                            .favouriteArtist(profile.getFavouriteArtist())
                            .favouriteSongTitle(profile.getFavouriteSongTitle())
                            .favouriteSongArtist(profile.getFavouriteSongArtist())
                            .lastName(profile.getLastName())
                            .firstName(profile.getFirstName())
                            .gender(profile.getGender())
                            .avatar(profile.getAvatar())
                            .build());
                } else {
                    return ResponseEntity.ok(UserDto
                            .builder()
                            .username(user.getUsername())
                            .id(user.getId())
                            .mail(user.getMail())
                            .build());
                }
            } else {
                return ResponseEntity.notFound().build();
            }

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/users/list")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();

        // Pobierz wszystkich użytkowników z repozytorium
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
                    .build());
        }

        return ResponseEntity.ok(userDtoList);
    }

    @PutMapping("/user/update/details")
    public ResponseEntity<UserProfile> updateUserDetails(@RequestBody UserDto userDTO) {
        Optional<UserProfile> optionalUser = profileRepo.findByUserId(userDTO.id);

        if (!optionalUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        UserProfile user = optionalUser.get();

        user.setAge(userDTO.age != 0 ? userDTO.age : null);
        user.setDescription(userDTO.description != "" ? userDTO.description : null);
        user.setGender(userDTO.gender);
        user.setLocation(userDTO.location != "" ? userDTO.location : null);
        user.setFavouriteArtist(userDTO.favouriteArtist != "" ? userDTO.favouriteArtist : null);
        user.setLastName(userDTO.lastName != "" ? userDTO.lastName : null);
        user.setFirstName(userDTO.firstName != "" ? userDTO.firstName : null);
        user.setFavouriteSongArtist(userDTO.favouriteSongArtist != "" ? userDTO.favouriteSongArtist : null);
        user.setFavouriteSongTitle(userDTO.favouriteSongTitle != "" ? userDTO.favouriteSongTitle : null);

        UserProfile updatedUser = profileRepo.save(user);

        System.out.println(updatedUser);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<String> getUserById(@PathVariable Integer id){
        System.out.println(id);
        Optional<User> userOptional = repo.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok("Użytkownik znaleziony: " + user.getUsername()); // Zakładając, że w klasie User istnieje metoda getName() zwracająca imię użytkownika
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
