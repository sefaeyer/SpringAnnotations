package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;

public class WhatsappService implements MessageService{

    private Repository repo;

    public WhatsappService(Repository repo) {
        this.repo = repo;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız whatsapp ile gönderiliyor... Mesaj: "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {

    }

}
