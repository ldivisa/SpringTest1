package org.hopto.demo.util;

import org.springframework.beans.factory.annotation.Autowired;


public class CasoJudicial {
    private double custo;
    private String estado;
    private int anoJulgamento;
    private CustoJudicial custoJudicial;
    private TaxaJudicial taxaJudicial;  
    
@Autowired
public CasoJudicial(double custo, String estado, int anoJulgamento) {
    this.custo = custo;
    this.estado = estado;
    this.anoJulgamento = anoJulgamento;
}

public double finalizarCusto(double custo, String estado, int anoJulgamento) {
    this.custo = custo;
    this.estado = estado;
    this.anoJulgamento = anoJulgamento;
    this.custo += custoJudicial.adicionarCusto(this.anoJulgamento);
    this.custo += taxaJudicial.adicionarTaxa(this.estado);
    return this.custo;
}
}

