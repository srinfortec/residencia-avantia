package com.residencia.projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.projeto.entities.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long>{

}
