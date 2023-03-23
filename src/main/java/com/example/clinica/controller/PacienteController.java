package com.example.clinica.controller;

import com.example.clinica.model.Odontologo;
import com.example.clinica.model.Paciente;
import com.example.clinica.service.ServicioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class PacienteController {

    private ServicioPaciente servicioPaciente;

    @Autowired
    public PacienteController(ServicioPaciente servicioPaciente) {
        this.servicioPaciente = servicioPaciente;
    }

    @PostMapping("/paciente")
    public Paciente crear(@RequestBody Paciente paciente) {
        return this.servicioPaciente.crear(paciente);
    }

    @DeleteMapping("/paciente/{dni}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable int dni){
        boolean success = servicioPaciente.eliminarPaciente(dni);
        if(success){
            return ResponseEntity.noContent().build();
        }   else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/paciente/all")
    public List<Paciente> getAllPatients(){
        return servicioPaciente.getAllRecordsPatients();
    }


    //crear endpoint para obtener todos los paciente
    //crear endpoint para eliminar paciente por dni
}
