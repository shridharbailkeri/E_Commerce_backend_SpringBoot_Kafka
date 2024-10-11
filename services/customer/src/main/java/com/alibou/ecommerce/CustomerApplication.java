package com.alibou.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApplication {

	//run config server
	// run discovery server
	// run customer server


	// start building customer microservice because it does not have any dependency with other microservice, similar for product and payment

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
