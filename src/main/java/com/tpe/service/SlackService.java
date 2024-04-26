package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;
import java.util.Random;

@Component("slack_service")
public class SlackService implements MessageService{

    @PostConstruct
    public void postConstruct(){
        System.out.println("----> SlackService objesi üretildi.");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("<---- SlackService objesi imha edildi.");
    }

    @Autowired
    private Random random;
    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesaj Slack ile gönderiliyor. Mesaj : "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
        // Random random=new Random();
        System.out.println(random.nextInt());

    }

    @Value("${eposta}")
    private String email;

    @Value("${phone}")
    private String phone;

    public void printContact(){
        System.out.println("e-mail : "+this.email);
        System.out.println("phone : "+this.phone);
    }

    @Autowired
    private Properties properties;

    public void getContact(){
        System.out.println("e-mail : "+properties.getProperty("mymail"));
        System.out.println("phone : "+properties.getProperty("myphone"));
    }
}