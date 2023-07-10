package com.example.clinicaOdontologicaBaron.repository;

import com.example.clinicaOdontologicaBaron.entity.OdontologoDTO;
import com.example.clinicaOdontologicaBaron.entity.Paciente;
import com.example.clinicaOdontologicaBaron.entity.PacienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {

    @Query("SELECT p from Paciente p WHERE p.dni LIKE :dni")
    PacienteDTO obtenerPacientePorDni(@Param("dni") int dni);

}
