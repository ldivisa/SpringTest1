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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/casos")
public class CasoJudicialController {
    
    private final CasoJudicialService service;

    @Autowired
    public CasoJudicialController(CasoJudicialService service) {
        this.service = service;
    }
public double finalizarCusto(double valorBase, String estado, int ano) {
        // Lógica para calcular o custo final do caso judicial
        double custoFinal = valorBase;
        // Exemplo de ajuste baseado no estado
        if (estado.equalsIgnoreCase("SP")) {
            custoFinal *= 1.2; // Aumento de 20% para casos em SP
        } else if (estado.equalsIgnoreCase("RJ")) {
            custoFinal *= 1.1; // Aumento de 10% para casos no RJ
        }
        // Exemplo de ajuste baseado no ano
        if (ano < 2000) {
            custoFinal *= 0.8; // Desconto de 20% para casos antigos
        }
        return custoFinal;
    }
   /*  @GetMapping("/calcularCusto")
    public double calcularCusto(@RequestParam double valorBase, @RequestParam String estado, @RequestParam int ano) {
        return service.finalizarCusto(valorBase, estado, ano);
    } */

    @GetMapping
    public ResponseEntity<List<CasoJudicialController>> getTodosOsCasos() {
        List<CasoJudicialController> casos = service.getTodosOsCasos();
        return ResponseEntity.ok(casos);
    }

    @PostMapping
    public ResponseEntity<CasoJudicialController> criarCaso(@RequestBody CasoJudicialController caso) {
        //if service.existeCaso(caso.getId())) {
          //  return ResponseEntity.status(HttpStatus.CONFLICT).build();
       // -- codigo gerado pelo lombok -vamos usar a referencia do curso que aborda o uso de exceptions
       //return ResponseEntity.status(HttpStatus.CONFLICT).build();
       //}
       /*  if (service.existeCaso(caso)){
        throw new CasoDuplicadoException("Caso com ID " + caso.getId() + " já existe.");
        } */
        CasoJudicialController novoCaso = service.criarCaso(caso);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCaso);
    }
    @PutMapping("/{id}")
    




    /* @PatchMapping("/{id}")
    public ResponseEntity<CasoJudicial> atualizarParcialCaso(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        CasoJudicial casoAtualizado = service.atualizarParcialCaso(id, updates);
        if (casoAtualizado != null) {
            return ResponseEntity.ok(casoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    } */  
    
    /* @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCaso(@PathVariable Long id) {
        boolean deletado = service.deletarCaso(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
   public void atualizarCustoCaso(Long id, double novoValor) {
        service.atualizarCustoCaso(id, novoValor);
    }}


