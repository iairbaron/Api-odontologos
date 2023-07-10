package com.example.clinicaOdontologicaBaron.repository;

import com.example.clinicaOdontologicaBaron.entity.Domicilio;
import com.example.clinicaOdontologicaBaron.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio,Long> {
}
