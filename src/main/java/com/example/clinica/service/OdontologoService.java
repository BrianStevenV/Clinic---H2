package com.example.clinica.service;

import com.example.clinica.model.Odontologo;
import com.example.clinica.model.Paciente;
import com.example.clinica.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private OdontologoRepository  odontologoRepository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public Odontologo crear (Odontologo odontologo){
        this.odontologoRepository.save(odontologo);
        return odontologo;
    }

    public boolean eliminarOdontologo(int dni){
        Optional<Odontologo> odontologo = odontologoRepository.findById(dni);
        if(odontologo.isPresent()){
            odontologoRepository.delete(odontologo.get());
            return true;
        }
        return false;
    }

    public List<Odontologo> getAllRecordsDentists(){
        List<Odontologo> odontologos = new ArrayList<Odontologo>();
        odontologoRepository.findAll().forEach(odontologo -> odontologos.add(odontologo));
        return odontologos;
    }
}
