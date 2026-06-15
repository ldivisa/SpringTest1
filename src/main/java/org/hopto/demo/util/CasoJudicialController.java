package org.hopto.demo.util;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/casos")
public class CasoJudicialController {
    
    private final CasoJudicialService service;


public CasoJudicialController(CasoJudicialService service) {
        this.service = service;
    }

@GetMapping
public ResponseEntity<ArrayList<CasoJudicial>> getTodosOsCasos() {
        ArrayList<CasoJudicial> casos = service.getTodosOsCasos();
        return ResponseEntity.ok(casos);
}    
@GetMapping("/{id}")
public ResponseEntity<CasoJudicial> getCasoPorId(@PathVariable Long id) {
        CasoJudicial caso = service.getCasoPorId(id);
        if (caso != null) {
            return ResponseEntity.ok(caso);
        } else {
            return ResponseEntity.notFound().build();
        }


}}