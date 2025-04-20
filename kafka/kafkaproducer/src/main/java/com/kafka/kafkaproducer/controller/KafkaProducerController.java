package com.kafka.kafkaproducer.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.kafkaproducer.kafka.JsonKafkaProducer;
import com.kafka.kafkaproducer.kafka.KafkaProducer;

import com.kafka.kafkaproducer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class
KafkaProducerController {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducerController.class);
    @Autowired
    KafkaProducer kafkaProducer;

    @Autowired
    JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("/send")
    public void postMessage(@RequestParam("msg") String msg){
        kafkaProducer.sendMessage(msg);
    }


    @PostMapping("/user")
    public String sendUser(@RequestBody User user) throws JsonProcessingException {
        log.info("Received request: {}", user);
        jsonKafkaProducer.sendUserDetails(user);

        return "Sent user: "+user;

    }


}
