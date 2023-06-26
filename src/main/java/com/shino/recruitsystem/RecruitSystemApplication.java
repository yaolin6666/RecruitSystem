package com.shino.recruitsystem;

import com.shino.recruitsystem.Pojo.Account;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@MapperScan("com/shino/recruitsystem/Mapper")
@SpringBootApplication
public class RecruitSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitSystemApplication.class, args);
    }
}
