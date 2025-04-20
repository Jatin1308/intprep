package com.streamwikimedia;

import com.streamwikimedia.producers.WikiMediaChangesProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class);
        System.out.println("******************* STARTED PRODUCER APPLICATION *******************");

    }

    @Autowired
    private WikiMediaChangesProducer wikiMediaChangesProducer;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Will be starting the wikiMedia changes producer");
        wikiMediaChangesProducer.sendMessage();


    }
}