package com.kafka.kafkaconsumer.controller;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {


    @GetMapping("/ping")
    public String checkOnline(){
        return "I am Online!!!";
    }


}
