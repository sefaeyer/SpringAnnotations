package com.tpe.controller;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SlackService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class MessageApplicationSpring {
    public static void main(String[] args) {

        Message message=new Message();
        message.setBody("Spring has come :)");

        //configurasyon class ini okur ve componentscan ile componentlari ve beanlari tarar
        //ve her birinden sadece 1 tane Spring bean olusturur ve context e atar ve hazir olarak bekletir.
        //bean istendiginde gerekliyse icine bagimliligini da enjekte ederek gonderir
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);

        //mesajimizi SmsService ile gonderelim.
        MessageService service=context.getBean(SmsService.class);//newlemedim, rica ettik
        service.sendMessage(message);

        MessageService service2=context.getBean(SmsService.class);
        service2.sendMessage(message);

        //mesajimizi SmsService ile gonderelim.
      //  MessageService service3=context.getBean(SlackService.class);
        MessageService service3=context.getBean("slack_service",MessageService.class);
        service3.sendMessage(message);
        //getBean metoduna parametre olarak parentı verirsek ve birden fazla childı varsa
        //beanin ismini de belirtmeliyiz.
        service3.saveMessage(message);


        //bagimlilik varsa ne olur?
//        MessageService service4=context.getBean("smsService",MessageService.class);
//        service4.saveMessage(message);//smsService i newlemedik
                                      //service repoya bagimli ama biz enjekte etmedik
                                      //repo objesini de biz olusturmadik
                                      //Spring sagolsun ***



        //smsServicede setter injection yapılırsa sonradan repo değiştirilebilir.

//        SmsService service5=context.getBean(SmsService.class);
//        service5.saveMessage(message);
//        Repository repository=context.getBean(DbRepository.class);
//        service5.setRepo(repository);
//        service5.saveMessage(message);




        //random bi deger yazdirmak istiyorum
//        Random random=new Random();
//        Random random=context.getBean(Random.class);
//        System.out.println(random.nextInt(100));


        //bean scope
        //1-singleton
        //sadece 1 tane bean uretilir her istekte ayni bean verilir
        // beanin tum life cycle indan Spring sorumludur.


        //2-prototype
        //her istekte yeni bir bean uretilip gonderilir
        //beanin imhasindan Spring Sorumlu Degildir


        MessageService service6=context.getBean(SmsService.class);
        MessageService service7=context.getBean(SmsService.class);


        if (service6==service7){
            System.out.println("ayni objeler");
            System.out.println(service6);
            System.out.println(service7);
        }else{
            System.out.println("farkli objeler");
            System.out.println(service6);
            System.out.println(service7);
        }

        System.out.println("----------------------------------------------------------");
        SlackService service8=context.getBean(SlackService.class);
        service8.printContact();


        System.out.println("---------------------Properties ile--------------------------------------");
        service8.getContact();
        System.out.println("--------------------------------------------------------------");



        context.close();
        System.out.println("context kapatildi");
        //context.getBean(SmsService.class);//  hata verir

    }
}
