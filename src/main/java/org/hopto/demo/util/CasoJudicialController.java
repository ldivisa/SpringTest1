package org.hopto.demo.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
