package com.example.clinicaOdontologicaBaron.service.impl;

import com.example.clinicaOdontologicaBaron.GlobalExceptionHandler;
import com.example.clinicaOdontologicaBaron.entity.Odontologo;
import com.example.clinicaOdontologicaBaron.entity.OdontologoDTO;
import com.example.clinicaOdontologicaBaron.exceptions.BadRequestException;
import com.example.clinicaOdontologicaBaron.repository.IOdontologoRepository;
import com.example.clinicaOdontologicaBaron.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.BadAttributeValueExpException;
import java.io.*;
import java.util.*;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) throws BadRequestException {
        if (odontologoRepository.obtenerOdontologosPorMatricula(odontologoDTO.getMatricula()) != null){
            throw new BadRequestException("Ya existe un odontologo con la matricula " + odontologoDTO.getMatricula());
        }else{
            Odontologo odontologo= mapper.convertValue(odontologoDTO,Odontologo.class);
            odontologoRepository.save(odontologo);
        }
    }

    @Override
    public OdontologoDTO leerOdontologo(Long id) {
            Optional<Odontologo> odontologo= odontologoRepository.findById(id);
            OdontologoDTO odontologoDTO = null;
            if (odontologo.isPresent()){
                logger.info("El odontologo ha sido encontrado correctamente");
                odontologoDTO= mapper.convertValue(odontologo, OdontologoDTO.class);
              return odontologoDTO;
            }
            logger.error("No se ha podido encontrar al odontologo con id + " + id);
            return null;
        }
    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
            Odontologo odontologo= mapper.convertValue(odontologoDTO,Odontologo.class);
            odontologoRepository.save(odontologo);
            logger.info("El odontonlogo ha sido modificado correctamente");
    }

    @Override
    public void eliminarOdontologo(Long id) {
        if (odontologoRepository.findById(id).isPresent()) {
            odontologoRepository.deleteById(id);
            logger.info("Se ha eliminado al odontologo con id "+ id);
        }else {
            logger.error("No se ha podido eliminar al odontologo con id" + id);
        }
    }

    @Override
    public Set<OdontologoDTO> traerTodos() {
        List<Odontologo> odontologos= odontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO= new HashSet<>();

        for (Odontologo odontologo: odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        logger.info("Se han listado todos los odontologos");
        return odontologosDTO;
    }

   }


