package com.escola.escolatecnica.controller;

import com.escola.escolatecnica.modelos.Aluno;
import com.escola.escolatecnica.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        List<Aluno> alunos = alunoService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(alunos);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Aluno aluno){
        alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
