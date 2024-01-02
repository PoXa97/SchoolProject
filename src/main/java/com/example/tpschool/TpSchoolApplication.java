package com.example.tpschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@SpringBootApplication
@EnableWebMvc
public class TpSchoolApplication{

    public static void main(String[] args) {
        SpringApplication.run(TpSchoolApplication.class, args);
    }

}
