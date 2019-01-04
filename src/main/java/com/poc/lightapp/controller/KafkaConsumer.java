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

        //int val=Integer.parseInt(message);
        float fVal = Float.parseFloat(message);
        System.out.println(Math.round(fVal));
        if (Math.round(fVal) == 1) { seatList.remove("S21"); } else { seatList.add("S21");}
    }

}
