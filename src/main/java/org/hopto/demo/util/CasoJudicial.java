package org.hopto.demo.util;


public class CasoJudicial {
    private long id;
    private double valor;
    private int ano;
    private double custo;
    private String estado;
    private int anoJulgamento;
    private CustoJudicial custoJudicial;
    private TaxaJudicial taxaJudicial;  
    

public CasoJudicial(long id, double custo, String estado, int anoJulgamento) {
    this.id=id;
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

 
    // Getters (Essenciais para conversores de JSON lerem os dados)
    public long getId() { return id; }  
    public double getCusto() { return custo; }
    public String getEstado() { return estado; }
    public int getAnoJulgamento() { return anoJulgamento; }


    public void add(CasoJudicial caso) {
        casos.add(caso);
        
    }

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
