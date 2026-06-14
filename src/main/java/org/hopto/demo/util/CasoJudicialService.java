package org.hopto.demo.util;
import java.util.List;

import org.hopto.demo.CasoJudicialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasoJudicialService {
    private final CasoJudicialRepository repository;

    @Autowired
    public CasoJudicialService(CasoJudicialRepository repository) {
        this.repository = repository;
    }
    public List<CasoJudicialController> getTodosOsCasos() {
        return repository.findAll();
    }
    public CasoJudicialController criarCaso(CasoJudicialController caso) {
        return repository.save(caso);
    }
	public void atualizarCustoCaso(Long id, double novoValor) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'atualizarCustoCaso'");
	}
}
