package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component//bu class in objeleri spring container tarafindan olusturulur ve yonetilir. bu objelere Spring Bean adi verilir.
@Scope("protoype")
public class SmsService implements MessageService {

    //  --> field injection yontemi
//    @Autowired//bagimliligin enjekte edilmesini saglar
//    @Qualifier("fileRepository")//birden fazla ayni data tipinde
//                                //bean varsa belirleyici gorevini gorur.
//    private Repository repo;

    //==================================================================================================

    //  --> setter injection yontemi
    private Repository repo;
    @Autowired
    @Qualifier("fileRepository")
    public void setRepo(Repository repo) {
        this.repo = repo;
    }

    //==================================================================================================

    //  --> constructor injection yontemi  --> daha guvenli, daha anlasilir, test etmesi daha kolaydir
//    private Repository repo;
//    @Autowired
//    public SmsService(@Qualifier("fileRepository") Repository repo) {
//        this.repo = repo;
//    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajiniz sms ile gonderiliyor... Mesaj: "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
        repo.save(message);
    }
}
