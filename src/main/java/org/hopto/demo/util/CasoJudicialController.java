package org.hopto.demo.util;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController


public class CasoJudicialController {
    
    private final CasoJudicialService service;


public CasoJudicialController(CasoJudicialService service) {
        this.service = service;
    }

@RequestMapping(value = "/api/casos", method = RequestMethod.GET)
public ResponseEntity<ArrayList<CasoJudicial>> getTodosOsCasos() {
        ArrayList<CasoJudicial> casos = service.getTodosOsCasos();
        return ResponseEntity.ok(casos);
}    
@RequestMapping(value = "/api/casos/{id}", method = RequestMethod.GET)
public ResponseEntity<CasoJudicial> getCasoPorId(@PathVariable Long id) {
        CasoJudicial caso = service.getCasoPorId(id);
        if (caso != null) {
            return ResponseEntity.ok(caso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
@RequestMapping(value = "/api/casos", method = RequestMethod.POST)
public ResponseEntity<CasoJudicial> adicionarCaso(@RequestBody CasoJudicial caso) {
    if (caso == null) {
            return ResponseEntity.badRequest().build();
        }   

    URI locationUri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(caso.getId())
            .toUri();  
        service.adicionarCaso(caso);
        //return ResponseEntity.status(HttpStatus.CREATED).body(caso);
        return ResponseEntity.created(locationUri).body(caso);
       }

    @RequestMapping(value = "/api/casos/{id}", method = RequestMethod.PUT)  
    public ResponseEntity<CasoJudicial> atualizarCaso(@PathVariable Long id,@RequestBody CasoJudicial casoAtualizado){
        service.substituirCaso(id, casoAtualizado);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/api/casos/{ids}", method = RequestMethod.DELETE)   
        public ResponseEntity<CasoJudicial> deletarCaso(@PathVariable Long ids){
        System.out.println(ids);
        service.deletarCaso(ids);
        return ResponseEntity.noContent().build();
        }

    @RequestMapping(value = "/api/casos/{ids}", method = RequestMethod.PATCH)   
        public ResponseEntity<CasoJudicial> finalizarCaso(@PathVariable Long ids, @RequestBody CasoJudicial casoAtualizado){
        CasoJudicial caso = service.getCasoPorId(ids);
        if (caso != null) {
            double custoFinalizado = caso.finalizarCusto(casoAtualizado.getCusto(), casoAtualizado.getEstado(), casoAtualizado.getAnoJulgamento());
            casoAtualizado = new CasoJudicial(caso.getId(), custoFinalizado, casoAtualizado.getEstado(), casoAtualizado.getAnoJulgamento());
            service.substituirCaso(ids, casoAtualizado);
            return ResponseEntity.ok(casoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }   
    }

