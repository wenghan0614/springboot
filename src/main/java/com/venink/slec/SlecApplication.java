package com.venink.slec;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.venink.slec.dao")
public class SlecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlecApplication.class, args);
	}

}
