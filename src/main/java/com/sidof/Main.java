package com.sidof;

import com.sidof.security.Appuser;
import com.sidof.security.Role;
import com.sidof.security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

/**
 * @Author sidof
 * @Since 02/08/2023
 * @Version v1.0
 * @YouTube @sidof8065
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
    @Bean
    CommandLineRunner commandLineRunner(UserService userService){
        return args -> {
            userService.save(new Appuser(null, "sidof", "sidof@gmail.com", "password", true,new ArrayList<>()));
            userService.saverole(new Role(null,"ROLE_ADMIN"));
            userService.saverole(new Role(null,"ROLE_MANAGER"));
            userService.saverole(new Role(null,"ROLE_USER"));
            userService.addRoleToUser("ROLE_ADMIN","sidof");
        };
    }
}
