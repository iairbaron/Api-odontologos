package com.example.clinicaOdontologicaBaron.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Domicilio {

    @Id
    @SequenceGenerator(name = "domicilio_generator",allocationSize = 1, sequenceName = "domicilio_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_generator")
    private long id;
    private String calle;

    private int numero;
    private String localidad;
    private  String provincia;

    @OneToOne(mappedBy = "domicilio")
    @JsonIgnore
    private Paciente paciente;


}
