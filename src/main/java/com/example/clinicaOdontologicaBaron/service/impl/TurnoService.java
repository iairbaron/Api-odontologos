package com.example.clinicaOdontologicaBaron.service.impl;

import com.example.clinicaOdontologicaBaron.entity.Turno;
import com.example.clinicaOdontologicaBaron.entity.TurnoDTO;
import com.example.clinicaOdontologicaBaron.repository.ITurnoRepository;
import com.example.clinicaOdontologicaBaron.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        Turno turno= mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public TurnoDTO leerTurno(Long id) {

        Optional<Turno> turno= turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if (turno.isPresent()){
            turnoDTO= mapper.convertValue(turno, TurnoDTO.class);
            return turnoDTO;
        }
        return null;

    }

    @Override
    public void modificarTurno(TurnoDTO turnoDTO) {
        Turno turno= mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);

    }

    @Override
    public Set<TurnoDTO> traerTodos() {
        List<Turno> turnos= turnoRepository.findAll();
        Set<TurnoDTO> turnosDTO= new HashSet<>();

        for (Turno turno: turnos) {
            turnosDTO.add(mapper.convertValue(turno, TurnoDTO.class));
        }

        return turnosDTO;
    }


}
