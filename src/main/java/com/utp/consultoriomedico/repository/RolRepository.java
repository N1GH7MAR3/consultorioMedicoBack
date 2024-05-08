package com.utp.consultoriomedico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utp.consultoriomedico.entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

}
