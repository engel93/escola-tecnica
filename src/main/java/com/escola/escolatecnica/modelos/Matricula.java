package com.escola.escolatecnica.modelos;

import javax.persistence.*;

@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private Turma turma;

    @ManyToOne()
    @JoinColumn(referencedColumnName = "id")
    private Aluno aluno;

    public Matricula(Turma turma, Aluno aluno) {
        this.turma = turma;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
