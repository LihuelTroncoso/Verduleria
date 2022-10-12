package com.example.demo.service;

import com.example.demo.domain.Cajon;
import com.example.demo.repository.CajonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CajonService {
    @Autowired
    CajonRepository cajonRepo;

    public Cajon updateCajon(Long id, Cajon newCajon){
        return cajonRepo.findById(id).map(cajon -> {
            cajon.setIdCajon(newCajon.getIdCajon());
            cajon.setUbicacion(newCajon.getUbicacion());
            cajon.setPapas(newCajon.getPapas());
            return cajonRepo.save(cajon);
        }).orElseThrow();
    }

    // TODO: POST, PUT Y PATCH RELACION PAPA Y TEST
}
