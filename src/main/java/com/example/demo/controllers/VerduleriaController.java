package com.example.demo.controllers;

import com.example.demo.domain.Papa;
import com.example.demo.domain.Verduleria;
import com.example.demo.repository.VerduleriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/verdulerias")
public class VerduleriaController {
    @Autowired
    VerduleriaRepository verduleriaRepo;

    @GetMapping
    public List<Verduleria> getVerdulerias() {
        return verduleriaRepo.findAll();
    }

    @PostMapping
    public void insertExhibition(@RequestBody Verduleria verduleria){
        verduleriaRepo.save(verduleria);
    }

    @GetMapping("/{id}")
    public Optional<Verduleria> getVerduleriasById(@RequestBody Long id) {
        return verduleriaRepo.findById(id);
    }

    @PutMapping("/{id}")
    public Verduleria updateVerdulerias(@RequestBody Verduleria newVerduleria, @PathVariable Long id) {
        return verduleriaRepo.findById(id).map(verduleria -> {
            verduleria.setId(newVerduleria.getId());
            verduleria.setNombre(newVerduleria.getNombre());
            verduleria.setEmpleados(newVerduleria.getEmpleados());
            return verduleriaRepo.save(verduleria);
        }).orElseGet(() -> {
            return verduleriaRepo.save(newVerduleria);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteVerdulerias(@PathVariable Long id) {
        verduleriaRepo.deleteById(id);
    }
}
