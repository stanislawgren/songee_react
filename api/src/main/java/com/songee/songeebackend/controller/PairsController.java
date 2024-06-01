package com.songee.songeebackend.controller;

import com.songee.songeebackend.dto.PairResponse;
import com.songee.songeebackend.entity.Pairs;
import com.songee.songeebackend.service.PairsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/pair")
@CrossOrigin("*")
@RequiredArgsConstructor
public class PairsController {

    private final PairsService pairsService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getPairDetails(@PathVariable Integer id){
        return ResponseEntity.ok("User " + id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PairResponse>> getAllPairs(Principal principal){
        try {
            return ResponseEntity.ok(pairsService.getPairs(principal.getName()));
        } catch (Exception e){
            return ResponseEntity.status(500).body(List.of(PairResponse.builder().build()));
        }
    }
}
