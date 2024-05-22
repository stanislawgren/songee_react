package com.songee.songeebackend.service;

import com.songee.songeebackend.config.JwtService;
import com.songee.songeebackend.dto.AuthRequest;
import com.songee.songeebackend.dto.AuthResponse;
import com.songee.songeebackend.dto.LoginRequest;
import com.songee.songeebackend.entity.Role;
import com.songee.songeebackend.entity.User;
import com.songee.songeebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repo;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    public AuthResponse register(AuthRequest request){
        var user = User.builder().role(Role.USER).username(request.getUsername()).mail(request.getMail()).password(passwordEncoder.encode(request.getPassword())).build();

        repo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repo.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }
}
