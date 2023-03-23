package com.example.clinica.controller;

import com.example.clinica.model.Turno;
import com.example.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class TurnoController {
    private TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @PostMapping("/odontologo/{matricula}/paciente/{dni}/fecha/{fecha}/asignar")
    public Turno appointment(@RequestBody int matricula, int dni, String fechaTurno){
        return this.turnoService.generar(matricula,dni,fechaTurno);
    }

    //crear controlador de asignar el turno.
}
