package org.hopto.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class CasoJudicialService {

    private ArrayList<CasoJudicial> casos;
    
    
    public CasoJudicialService() {
        casos = new ArrayList<>(Arrays.asList(
            new CasoJudicial(1,1000.0, "RJ", 2001), 
            new CasoJudicial(2,2000.0, "SP", 2002),
            new CasoJudicial(3,3000.0, "MG", 2003) ,
            new CasoJudicial(4,4000.0, "BA", 2004)           
        
        ));
    }
    public ArrayList<CasoJudicial> getTodosOsCasos() {
        casos.sort((c1, c2) -> Long.compare(c1.getId(), c2.getId()))    ;      
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
}
