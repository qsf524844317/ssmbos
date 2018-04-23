package com.qusf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement//开启事物注解
@ComponentScan(basePackages = "com.qusf")
public class SsmbosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsmbosApplication.class, args);
	}
}
