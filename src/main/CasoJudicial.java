package org.hopto.demo.util;

import org.springframework.stereotype.Component;

@Component
public class CasoJudicial {
    private CustoJudicial custoJudicial;
    private TaxaJudicial taxaJudicial;
    
    public CasoJudicial(CustoJudicial custo, TaxaJudicial taxa){
        this.custoJudicial = custo;
        this.taxaJudicial = taxa;
    }

    public double finalizarCusto(double custo, String estado, int anoJulgamento){
        custo += custoJudicial.adicionarCusto(anoJulgamento);
        custo += taxaJudicial.adicionarTaxa(estado);

        return custo;

    }

}