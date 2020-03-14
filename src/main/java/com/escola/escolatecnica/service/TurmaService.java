package com.escola.escolatecnica.service;

import com.escola.escolatecnica.modelos.Turma;
import com.escola.escolatecnica.repository.TurmaRepository;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {
    private TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public Turma salvar(Turma turma) {
        if(turma.getDataInicio() == null) {
            throw new NullPointerException();
        }
        return turmaRepository.save(turma);
    }
}
