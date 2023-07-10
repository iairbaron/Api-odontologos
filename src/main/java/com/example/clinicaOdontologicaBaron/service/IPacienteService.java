package com.example.clinicaOdontologicaBaron.service;

import com.example.clinicaOdontologicaBaron.entity.DomicilioDTO;
import com.example.clinicaOdontologicaBaron.entity.OdontologoDTO;
import com.example.clinicaOdontologicaBaron.entity.PacienteDTO;
import com.example.clinicaOdontologicaBaron.exceptions.BadRequestException;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDTO pacienteDTO) throws BadRequestException;
    PacienteDTO leerPaciente(Long id);
    void modificarPaciente(PacienteDTO pacienteDTO);
    void eliminarPaciente(Long id);
    Set<PacienteDTO> traerTodos();

}
