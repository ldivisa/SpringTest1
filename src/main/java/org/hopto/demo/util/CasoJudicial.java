package org.hopto.demo.util;

import org.springframework.stereotype.Component;

@Component
public class CasoJudicial {
    private CustoJudicial custoJudicial = new CustoJudicial();
    private TaxaJudicial taxaJudicial = new TaxaJudicial();


public double finalizarCusto(double custo, String estado, int anoJulgamento) {
    custo += custoJudicial.adicionarCusto(anoJulgamento);
    custo += taxaJudicial.adicionarTaxa(estado);
return custo;
}
}

