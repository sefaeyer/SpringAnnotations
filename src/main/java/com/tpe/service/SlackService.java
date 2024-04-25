package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("slack_service")
public class SlackService implements MessageService{

    @Autowired
    private Random random;
    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesaj Slack ile gidiyor: "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
//        Random random=new Random();
        System.out.println(random.nextInt(100));

    }
}
