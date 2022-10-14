package com.example.demo.service;

import com.example.demo.domain.Cajon;
import com.example.demo.domain.Papa;
import com.example.demo.domain.Verduleria;
import com.example.demo.repository.VerduleriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerduleriaService {
    @Autowired
    VerduleriaRepository verduleriaRepo;

    public Verduleria verduleriaUpdate(Long id, Verduleria newVerduleria) {
        return verduleriaRepo.findById(id).map(verduleria -> {
            verduleria.setId(newVerduleria.getId());
            verduleria.setNombre(newVerduleria.getNombre());
            verduleria.setEmpleados(newVerduleria.getEmpleados());
            return verduleriaRepo.save(verduleria);
        }).orElseThrow();
    }


    // TODO: POST, PUT Y PATCH RELACION EMPLEADO Y TEST
}
