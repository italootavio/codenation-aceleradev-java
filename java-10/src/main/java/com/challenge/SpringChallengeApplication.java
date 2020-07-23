package com.challenge;

import com.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringChallengeApplication {
	/*@Bean
	public CommandLineRunner init(@Autowired UserRepository user){
		return args -> {
			System.out.println("passoi");
			System.out.println(user.findById(9L));
		};
	}*/

	public static void main(String[] args) {
		SpringApplication.run(SpringChallengeApplication.class, args);
	}

}
