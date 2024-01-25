package de.limago.dlq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeadLetterQueueExample {

    public static void main(String[] args) {
        SpringApplication.run(DeadLetterQueueExample.class, args);
    }

}
