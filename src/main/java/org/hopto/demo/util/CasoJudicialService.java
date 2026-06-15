package org.hopto.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CasoJudicialService {

    private ArrayList<CasoJudicial> casos;
    
    
    public CasoJudicialService() {
        casos = new ArrayList<CasoJudicial>(Arrays.asList(
            new CasoJudicial(1000.0, "RJ", 2111), 
            new CasoJudicial(2000.0, "SP", 2005),
            new CasoJudicial(3000.0, "MG", 1995) ,
            new CasoJudicial(4000.0, "BA", 2015)           
        
        ));
    }
    public ArrayList<CasoJudicial> getTodosOsCasos() {
        casos = new ArrayList<CasoJudicial>(Arrays.asList(
            new CasoJudicial(1000.0, "RJ", 2111), 
            new CasoJudicial(2000.0, "SP", 2005),
            new CasoJudicial(3000.0, "MG", 1995) ,
            new CasoJudicial(4000.0, "BA", 2015)           
   
        )
        );
              return casos;
    }
    
	
}
