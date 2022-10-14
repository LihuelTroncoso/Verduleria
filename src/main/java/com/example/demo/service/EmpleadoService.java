package com.example.demo.service;

import com.example.demo.domain.Empleado;
import com.example.demo.domain.Verduleria;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.repository.VerduleriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepo;

    @Autowired
    VerduleriaRepository verduleriaRepository;

    public Empleado updateEmpleado(Long id, Empleado newEmpleado) {
        return empleadoRepo.findById(id).map(empleado -> {
            empleado.setId(newEmpleado.getId());
            empleado.setEdad(newEmpleado.getEdad());
            empleado.setVerdulerias(newEmpleado.getVerdulerias());
            empleado.setNombre(newEmpleado.getNombre());
            return empleadoRepo.save(empleado);
        }).orElseThrow();
    }

    public Empleado save(Empleado empleado){
        List<Verduleria> verdulerias = empleado.getVerdulerias();
        if(verdulerias != null){
            ArrayList<Verduleria> verduleriasObtenidas = new ArrayList<>();
            for(Verduleria verduleria: verdulerias) {
                verduleriasObtenidas.add(verduleriaRepository.findById(verduleria.getId()).get());
                 // TODO: TEST
            }
            if (verduleriasObtenidas.isEmpty()) {
                throw new IllegalArgumentException("No existe un cajon con ese id");
            }
            empleado.setVerdulerias(verduleriasObtenidas);
        }
        return empleadoRepo.save(empleado);
    }

    // TODO: POST, PUT Y PATCH RELACION VERDULERIA Y TEST
}
