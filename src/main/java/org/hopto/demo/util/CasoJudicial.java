package org.hopto.demo.util;

import org.springframework.beans.factory.annotation.Autowired;


public class CasoJudicial {
    private long id;
    private double valor;
    private int ano;
    private double custo;
    private String estado;
    private int anoJulgamento;
    
@Autowired
public CasoJudicial(double custo, String estado, int anoJulgamento) {
    private final CustoJudicial custoJudicial;
    private final TaxaJudicial taxaJudicial;  
    this.custo = custo;
    this.estado = estado;
    this.anoJulgamento = anoJulgamento;
}
@Autowired
public double finalizarCusto(double custo, String estado, int anoJulgamento) {
    this.custo = custo;
    this.estado = estado;
    this.anoJulgamento = anoJulgamento;
    this.custo += custoJudicial.adicionarCusto(this.anoJulgamento);
    this.custo += taxaJudicial.adicionarTaxa(this.estado);
    return this.custo;
}

 
    // Getters (Essenciais para conversores de JSON lerem os dados)
    public long getId() { return id; }  
    public double getCusto() { return custo; }
    public String getEstado() { return estado; }
    public int getAnoJulgamento() { return anoJulgamento; }
    

    // toString (Essencial se você estiver usando System.out.println)
    @Override
    public String toString() {
        return "CasoJudicial{" +
                "valor=" + valor +
                ", estado='" + estado + '\'' +
                ", ano=" + ano +
                '}';
    }

    
}
