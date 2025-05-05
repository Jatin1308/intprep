//package com.kafka.kafkaconsumer.listeners;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.KafkaHeaders;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.messaging.handler.annotation.Payload;
//
//public class KafkaConsumerListener {
//
//    @KafkaListener(topics = "jatinlocaltopic")
//    public void listenGroupFoo(String message){
//
//        System.out.println("Received message: "+message);
//
//    }
//}
