package com.escola.escolatecnica.service;

import com.escola.escolatecnica.modelos.Curso;
import com.escola.escolatecnica.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }


    public Curso salvar(Curso curso) {
        if(curso.getNome() == null){
            throw new NullPointerException();
        }
        return cursoRepository.save(curso);
    }
}
