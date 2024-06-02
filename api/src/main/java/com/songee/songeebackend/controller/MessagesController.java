package com.songee.songeebackend.controller;

import com.songee.songeebackend.dto.CommonResponse;
import com.songee.songeebackend.dto.MessagesDTO;
import com.songee.songeebackend.service.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin("*")
@RequiredArgsConstructor
public class MessagesController {

    private final MessagesService messagesService;

    @PostMapping("/send")
    public ResponseEntity<CommonResponse> sendMessage(@RequestBody MessagesDTO messagesDTO) {
        try {
            return ResponseEntity.ok(messagesService.sendChatMessage(messagesDTO));
        } catch (Exception e) {
            return ResponseEntity.ok(CommonResponse.builder().status("error").message(e.getMessage()).build());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<MessagesDTO>> getMessagesByUser(@PathVariable Integer id, Principal principal){
        try {
            return ResponseEntity.ok(messagesService.getMessagesByUser(id, principal.getName()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(List.of(MessagesDTO.builder().build()));
        }
    }
}
