package com.lakshancd.finance.internet_banking_user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InternetBankingUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternetBankingUserServiceApplication.class, args);
	}

}
