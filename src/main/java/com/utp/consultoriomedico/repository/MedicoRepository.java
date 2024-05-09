package com.utp.consultoriomedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utp.consultoriomedico.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
