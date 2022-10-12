package com.example.demo.controllers;

import com.example.demo.domain.Cajon;
import com.example.demo.domain.Papa;
import com.example.demo.repository.CajonRepository;
import com.example.demo.repository.PapaRepository;
import com.example.demo.service.PapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/papas")
public class PapaController {
    @Autowired
    PapaRepository papaRepository;

    @Autowired
    PapaService service;

    @GetMapping()
    public List<Papa> getPapas() {
        return papaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Papa> getPapaById(@PathVariable Long id) {
        return papaRepository.findById(id).map(ResponseEntity.ok()::body)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @PostMapping
    public Papa insertPapa(@RequestBody Papa papa) {
        return service.save(papa);
    }

    @PutMapping("/{id}")
    public Papa updatePapa(@RequestBody Papa newPapa, @PathVariable Long id) {
        return service.updatePapa(id, newPapa);
    }

    @DeleteMapping("/{id}")
    public void deletePapa(@PathVariable Long id) {
        papaRepository.deleteById(id);
    }
}
