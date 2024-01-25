package com.example.rabbitmqsender.emitter;


import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventEmitter {

    private static final String SUPPLIER_BINDIN_NAME = "demoMessageOut-out-0";
    private final StreamBridge bridge;



    public void send(String data) {
        // Fire extern event
        //System.out.println("EventEmitter");
        System.out.println(bridge.send(SUPPLIER_BINDIN_NAME, data));
    }

}
