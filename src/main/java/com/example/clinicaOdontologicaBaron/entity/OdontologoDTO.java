package com.example.clinicaOdontologicaBaron.entity;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OdontologoDTO implements Serializable {

    private Long id;

    private String nombre;

    private String apellido;

    private int matricula;

}
