package com.example.clinicaOdontologicaBaron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.*;


@SpringBootApplication
public class ClinicaOdontologicaBaronApplication {
	public static void main(String[] args) {

		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(ClinicaOdontologicaBaronApplication.class, args);
	}

}
