package com.springboot.preparation.controller;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DummyController {

    @GetMapping("/hello")
    public String getHello(){
        return "This is from the controller";
    }


    @GetMapping("/circutibreaker")
    @CircuitBreaker(name="CircuitBreakerService",fallbackMethod = "getErrorCircuit")
    public String breakCircuit() throws Exception{
        System.out.println("Inside circuit brekaer controller");

        String resp = new RestTemplate().getForObject("http://localhost:9090/test",String.class);

        return resp;
    }

    public String getErrorCircuit(Throwable throwable){
        return "From CircuitBreaker FallBack method";
    }
}
