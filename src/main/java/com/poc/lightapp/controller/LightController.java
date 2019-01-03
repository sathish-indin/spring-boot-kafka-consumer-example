package com.poc.lightapp.controller;

import com.mbed.coap.client.CoapClient;
import com.mbed.coap.client.CoapClientBuilder;
import com.mbed.coap.exception.CoapException;
import com.mbed.coap.packet.CoapPacket;
import com.mbed.coap.packet.MediaTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetSocketAddress;
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

    @PostMapping("/light/off")
    @ResponseBody
    public void switchOff() {
        System.out.println("inside light off");
        CoapClient client = null;
        try {
            client = CoapClientBuilder.newBuilder(new InetSocketAddress("localhost",5683)).build();
            CoapPacket coapResp = client.resource("/").payload("0", MediaTypes.CT_TEXT_PLAIN).sync().get();

            //coapResp = client.resource("/a/relay").payload("1", MediaTypes.CT_TEXT_PLAIN).sync().put();

            //it is important to close connection in order to release socket
            client.close();
        } catch (IOException | CoapException e) {
            e.printStackTrace();
        }


    }
}
