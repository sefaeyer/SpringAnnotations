package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration//bu classta configurasyon ayarlari olacak
@ComponentScan("com.tpe")//bu pathtaki tum componentlari tarar
//dafeult path: AppConfiguration classinin icinde bulundugu path tanimlanir
public class AppConfiguration {

    @Bean//thirdParty class tan bean olusturulmasini saglar
    public Random random(){
        return new Random();
    }


}
