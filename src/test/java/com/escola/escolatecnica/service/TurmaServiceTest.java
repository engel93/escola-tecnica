package com.escola.escolatecnica.service;

import com.escola.escolatecnica.enums.ModalidadeEnum;
import com.escola.escolatecnica.modelos.Curso;
import com.escola.escolatecnica.modelos.Turma;
import com.escola.escolatecnica.repository.TurmaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurmaServiceTest {
    private TurmaRepository turmaRepository;

    @BeforeEach
    public void setUp(){
        this.turmaRepository= Mockito.mock(TurmaRepository.class);
    }

    @Test
    void salvaTuraComSucesso(){
        Curso curso = new Curso("Test","Curso de teste","Boa vontade", ModalidadeEnum.BUSINESS);
        Turma esperado = new Turma("09/01/2020","01/06/2020", curso);

        Mockito.when(turmaRepository.save(esperado)).thenReturn(esperado);

        TurmaService turmaService = new TurmaService(turmaRepository);
        Turma atual = turmaService.salvar(esperado);

        assertEquals(esperado,atual);
        Mockito.verify(turmaRepository,Mockito.times(1)).save(esperado);
    }

    @Test
    void falhaSalvarTurmaSemDataInicio(){
        Curso curso = new Curso("Test","Curso de teste","Boa vontade", ModalidadeEnum.BUSINESS);
        Turma turma = new Turma(null,"01/06/2020", curso);

        TurmaService turmaService = new TurmaService(turmaRepository);

        Assertions.assertThrows(NullPointerException.class,()->{
            turmaService.salvar(turma);
        });
        Mockito.verifyNoInteractions(turmaRepository);

    }
}
