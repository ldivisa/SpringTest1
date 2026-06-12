package org.hopto.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MainApp implements ApplicationRunner {
    private final  CasoJudicial casoJudicial;

   MainApp(CasoJudicial casoJudicial) {
      this.casoJudicial = casoJudicial;
   }
public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Aplicação iniciada com sucesso!");
        double custoFinal = casoJudicial.finalizarCusto(5000.0, "SP", 2005);
        System.out.println("Custo final do caso judicial: " + custoFinal);
    }
}



// This component will run after the application starts
