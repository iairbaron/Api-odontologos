package com.example.clinicaOdontologicaBaron.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_generator",allocationSize = 1, sequenceName = "paciente_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_generator")
    private long id;
    private String nombre;
    private String apellido;
    private  String email;
    private int dni;
    private Date fechaDeIngreso;
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Turno> listaTurnos;

}



