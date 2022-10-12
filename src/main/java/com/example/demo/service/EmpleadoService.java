package com.example.demo.service;

import com.example.demo.domain.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepo;

    public Empleado updateEmpleado(Long id, Empleado newEmpleado) {
        return empleadoRepo.findById(id).map(empleado -> {
            empleado.setId(newEmpleado.getId());
            empleado.setEdad(newEmpleado.getEdad());
            empleado.setVerdulerias(newEmpleado.getVerdulerias());
            empleado.setNombre(newEmpleado.getNombre());
            return empleadoRepo.save(empleado);
        }).orElseThrow();
    }
    // TODO: POST, PUT Y PATCH RELACION VERDULERIA Y TEST
}
