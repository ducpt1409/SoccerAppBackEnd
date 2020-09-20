package com.ptd.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"com.ptd"})
@EntityScan(basePackages = {"com.ptd.entity"})
public class SoccerAppServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoccerAppServerApplication.class, args);
    }

}
