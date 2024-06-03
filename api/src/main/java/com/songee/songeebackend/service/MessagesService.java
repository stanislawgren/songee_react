package com.songee.songeebackend.service;

import com.songee.songeebackend.dto.CommonResponse;
import com.songee.songeebackend.dto.MessagesDTO;
import com.songee.songeebackend.entity.Messages;
import com.songee.songeebackend.entity.User;
import com.songee.songeebackend.repository.MessagesRepository;
import com.songee.songeebackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessagesService {
    private final UserRepository userRepository;
    private final MessagesRepository messagesRepository;

    public List<MessagesDTO> getMessagesByUser (Integer userId, String username){
        User user = userRepository.findById(userId).orElse(null);
        User user2 = userRepository.findByUsername(username).orElseThrow();

        List<Messages> messages = messagesRepository.findRoomMessages(user, user2).orElseThrow();

        List<MessagesDTO> messagesDTOList = new ArrayList<>();

        for(Messages message: messages){
            messagesDTOList.add(MessagesDTO.builder()
                    .receiver(message.getReceiver().getId().intValue())
                    .sender(message.getSender().getId().intValue())
                    .message(message.getMessage())
                    .build()
            );
        }

        return messagesDTOList;
    }

    public CommonResponse sendChatMessage (MessagesDTO messagesDTO){

        User receiver = userRepository.findUserById(messagesDTO.receiver).orElseThrow(()->new RuntimeException("User not found"));

        User sender = userRepository.findUserById(messagesDTO.sender).orElseThrow(()->new RuntimeException("User not found"));

        Messages message = Messages.builder()
                .receiver(receiver)
                .sender(sender)
                .message(messagesDTO.message)
                .build();

        messagesRepository.save(message);

        return CommonResponse.builder().status("ok").message("MESSAGE_SENT").build();
    }
}
