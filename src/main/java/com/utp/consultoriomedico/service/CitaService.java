package com.utp.consultoriomedico.service;

import java.util.List;

import com.utp.consultoriomedico.model.Cita;

public interface CitaService {

    List<Cita> getAllCitas();

    Cita findCitaById(int id);

    void saveCita(Cita cita);

    void deleteCita(int id);
    

    
} 