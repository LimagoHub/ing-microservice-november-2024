package de.limago.dlq;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class EventListener {

    @Bean
    public Consumer<ScoringEvent> kreditantragregistriert(){
        return event -> {

            //System.out.println(event.getCreditApplicationId() + " sicher empfangen");
            throw new NullPointerException("Bad");
        };
    }




}
