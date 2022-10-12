package com.example.demo.controllers;

import com.example.demo.domain.Cajon;
import com.example.demo.domain.Papa;
import com.example.demo.repository.CajonRepository;
import com.example.demo.service.CajonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@RestController
@RequestMapping("/cajones")
public class CajonController {
    @Autowired
    CajonRepository cajonRepo;
    @Autowired
    CajonService service;

    @GetMapping
    public List<Cajon> getCajones() {
        return cajonRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cajon> getCajonById(@PathVariable Long id) {
        /*Optional<Cajon> res = cajonRepo.findById(id);
        if(res.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(res.get());*/
        ///////////////////////////////////////////////
        /*
        return cajonRepo.findById(id).map(res -> ResponseEntity.ok().body(res))
                .orElseGet(() -> ResponseEntity.notFound().build());
        ESTO SE TRANSFORMO A:*/
        return cajonRepo.findById(id).map(ResponseEntity.ok()::body)
                .orElseGet(ResponseEntity.notFound()::build);
        //el '::' convierte una funcion existente en una interfaz funcional
    }
    //Interfaces funcionales
    //interfaz funcional = funcion hecha objeto
    //Consumer: Consume un parametro, y no devuelve nada
    //Suplier: Devuelve sin pedir ningun parametro
    //Function: Pide algo y devuelve algo
    public void metodoQueAceptaUnaFuncion(Function<Cajon, Long> idGetter){
        //function.accept(new Cajon());
        //function.get();
        //function.apply(new Cajon());
        Cajon cajon = new Cajon(1, "asdas");
        Long res = idGetter.apply(cajon);
    }

    public void yoConsumoLaFuncionDeArriba(){
        metodoQueAceptaUnaFuncion(Cajon::getIdCajon);
    }

    @PostMapping
    public Cajon insertCajon(@RequestBody Cajon cajon) {
        return cajonRepo.save(cajon);
    }

    @PutMapping("/{id}")
    public Cajon updateCajon(@RequestBody Cajon newCajon, @PathVariable Long id) {
        return service.updateCajon(id, newCajon);
    }

    @DeleteMapping("/{id}")
    public void deleteCajon(@PathVariable Long id) {
        cajonRepo.deleteById(id);
    }
}
