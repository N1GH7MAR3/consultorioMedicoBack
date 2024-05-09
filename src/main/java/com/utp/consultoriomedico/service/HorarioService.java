package com.utp.consultoriomedico.service;

import java.util.List;

import com.utp.consultoriomedico.model.Horario;

public interface HorarioService {

    List<Horario> getAllHorarios();

    Horario findHorarioById(int id);

    void saveHorario(Horario horario);

    void deleteHorario(int id);
    
    
}
