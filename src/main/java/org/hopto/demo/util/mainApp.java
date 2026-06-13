package org.hopto.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class mainApp implements  CommandLineRunner{
 @Autowired
    private CasoJudicial casoJudicial;

public static void main(String[] args) {
        SpringApplication.run(mainApp.class, args);
    }
@Override
    public void run(String... args) throws Exception {
        double custoFinal = casoJudicial.finalizarCusto(10000, "SP",2005);
        System.out.println("Custo final do caso judicial: " + custoFinal);
    }
}




// This component will run after the application starts
