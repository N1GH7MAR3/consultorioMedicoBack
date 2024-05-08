package com.utp.consultoriomedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utp.consultoriomedico.entity.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {

}
