package com.group13.footballer.Services;


import com.group13.footballer.Models.Message;
import com.group13.footballer.Repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;



    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

}