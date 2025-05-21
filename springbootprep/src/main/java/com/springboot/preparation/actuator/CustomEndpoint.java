package com.springboot.preparation.actuator;

import io.micrometer.core.annotation.Timed;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class CustomEndpoint {

    @ReadOperation
    @Timed("read.operation.ms")
    public String customEndpoint() throws InterruptedException {
        Thread.sleep(3000);
        return "Custom endpoint response";
    }
}