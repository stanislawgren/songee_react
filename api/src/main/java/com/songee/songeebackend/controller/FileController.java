package com.songee.songeebackend.controller;

import com.songee.songeebackend.entity.User;
import com.songee.songeebackend.entity.UserProfile;
import com.songee.songeebackend.repository.UserProfileRepository;
import com.songee.songeebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

@RestController
@RequestMapping("/api/file")
@CrossOrigin("*")
@RequiredArgsConstructor
public class FileController {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    @PostMapping("/avatar")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, Principal principal) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }

        User user = userRepository.findByUsername(principal.getName()).orElseThrow();

        UserProfile userProfile = userProfileRepository.findByUserId(user.getId()).orElseThrow();

        Path path = Paths.get("uploads/");

        try {
            InputStream input = file.getInputStream();
            Files.copy(input, path.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            userProfile.setAvatar("uploads/" + file.getOriginalFilename());
            userProfileRepository.save(userProfile);
            return ResponseEntity.ok("dziala");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error uploading file: " + e.getMessage());
        }
    }
}
