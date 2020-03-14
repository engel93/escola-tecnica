package com.escola.escolatecnica.service;

import com.escola.escolatecnica.enums.ModalidadeEnum;
import com.escola.escolatecnica.modelos.Curso;
import com.escola.escolatecnica.repository.CursoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursoServiceTest {

    private CursoRepository cursoRepository;

    @BeforeEach
    public void setUp(){
        this.cursoRepository = Mockito.mock(CursoRepository.class);
    }

    @Test
    void salvaCursoComSucesso(){
        Curso esperado = new Curso("Test","Curso de teste","Boa vontade", ModalidadeEnum.BUSINESS);
        Mockito.when(cursoRepository.save(esperado)).thenReturn(esperado);

        CursoService cursoService = new CursoService(cursoRepository);
        Curso atual = cursoService.salvar(esperado);

        assertEquals(esperado,atual);
        Mockito.verify(cursoRepository,Mockito.times(1)).save(esperado);
    }

    @Test
    void falhaSalvarCursoSemNome(){
        Curso curso = new Curso(null,"Curso de teste","Boa vontade", ModalidadeEnum.BUSINESS);
        CursoService cursoService = new CursoService(cursoRepository);

        Assertions.assertThrows(NullPointerException.class,()->{
            cursoService.salvar(curso);
        });
        Mockito.verifyNoInteractions(cursoRepository);
    }
}
