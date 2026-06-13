package org.hopto.demo.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/casos")

public class CasoJudicialController {
    private final CasoJudicialService service;

    @Autowired
    public CasoJudicialController(CasoJudicialService service) {
        this.service = service;
    }

    @GetMapping("/calcularCusto")
    public double calcularCusto(@RequestParam double valorBase, @RequestParam String estado, @RequestParam int ano) {
        return service.finalizarCusto(valorBase, estado, ano);
    }

    @GetMapping
    public ResponseEntity<List<CasoJudicial>> getTodosOsCasos() {
        List<CasoJudicial> casos = service.getTodosOsCasos();
        return ResponseEntity.ok(casos);
    }

    @PostMapping
    public ResponseEntity<CasoJudicial> criarCaso(@RequestBody CasoJudicial caso) {
        CasoJudicial novoCaso = service.criarCaso(caso);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCaso);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CasoJudicial> atualizarCaso(@PathVariable Long id, @RequestBody CasoJudicial caso) {
        CasoJudicial casoAtualizado = service.atualizarCaso(id, caso);
        if (casoAtualizado != null) {
            return ResponseEntity.ok(casoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }   
    @PatchMapping("/{id}")
    public ResponseEntity<CasoJudicial> atualizarParcialCaso(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        CasoJudicial casoAtualizado = service.atualizarParcialCaso(id, updates);
        if (casoAtualizado != null) {
            return ResponseEntity.ok(casoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }  
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCaso(@PathVariable Long id) {
        boolean deletado = service.deletarCaso(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
