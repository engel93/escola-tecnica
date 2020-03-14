package com.escola.escolatecnica.repository;

import com.escola.escolatecnica.modelos.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
