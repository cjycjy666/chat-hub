package com.cjy.chathubbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cjy.chathubbackend.mapper")
public class ChatHubBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatHubBackendApplication.class, args);
    }

}
