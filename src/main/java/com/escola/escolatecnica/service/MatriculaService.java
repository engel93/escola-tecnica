package com.escola.escolatecnica.service;

import com.escola.escolatecnica.modelos.Matricula;
import com.escola.escolatecnica.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    private MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public Matricula salvar(Matricula matricula) {
        if (matricula.getAluno() == null) {
            throw new NullPointerException();
        }
        return matriculaRepository.save(matricula);
    }
}
