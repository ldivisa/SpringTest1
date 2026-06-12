package org.hopto.demo.util;

import org.springframework.stereotype.Component;

@Component
public class CustoJudicial {

    
    public double adicionarCusto(int ano)
    {
        if (ano < 2000){
            return 1000.0;
        } else if (ano >= 2000 && ano < 2010){
            return 2000.0;
        } else {
            return 3000.0;
        }
    }
    public CustoJudicial(Integer ano){
        if (ano < 2000){
            this.custo = 1000.0;
        } else if (ano >= 2000 && ano < 2010){
            this.custo = 2000.0;
        } else {
            this.custo = 3000.0;
        }

    }
}
