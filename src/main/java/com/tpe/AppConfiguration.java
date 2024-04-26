package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration//bu classta configurasyon ayarlari olacak
@ComponentScan("com.tpe")//bu pathtaki tum componentlari tarar
//dafeult path: AppConfiguration classinin icinde bulundugu path tanimlanir
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    //Springe ait bir interface, bean oluşturmadan enjekte edilebilir,
    // PropertySourcedaki dosyanın içindeki özelliklere(propertylere)
    // ve hatta uygulamanın çalıştığı ortam değişkenlerine
    // erişmemizi sağlayan metodlar içerir.
    @Autowired
    private Environment environment;

    @Bean//thirdParty class tan bean olusturulmasini saglar
    public Random random(){
        return new Random();
    }


    //value anotasyonu ile yaptigimiz islemi Environment ve Proporties Classi ile de yapabiliriz
    @Bean
    public Properties properties(){
        Properties properties=new Properties();//hash table i extend eder
        properties.put("mymail",environment.getProperty("eposta"));
        properties.put("myphone",environment.getProperty("phone"));
        return properties;
    }

}
