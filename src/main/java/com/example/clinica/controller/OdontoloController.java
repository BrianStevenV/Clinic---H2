package com.example.clinica.controller;

import com.example.clinica.model.Odontologo;
import com.example.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class OdontoloController {

    private OdontologoService odontologoService;

    @Autowired
    public OdontoloController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping("/odontologo")
    public Odontologo crear(@RequestBody Odontologo odontologo) {
        return this.odontologoService.crear(odontologo);
    }

    @DeleteMapping("/odontologo/{matricula}")
    public ResponseEntity<Void> eliminarOdontologo(@PathVariable int matricula){
        boolean success = odontologoService.eliminarOdontologo(matricula);
        if(success){
            return ResponseEntity.noContent().build();
        }   else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/odontologo/all")
    public List<Odontologo> getAllRecordsDentist(){
        return odontologoService.getAllRecordsDentists();
    }

    //crear endpoint para obtener todos los odontologo
    //crear endpoint para eliminar odontologo por matricula
}
