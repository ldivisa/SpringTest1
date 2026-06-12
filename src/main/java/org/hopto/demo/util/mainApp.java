package org.hopto.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class mainApp implements ApplicationRunner {
    @Autowired
    private CasoJudicial casoJudicial;
    
    public static void main(String[] args) {
        SpringApplication.run(mainApp.class, args);
        System.out.println("Aplicação iniciada com sucesso!");

    }
    }
