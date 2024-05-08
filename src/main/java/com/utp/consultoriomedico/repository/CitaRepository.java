package com.utp.consultoriomedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utp.consultoriomedico.entity.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer>{
    
}
