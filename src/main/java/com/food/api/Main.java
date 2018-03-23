package com.food.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Client
public class Main {
	
    public static void main(String[] args) throws Exception {
    	SpringApplication.run(Main.class, args);
    }

}
