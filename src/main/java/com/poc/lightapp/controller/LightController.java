package com.poc.lightapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class LightController {

    @Autowired
private List<String> seatList;


    @GetMapping("/light/status")
    @ResponseBody
    public List<String> getStatus() {
       // seatList.add("21");
        return seatList;
    }
}
