package com.example.clinicaOdontologicaBaron.service;

import com.example.clinicaOdontologicaBaron.entity.DomicilioDTO;
import com.example.clinicaOdontologicaBaron.entity.TurnoDTO;

import java.util.Set;

public interface ITurnoService {

    void crearTurno(TurnoDTO turnoDTO);
    TurnoDTO leerTurno(Long id);
    void modificarTurno(TurnoDTO turnoDTO);
    void eliminarTurno(Long id);
    Set<TurnoDTO> traerTodos();

}
