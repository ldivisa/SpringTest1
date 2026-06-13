package org.hopto.demo.util;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasoJudicialService {
    private final CasoJudicialRepository repository;

    @Autowired
    public CasoJudicialService(CasoJudicialRepository repository) {
        this.repository = repository;
    }
    public List<CasoJudicial> getTodosOsCasos() {
        return repository.findAll();
    }
}
