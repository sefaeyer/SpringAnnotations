package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component//bu classın objeleri Spring tarafından oluşturulur ve yönetilir ve bu objelere Spring Bean adı verilir.
@Scope("prototype")
public class SmsService implements MessageService{

    @PostConstruct
    public void postConstruct(){
        System.out.println("----> SmsService objesi üretildi.");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("<---- SmsService objesi imha edildi.");
    }

    //field injection
//    @Autowired//bağımlılığın enjekte edilmesini sağlar
//    @Qualifier("fileRepository")//birden fazla aynı data tipinde bean varsa belirleyici görevini görür.
//    private Repository repo;

    //------------------------------------------------------------------------------------

    //setter  injection
    private Repository repo;

    @Autowired
    @Qualifier("fileRepository")
    public void setRepo(Repository repo) {
        this.repo = repo;
    }

    //------------------------------------------------------------------------------------

    //constructor injection:daha güvenli,daha anlaşılır,test etmesi daha kolay
/*    private final Repository repo;

    @Autowired
    public SmsService(@Qualifier("fileRepository") Repository repo) {
        this.repo = repo;
    }*/

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız sms ile gönderiliyor...Mesaj : "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
        repo.save(message);

    }
}