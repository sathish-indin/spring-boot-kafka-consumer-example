package com.poc.lightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaConsumer {

    @Autowired
    private List<String> seatList;

    @KafkaListener(topics = "light", group = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
        if (message.equals("1")) { seatList.add("S21"); } else { seatList.remove("S21");}
    }



/*    @KafkaListener(topics = "light", group = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }*/


}
