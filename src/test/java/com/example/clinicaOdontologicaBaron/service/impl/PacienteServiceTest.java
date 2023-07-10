package com.example.clinicaOdontologicaBaron.service.impl;

import com.example.clinicaOdontologicaBaron.entity.OdontologoDTO;
import com.example.clinicaOdontologicaBaron.entity.PacienteDTO;
import com.example.clinicaOdontologicaBaron.exceptions.BadRequestException;
import com.example.clinicaOdontologicaBaron.service.IOdontologoService;
import com.example.clinicaOdontologicaBaron.service.IPacienteService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PacienteServiceTest {

    @Autowired
    IPacienteService pacienteService;

    @Test
    public void crearPaciente() throws BadRequestException {
        PacienteDTO pEsteban = new PacienteDTO();
        pEsteban.setId(19L);
        pEsteban.setNombre("Esteban");
        pEsteban.setApellido("Gonzalez");
        pEsteban.setDni(123334);
        pEsteban.setEmail("estebanGonzalez@gmail.com");
        pEsteban.setFechaDeIngreso(new Date());
        pacienteService.crearPaciente(pEsteban);

        assertTrue(pEsteban.getId() == 19L);

    }

    @Test
    public void eliminarPaciente() throws BadRequestException {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(25L);
        pacienteDTO.setNombre("Franco");
        pacienteDTO.setApellido("Croce");
        pacienteDTO.setDni(123334);
        pacienteDTO.setEmail("francoCrocee@gmail.com");
        pacienteDTO.setFechaDeIngreso(new Date());
        pacienteService.crearPaciente(pacienteDTO);

        PacienteDTO pacienteJuan = pacienteService.leerPaciente(22L);

        pacienteService.eliminarPaciente(22L);

        assertNull(pacienteJuan);
    }


    @Test
    public void traerTodos() throws BadRequestException {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(10L);
        pacienteDTO.setNombre("Franco");
        pacienteDTO.setApellido("Croce");
        pacienteDTO.setDni(123334);
        pacienteDTO.setEmail("francoCrocee@gmail.com");
        pacienteDTO.setFechaDeIngreso(new Date());
        pacienteService.crearPaciente(pacienteDTO);

        PacienteDTO pacienteDTO2 = new PacienteDTO();
        pacienteDTO2.setId(11L);
        pacienteDTO2.setNombre("Pedro");
        pacienteDTO2.setApellido("Croce");
        pacienteDTO2.setDni(54353);
        pacienteDTO2.setEmail("pedroCrocee@gmail.com");
        pacienteDTO2.setFechaDeIngreso(new Date());
        pacienteService.crearPaciente(pacienteDTO2);

        PacienteDTO pacienteDTO3 = new PacienteDTO();
        pacienteDTO3.setId(13L);
        pacienteDTO3.setNombre("Juan");
        pacienteDTO3.setApellido("Croce");
        pacienteDTO3.setDni(123334);
        pacienteDTO3.setEmail("juanCrocee@gmail.com");
        pacienteDTO3.setFechaDeIngreso(new Date());
        pacienteService.crearPaciente(pacienteDTO3);

        Set<PacienteDTO> pacientesDTO = pacienteService.traerTodos();

        assertTrue(pacientesDTO.size() >= 3);
    }

}