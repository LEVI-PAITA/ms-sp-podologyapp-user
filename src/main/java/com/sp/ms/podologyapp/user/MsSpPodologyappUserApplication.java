package com.sp.ms.podologyapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sp.ms.podologyapp.user"})
public class MsSpPodologyappUserApplication {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(MsSpPodologyappUserApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		String password = "123456789";

		for (int i = 0; i < 4; i++) {
			String passwordBcrypt = passwordEncoder.encode(password);
			System.out.println(passwordBcrypt);
		}

	}

}
