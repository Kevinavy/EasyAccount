package com.kevinavy.easyaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
public class EasyAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyAccountApplication.class, args);
    }

}
