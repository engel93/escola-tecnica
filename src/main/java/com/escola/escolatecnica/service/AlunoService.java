package com.escola.escolatecnica.service;

import com.escola.escolatecnica.modelos.Aluno;
import com.escola.escolatecnica.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvar(Aluno aluno) {
        if(aluno.getNome() == null) {
            throw new NullPointerException();
        }

        return alunoRepository.save(aluno);
    }

    public List<Aluno> getAll() {
        return alunoRepository.findAll();
    }
}
