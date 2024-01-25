package com.example.kafkareceiver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class EventListener {

    @Bean
    public Consumer<String> demoMessageIn(){
        System.out.println("Consumer registriert");
        return event -> {

            System.out.println(event + " sicher empfangen");

        };
    }




}
