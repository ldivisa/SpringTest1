package org.hopto.demo.util;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/casos")
public class CasoJudicialController {
    
    private final CasoJudicialService service;

@Autowired
public CasoJudicialController(CasoJudicialService service) {
        this.service = service;
    }

@GetMapping
public ResponseEntity<List<CasoJudicial>> getTodosOsCasos() {
        List<CasoJudicial> casos = service.getTodosOsCasos();
        return ResponseEntity.ok(casos);
}    
}