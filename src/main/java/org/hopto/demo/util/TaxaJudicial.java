package org.hopto.demo.util;

import org.springframework.stereotype.Component;

@Component
public class TaxaJudicial {
    public TaxaJudicial() {
    }

    public double adicionarTaxa(String estado){
        if estado.toUpperCase().equals("SP")){
            return 0.1;
        } else if (estado.toUpperCase().equals("RJ")){
            return 0.15;
        } else {
            return 0.05;
        }}}
        

    
