package com.example.simplememo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.simplememo.mapper")
public class SimplememoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplememoApplication.class, args);
	}

}
