package com.shino.recruitsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com/shino/recruitsystem/Mapper")
@SpringBootApplication
public class RecruitSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitSystemApplication.class, args);
    }

}
