package com.escola.escolatecnica.repository;

import com.escola.escolatecnica.modelos.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {
}
