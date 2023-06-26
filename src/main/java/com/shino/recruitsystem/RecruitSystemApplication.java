package com.shino.recruitsystem;

import com.shino.recruitsystem.Component.Security.MapAccountRepository;
import com.shino.recruitsystem.Pojo.Account;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import java.util.HashMap;
import java.util.Map;

@MapperScan("com/shino/recruitsystem/Mapper")
@SpringBootApplication
public class RecruitSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitSystemApplication.class, args);
    }

    @Bean
    MapAccountRepository userRepository() {
        // the hashed password was calculated using the following code
        // the hash should be done up front, so malicious users cannot discover the
        // password
        // PasswordEncoder encoder =
        // PasswordEncoderFactories.createDelegatingPasswordEncoder();
        // String encodedPassword = encoder.encode("password");

        // the raw password is "password"
        String encodedPassword = "{bcrypt}$2a$10$h/AJueu7Xt9yh3qYuAXtk.WZJ544Uc2kdOKlHu2qQzCh/A3rq46qm";

        Account customUser = new Account(1L, "user@example.com", encodedPassword,"admin",1);
        Map<String, Account> emailToCustomUser = new HashMap<>();
        emailToCustomUser.put(customUser.getUsername(), customUser);
        return new MapAccountRepository(emailToCustomUser);
    }

}
