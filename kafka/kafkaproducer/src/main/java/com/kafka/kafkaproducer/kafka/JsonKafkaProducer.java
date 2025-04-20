package com.kafka.kafkaproducer.kafka;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.kafkaproducer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private KafkaTemplate<String, User> jsonKafkaTemplate;
    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.jsonKafkaTemplate = kafkaTemplate;
    }

    public void sendUserDetails(User userDetails) throws JsonProcessingException {

//        String u = new ObjectMapper().writeValueAsString(userDetails);
//        log.info("JsonConvertedString {}", u);
        Message<User> msg = MessageBuilder.withPayload(userDetails)
                .setHeader(KafkaHeaders.TOPIC,"jatinlocal")
                .build();

        jsonKafkaTemplate.send(msg);
        log.info("Sent the userDetails: {}....{}", userDetails, msg.toString());
    }




}
