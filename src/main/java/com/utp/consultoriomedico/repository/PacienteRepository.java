package com.utp.consultoriomedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utp.consultoriomedico.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
