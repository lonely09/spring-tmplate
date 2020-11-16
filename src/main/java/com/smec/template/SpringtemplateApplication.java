package com.smec.template;

import com.smec.pri.client.EnableSmecWebAuthClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSmecWebAuthClient
public class SpringtemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringtemplateApplication.class, args);
    }

}
