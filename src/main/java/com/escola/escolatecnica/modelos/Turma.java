package com.escola.escolatecnica.modelos;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataInicio;
    private String dataFinal;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private Curso curso;

    @OneToMany(mappedBy = "turma")
    private List<Matricula> matriculas;

    public Turma(String dataInicio, String dataFinal, Curso curso) {
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
