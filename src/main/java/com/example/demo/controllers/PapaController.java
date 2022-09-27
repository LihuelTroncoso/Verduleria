package com.example.demo.controllers;

import com.example.demo.domain.Papa;
import com.example.demo.repository.PapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/papas")
public class PapaController {
    @Autowired
    PapaRepository papaRepository;
    @GetMapping()
    public List<Papa> getExhibitions(){
        return papaRepository.findAll();
    }

    @PostMapping
    public void insertExhibition(@RequestBody Papa papa){
        papaRepository.save(papa);
    }

    @PutMapping("/{id}")
    public Papa updatePapa(@RequestBody Papa newPapa, @PathVariable Integer id){
        return papaRepository.findById(id).map(papa ->{
            papa.setEdad(newPapa.getEdad());
            papa.setNombre(newPapa.getNombre());
            return papaRepository.save(papa);
        }).orElseGet(()->{return papaRepository.save(newPapa);});
    }

    @DeleteMapping("/{id}")
    public void deletePapa(@PathVariable Integer id){
        papaRepository.deleteById(id);
    }
}
