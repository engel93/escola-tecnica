package com.escola.escolatecnica.service;

import com.escola.escolatecnica.enums.ModalidadeEnum;
import com.escola.escolatecnica.modelos.Aluno;
import com.escola.escolatecnica.modelos.Curso;
import com.escola.escolatecnica.modelos.Matricula;
import com.escola.escolatecnica.modelos.Turma;
import com.escola.escolatecnica.repository.MatriculaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatriculaServiceTest {

    private MatriculaRepository matriculaRepository;

    @BeforeEach
    public void setUp() {
        this.matriculaRepository = Mockito.mock(MatriculaRepository.class);
    }

    @Test
    void salvaComSucesso() {
        Matricula matricula = new Matricula(new Turma(null,"01/06/2020",
                new Curso("Test","Curso de teste","Boa vontade", ModalidadeEnum.BUSINESS)),
                (new Aluno("Jonathan", "123456", "08/01/1988", "51-995938846")));
        MatriculaService matriculaService = new MatriculaService(matriculaRepository);
        Mockito.when(matriculaRepository.save(matricula)).thenReturn(matricula);
        Matricula atual = matriculaService.salvar(matricula);
        assertEquals(matricula, atual);
        Mockito.verify(matriculaRepository, Mockito.times(1)).save(matricula);
    }

    @Test
    void falhaAoSalvarMatricula() {
        Matricula matricula = new Matricula(new Turma(null,"01/06/2020",
                new Curso("Test","Curso de teste","Boa vontade", ModalidadeEnum.BUSINESS)),
                (null));
        MatriculaService matriculaService = new MatriculaService(matriculaRepository);

        Assertions.assertThrows(NullPointerException.class, () -> {
            matriculaService.salvar(matricula);
        });
        Mockito.verifyNoInteractions(matriculaRepository);
    }
}
