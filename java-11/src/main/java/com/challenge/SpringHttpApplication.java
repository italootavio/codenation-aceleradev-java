package com.challenge;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@EnableJpaAuditing
@SpringBootApplication
public class SpringHttpApplication {
    public CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {

            //userRepository.save(user);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringHttpApplication.class, args);
    }

}
