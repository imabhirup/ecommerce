package com.ecommerce.b2c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.ecommerce"})
@EntityScan("com.ecommerce.dao.entity")
@EnableJpaRepositories("com.ecommerce.dao.entity")
public class B2cApplication {

	public static void main(String[] args) {
		SpringApplication.run(B2cApplication.class, args);
	}

}
