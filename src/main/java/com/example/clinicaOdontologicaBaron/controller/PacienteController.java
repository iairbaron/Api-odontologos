package com.example.clinicaOdontologicaBaron.controller;

import com.example.clinicaOdontologicaBaron.entity.PacienteDTO;
import com.example.clinicaOdontologicaBaron.exceptions.BadRequestException;
import com.example.clinicaOdontologicaBaron.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController @CrossOrigin
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @PostMapping("/registrar")
    public ResponseEntity<?> crearDomicilio(@RequestBody PacienteDTO pacienteDTO) throws BadRequestException {
        pacienteService.crearPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarDomicilio(@PathVariable Long id){
        return pacienteService.leerPaciente(id);
    }

    @PutMapping("/modificar")
    public ResponseEntity<?> modificarDomicilio(@RequestBody PacienteDTO pacienteDTO){
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDomicilio(@PathVariable Long id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Set<PacienteDTO> traerTodos(){
        return pacienteService.traerTodos();
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
