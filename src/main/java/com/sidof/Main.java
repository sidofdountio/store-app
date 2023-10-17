package com.sidof;

import com.sidof.security.model.Appuser;
import com.sidof.security.model.RegisterRequest;
import com.sidof.security.model.Token;
import com.sidof.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

import static com.sidof.security.model.Role.ROLE_ADMIN;
import static com.sidof.security.model.Role.ROLE_USER;

/**
 * @Author sidof
 * @Since 02/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {
            userService.register(new RegisterRequest("sidof", "sidof@gmail.com", "password"));
            userService.register(new RegisterRequest("yan", "yan@gmail.com", "password"));
        };
    }

}
