package com.ntndev.phase1student;

import com.ntndev.phase1student.dto.request.RegisterRequest;
import com.ntndev.phase1student.service.AuthenticationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.ntndev.phase1student.model.Role.ADMIN;
import static com.ntndev.phase1student.model.Role.MANAGER;

@SpringBootApplication
public class Phase1studentApplication {

    public static void main(String[] args) {
        SpringApplication.run(Phase1studentApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthenticationService service){
        return args -> {
          var admin = RegisterRequest.builder()
                  .firstname("Admin")
                  .lastname("Admin")
                  .email("admin@gmail.com")
                  .password("password")
                  .role(ADMIN)
                  .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .firstname("Manager")
                    .lastname("Manager")
                    .email("manager@gmail.com")
                    .password("password")
                    .role(MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());
        };
    }

}
