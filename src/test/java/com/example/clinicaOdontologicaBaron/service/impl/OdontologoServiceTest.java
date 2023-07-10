package com.example.clinicaOdontologicaBaron.service.impl;

import com.example.clinicaOdontologicaBaron.entity.OdontologoDTO;
import com.example.clinicaOdontologicaBaron.exceptions.BadRequestException;
import com.example.clinicaOdontologicaBaron.service.IOdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    IOdontologoService iOdontologoService;

    @Test
    public void crearOdontologo() throws BadRequestException {
        OdontologoDTO odontologoDTO= new OdontologoDTO();
        odontologoDTO.setNombre("Juan");
        odontologoDTO.setApellido("Fernando");
        odontologoDTO.setMatricula(Integer.parseInt("543534"));
        iOdontologoService.crearOdontologo(odontologoDTO);

        assertTrue(odontologoDTO != null);

    }

}