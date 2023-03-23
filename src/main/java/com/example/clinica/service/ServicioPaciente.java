package com.example.clinica.service;

import com.example.clinica.model.Paciente;
import com.example.clinica.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioPaciente {
    private PacienteRepository pacienteRepository;

    @Autowired
    public ServicioPaciente(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente crear(Paciente paciente){
        if(paciente.getDni() < 0 || paciente.getNombre() == null){
            throw new RuntimeException("Paciente no puede tener nombre nulo o dni negativo");
        }
        this.pacienteRepository.save(paciente);
        return paciente;
    }

    public boolean eliminarPaciente(int dni){
        Optional<Paciente> paciente = pacienteRepository.findById(dni);
        if(paciente.isPresent()){
            pacienteRepository.delete(paciente.get());
            return true;
        }
        return false;
    }


    public List<Paciente> getAllRecordsPatients(){
        List<Paciente> pacientes = new ArrayList<Paciente>();
        pacienteRepository.findAll().forEach(paciente -> pacientes.add(paciente));
        return pacientes;
    }
}
