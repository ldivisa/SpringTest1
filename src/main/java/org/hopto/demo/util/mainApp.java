package org.hopto.demo.util;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class mainApp implements ApplicationRunner {
    private final  CasoJudicial casoJudicial;

   mainApp(CasoJudicial casoJudicial) {
      this.casoJudicial = casoJudicial;
   }
public static void main(String[] args) {
        SpringApplication.run(mainApp.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Aplicação iniciada com sucesso!");
        double custoFinal = casoJudicial.finalizarCusto(5000.0, "SP", 2005);
        System.out.println("Custo final do caso judicial: " + custoFinal);
    }
}



// This component will run after the application starts
