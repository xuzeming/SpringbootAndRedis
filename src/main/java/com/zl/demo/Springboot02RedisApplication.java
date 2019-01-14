package com.zl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.zl")
public class Springboot02RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot02RedisApplication.class, args);
	}

}

