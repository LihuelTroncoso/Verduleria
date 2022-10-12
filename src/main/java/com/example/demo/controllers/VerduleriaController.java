package com.example.demo.controllers;

import com.example.demo.domain.Verduleria;
import com.example.demo.repository.VerduleriaRepository;
import com.example.demo.service.VerduleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/verdulerias")
public class VerduleriaController {
    @Autowired
    VerduleriaRepository verduleriaRepo;
    @Autowired
    VerduleriaService service;

    @GetMapping
    public List<Verduleria> getVerdulerias() {
        return verduleriaRepo.findAll();
    }

    @PostMapping
    public Verduleria insertVerduleria(@RequestBody Verduleria verduleria) {
        return verduleriaRepo.save(verduleria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Verduleria> getVerduleriasById(@PathVariable Long id) {
        return verduleriaRepo.findById(id).map(ResponseEntity.ok()::body)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @PutMapping("/{id}")
    public Verduleria updateVerdulerias(@RequestBody Verduleria newVerduleria, @PathVariable Long id) {
        return service.verduleriaUpdate(id, newVerduleria);
    }

    @DeleteMapping("/{id}")
    public void deleteVerdulerias(@PathVariable Long id) {
        verduleriaRepo.deleteById(id);
    }
}
