package com.example.clinicaOdontologicaBaron.service.impl;

import com.example.clinicaOdontologicaBaron.GlobalExceptionHandler;
import com.example.clinicaOdontologicaBaron.entity.Domicilio;
import com.example.clinicaOdontologicaBaron.entity.DomicilioDTO;
import com.example.clinicaOdontologicaBaron.entity.Odontologo;
import com.example.clinicaOdontologicaBaron.entity.OdontologoDTO;
import com.example.clinicaOdontologicaBaron.repository.IDomicilioRepository;
import com.example.clinicaOdontologicaBaron.repository.IOdontologoRepository;
import com.example.clinicaOdontologicaBaron.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService {
    @Autowired
    private IDomicilioRepository iDomicilioRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public DomicilioDTO crearDomicilio(DomicilioDTO domicilio) {
        domicilio.setId(0L);
        Domicilio domicilioGuardado = iDomicilioRepository.save(mapper.convertValue(domicilio, Domicilio.class));
        domicilio.setId(domicilio.getId());
        return mapper.convertValue(domicilioGuardado, DomicilioDTO.class);
    }

    @Override
    public DomicilioDTO leerDomicilio(Long id) {
        Optional<Domicilio> domicilio= iDomicilioRepository.findById(id);
        DomicilioDTO domicilioDTO = null;
        if (domicilio.isPresent()){
            domicilioDTO= mapper.convertValue(domicilio, DomicilioDTO.class);
            return domicilioDTO;
        }
        return null;
    }

    @Override
    public void modificarDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio= mapper.convertValue(domicilioDTO,Domicilio.class);
        iDomicilioRepository.save(domicilio);
    }

    @Override
    public void eliminarDomicilio(Long id) {
        iDomicilioRepository.deleteById(id);

    }

    @Override
    public Set<DomicilioDTO> traerTodos() {
        List<Domicilio> domicilios= iDomicilioRepository.findAll();
        Set<DomicilioDTO> domiciliosDTO= new HashSet<>();

        for (Domicilio domicilio: domicilios) {
            domiciliosDTO.add(mapper.convertValue(domicilio, DomicilioDTO.class));
        }

        return domiciliosDTO;
    }

}
