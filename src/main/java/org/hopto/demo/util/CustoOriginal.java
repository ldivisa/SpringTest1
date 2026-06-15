package org.hopto.demo.util;

import org.springframework.stereotype.Component;

@Component
public class CustoOriginal {
    private double custo;   

    public double getCusto() {
        return custo;
    }       
    public void setCusto(double custo) {
        this.custo = custo;
    }

}
