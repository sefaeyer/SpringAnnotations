package com.tpe.controller;

import com.tpe.domain.Message;
import com.tpe.repository.DbRepository;
import com.tpe.repository.Repository;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.WhatsappService;

public class MessageApplication {
    public static void main(String[] args) {

        Message message=new Message();
        message.setBody("Spring is coming :) ");


        //bu mesaji mail ile gonderelim
//        MailService mailService=new MailService();
//        mailService.sendMessage(message);

        //bu mesaji whatsapp ile gonderelim mail iptal // 1-service icin interface tanimlamaliydik
//        WhatsappService whatsappService=new WhatsappService();
//        whatsappService.sendMessage(message);

        //ref interface almaliydik
        Repository repo=new DbRepository();
        MessageService service=new MailService(repo);
        service.sendMessage(message);

        //newleyerek olusturuyoruz. maliyetli ve yonetimi zahmetli
        //newleyerek obje oluşturmak maliyetli, yönetimi zahmetli?

        //mesajı DB ye kaydedelim.
        service.saveMessage(message);

        //mesajı dosyaya kaydedelim.
        service.saveMessage(message);





    }
}
