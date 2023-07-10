package com.example.clinicaOdontologicaBaron.repository;

import com.example.clinicaOdontologicaBaron.entity.Odontologo;
import com.example.clinicaOdontologicaBaron.entity.OdontologoDTO;
import com.example.clinicaOdontologicaBaron.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Long> {

   @Query("SELECT e from Odontologo e WHERE e.matricula LIKE :matricula")
   OdontologoDTO obtenerOdontologosPorMatricula(@Param("matricula") int matricula);

}
