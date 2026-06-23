package org.hopto.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.springframework.stereotype.Service;

@Service
public class CasoJudicialService  {
    private ArrayList<CasoJudicial> casos;
    
    public CasoJudicialService() {
        casos = new ArrayList<>(Arrays.asList(
            new CasoJudicial(new CustoJudicial(),new TaxaJudicial(),1,1000.0, "RJ", 2111), 
            new CasoJudicial(new CustoJudicial(),new TaxaJudicial(),2,2000.0, "SP", 2005),
            new CasoJudicial(new CustoJudicial(),new TaxaJudicial(),3,3000.0, "MG", 1995) ,
            new CasoJudicial(new CustoJudicial(),new TaxaJudicial(),4,4000.0, "BA", 2015)           
        ));}

            public ArrayList<CasoJudicial> getTodosOsCasos() {
                casos.sort(Comparator.comparing(CasoJudicial::getId));
                return casos;
     }
    
    public CasoJudicial getCasoPorId(Long id) {
        return casos.stream()
                    .filter(caso -> caso.getId()==(id))
                    .findFirst()
                    .orElse(null);           
    }
    
    public void adicionarCaso(CasoJudicial caso){
         casos.add(caso);
    }   

    public void substituirCaso(Long id, CasoJudicial casoAtualizado){
        casos.remove(getCasoPorId(id));
        casos.add(casoAtualizado);
    }

    public void deletarCaso(Long ids){
        casos.remove(getCasoPorId(ids)); 
}
        public boolean existe(CasoJudicial novoCaso) {
                boolean resultado = casos.stream().anyMatch(caso -> caso.getId()==(novoCaso.getId()));
               //Sstem.out.println(resultado);
                return resultado;
                
         
        }

                    
    }


