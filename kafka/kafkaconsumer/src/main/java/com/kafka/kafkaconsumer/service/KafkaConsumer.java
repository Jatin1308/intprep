package com.kafka.kafkaconsumer.service;


import com.kafka.kafkaconsumer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger log  = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "jatinlocal",groupId = "mygroup")
    public void consume(String msg){

        log.info("Message received: {}", msg);

    }


    @KafkaListener(topics="jatinlocal",groupId = "mygroup")
    public void jsonConsumer(User user){

        log.info("Recieved json message: {}", user);

    }


}
