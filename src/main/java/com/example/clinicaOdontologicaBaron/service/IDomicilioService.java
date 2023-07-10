package com.example.clinicaOdontologicaBaron.service;

import com.example.clinicaOdontologicaBaron.entity.DomicilioDTO;
import com.example.clinicaOdontologicaBaron.entity.OdontologoDTO;

import java.util.Set;

public interface IDomicilioService {

    DomicilioDTO crearDomicilio(DomicilioDTO domicilioDTO);
    DomicilioDTO leerDomicilio(Long id);
    void modificarDomicilio(DomicilioDTO domicilioDTO);
    void eliminarDomicilio(Long id);
    Set<DomicilioDTO> traerTodos();

}
