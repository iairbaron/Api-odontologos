package com.example.clinicaOdontologicaBaron.service.impl;

import com.example.clinicaOdontologicaBaron.entity.*;
import com.example.clinicaOdontologicaBaron.exceptions.BadRequestException;
import com.example.clinicaOdontologicaBaron.repository.IPacienteRepository;
import com.example.clinicaOdontologicaBaron.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) throws BadRequestException {
        if (pacienteRepository.obtenerPacientePorDni(pacienteDTO.getDni()) != null){
            throw new BadRequestException("Ya existe un paciente creado con ese dni");
        }else{
            Paciente paciente= mapper.convertValue(pacienteDTO, Paciente.class);
            pacienteRepository.save(paciente);
        }
    }

    @Override
    public PacienteDTO leerPaciente(Long id) {

        Optional<Paciente> paciente= pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if (paciente.isPresent()){
            pacienteDTO= mapper.convertValue(paciente, PacienteDTO.class);
            return pacienteDTO;
        }
        return null;

    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente= mapper.convertValue(pacienteDTO,Paciente.class);
        pacienteRepository.save(paciente);

    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDTO> traerTodos() {
        List<Paciente> pacientes= pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO= new HashSet<>();

        for (Paciente paciente: pacientes) {
            pacientesDTO.add(mapper.convertValue(paciente, PacienteDTO.class));
        }

        return pacientesDTO;
    }
}
