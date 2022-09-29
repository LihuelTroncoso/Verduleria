package com.example.demo.controllers;

import com.example.demo.domain.Cajon;
import com.example.demo.domain.Papa;
import com.example.demo.repository.CajonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cajones")
public class CajonController {
    @Autowired
    CajonRepository cajonRepo;

    @GetMapping
    public List<Cajon> getCajones() {
        return cajonRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cajon> getCajonById(@RequestBody Long id) {
        return cajonRepo.findById(id);
    }

    @PostMapping
    public void insertExhibition(@RequestBody Cajon cajon){
        cajonRepo.save(cajon);
    }

    @PutMapping("/{id}")
    public Cajon updateCajon(@RequestBody Cajon newCajon, @PathVariable Long id) {
        return cajonRepo.findById(id).map(cajon -> {
            cajon.setIdCajon(newCajon.getIdCajon());
            cajon.setUbicacion(newCajon.getUbicacion());
            cajon.setPapas(newCajon.getPapas());
            return cajonRepo.save(cajon);
        }).orElseGet(() -> {
            return cajonRepo.save(newCajon);
        });
    }

    @DeleteMapping("/{id}")
    public void deleteCajon(@PathVariable Long id) {
        cajonRepo.deleteById(id);
    }
}
