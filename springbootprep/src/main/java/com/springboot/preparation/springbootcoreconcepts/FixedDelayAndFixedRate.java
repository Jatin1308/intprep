package com.springboot.preparation.springbootcoreconcepts;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class FixedDelayAndFixedRate {

    @Scheduled(fixedDelay = 5000)
    public void fixedDelay(){
        System.out.println("Fixed Delay Task: "+System.currentTimeMillis());
    }


    @Scheduled(fixedRate = 1000)
    // if the taskTime >  fixedRate -> it will wait for the task to get completed, bcoz it works in single threaded mode by default
    // but if we use @Async it will not wait for task to be completed after fixedRate it will start the task
    public void executeTask() throws InterruptedException {
        Thread.sleep(6000);
        System.out.println("Fixed rate task - " + System.currentTimeMillis());
    }


}
