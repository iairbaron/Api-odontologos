package com.example.clinicaOdontologicaBaron.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PacienteDTO implements Serializable {

    private long id;
    private String nombre;
    private String apellido;
    private  String email;
    private int dni;
    private Date fechaDeIngreso;
    private Domicilio domicilio;

}
