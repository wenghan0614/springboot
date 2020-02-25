package com.venink.slec;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(value = "com.venink.slec.dao")//设置mapper类扫描位置
@EnableTransactionManagement//开启事务
public class SlecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SlecApplication.class, args);
	}

}
