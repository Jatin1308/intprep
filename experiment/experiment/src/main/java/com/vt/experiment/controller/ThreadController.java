package com.vt.experiment.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread")
public class ThreadController {

    @GetMapping("/name")
    public String getThreadName() throws InterruptedException {
        String name = Thread.currentThread().toString();
        System.out.println("Thread Name: "+name);
        Thread.sleep(5000);
        return name;
    }
}
