package com.example.demo.controllers;

import com.example.demo.domain.Empleado;
import com.example.demo.domain.Papa;
import com.example.demo.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    EmpleadoRepository empleadosRepo;

    @GetMapping
    public List<Empleado> getEmpleados() {
        return empleadosRepo.findAll();
    }

    @PostMapping
    public void insertExhibition(@RequestBody Empleado empleado){
        empleadosRepo.save(empleado);
    }

    @GetMapping("/{id}")
    public Optional<Empleado> getEmpleadoById(@RequestBody Long id) {
        return empleadosRepo.findById(id);
    }

    @PutMapping("/{id}")
    public Empleado updateEmpleado(@RequestBody Empleado newEmpleado, @PathVariable Long id) {
        return empleadosRepo.findById(id).map(empleado -> {
            empleado.setId(newEmpleado.getId());
            empleado.setEdad(newEmpleado.getEdad());
            empleado.setVerdulerias(newEmpleado.getVerdulerias());
            empleado.setNombre(newEmpleado.getNombre());
            return empleadosRepo.save(empleado);
        }).orElseGet(() -> {
            return empleadosRepo.save(newEmpleado);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable Long id) {
        empleadosRepo.deleteById(id);
    }
}
