package org.hopto.demo.util;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



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
    }
@PostMapping
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
        }

