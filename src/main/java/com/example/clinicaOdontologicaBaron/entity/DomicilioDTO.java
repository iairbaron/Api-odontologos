package com.example.clinicaOdontologicaBaron.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DomicilioDTO implements Serializable {

    private long id;
    private String calle;
    private int numero;
    private String localidad;
    private  String provincia;

}
