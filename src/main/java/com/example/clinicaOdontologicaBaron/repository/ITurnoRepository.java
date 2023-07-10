package com.example.clinicaOdontologicaBaron.repository;

import com.example.clinicaOdontologicaBaron.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno,Long> {
}
