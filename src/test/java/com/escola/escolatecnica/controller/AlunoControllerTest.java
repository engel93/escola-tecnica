package com.escola.escolatecnica.controller;

import com.escola.escolatecnica.modelos.Aluno;
import com.escola.escolatecnica.service.AlunoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlunoControllerTest {
    private AlunoService alunoService;

    @BeforeEach
    void setUp() {
        this.alunoService = Mockito.mock(AlunoService.class);
    }


    @Test
    void returnStatus200WhenGetAlunos(){
        Aluno aluno = new Aluno("Jonathan", "123456", "08/01/1988", "51-995938846");

        Mockito.when(alunoService.getAll()).thenReturn(Collections.singletonList(aluno));

        AlunoController alunoController = new AlunoController(alunoService);
        ResponseEntity<List<Aluno>> atual = alunoController.getAll();

        assertEquals(atual, ResponseEntity.status(HttpStatus.OK).body(Collections.singletonList(aluno)));
    }

    @Test
    void returnStatus201WhenPostAluno(){

    }
}