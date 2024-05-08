package com.utp.consultoriomedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utp.consultoriomedico.entity.Consultorio;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Integer>{
}
