package com.smat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.smat")
public class SmatBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmatBeApplication.class, args);
	}

}
