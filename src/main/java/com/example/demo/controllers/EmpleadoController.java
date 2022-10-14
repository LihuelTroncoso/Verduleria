package com.example.demo.controllers;

import com.example.demo.domain.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    EmpleadoRepository empleadosRepo;
    @Autowired
    EmpleadoService service;

    @GetMapping
    public List<Empleado> getEmpleados() {
        return empleadosRepo.findAll();
    }

    @PostMapping
    public Empleado insertEmpleado(@RequestBody Empleado empleado) {
        return service.save(empleado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id) {
        return empleadosRepo.findById(id).map(ResponseEntity.ok()::body)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @PutMapping("/{id}")
    public Empleado updateEmpleado(@RequestBody Empleado newEmpleado, @PathVariable Long id) {
        return service.updateEmpleado(id, newEmpleado);
        //Se puede pasar a service esta funcion
    }

    @DeleteMapping("/{id}")
    public void deleteEmpleado(@PathVariable Long id) {
        empleadosRepo.deleteById(id);
    }
}
