package com.songee.songeebackend.controller;

import com.songee.songeebackend.dto.UserDto;
import com.songee.songeebackend.entity.User;
import com.songee.songeebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.security.Principal;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repo;

    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers(){
        return ResponseEntity.ok("Działa");
    }

    @GetMapping("/user")
    public ResponseEntity<UserDto> getUser(Principal principal){

        Optional<User> userOptional = repo.findByUsername(principal.getName());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(UserDto
                    .builder()
                            .username(userOptional.get().getUsername())
                            .id(userOptional.get().getId())
                            .mail(userOptional.get().getMail())
                    .build());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<String> getUserById(@PathVariable Integer id){
        System.out.println(id);
        Optional<User> userOptional = repo.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Jeśli użytkownik został znaleziony, możesz zwrócić go jako ResponseEntity
            return ResponseEntity.ok("Użytkownik znaleziony: " + user.getUsername()); // Zakładając, że w klasie User istnieje metoda getName() zwracająca imię użytkownika
        } else {
            // Jeśli użytkownik o podanym identyfikatorze nie został znaleziony, możesz zwrócić odpowiedni komunikat
            return ResponseEntity.notFound().build();
        }
    }
}
