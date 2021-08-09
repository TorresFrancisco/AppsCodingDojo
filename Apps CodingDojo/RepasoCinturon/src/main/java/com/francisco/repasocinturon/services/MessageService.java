package com.francisco.repasocinturon.services;

import com.francisco.repasocinturon.models.Message;
import com.francisco.repasocinturon.repository.MessageRepository;
import org.springframework.stereotype.Service;


@Service
public class MessageService extends BaseService<Message>{
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        super(messageRepository);
        this.messageRepository = messageRepository;
    }

}
