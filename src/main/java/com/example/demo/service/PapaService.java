package com.example.demo.service;

import com.example.demo.domain.Cajon;
import com.example.demo.domain.Papa;
import com.example.demo.repository.CajonRepository;
import com.example.demo.repository.PapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PapaService {
    @Autowired
    PapaRepository papaRepository;

    @Autowired
    CajonRepository cajonRepository;

    public Papa updatePapa(Long id, Papa newPapa) {
        return papaRepository.findById(id).map(papa -> {
            papa.setEdad(newPapa.getEdad());
            papa.setNombre(newPapa.getNombre());
            return papaRepository.save(papa);
        }).orElseThrow();
    }

    public Papa save(Papa papa){
        if(papa.getCajon() != null && papa.getCajon().getIdCajon() != null){
            Optional<Cajon> cajon = cajonRepository.findById(papa.getCajon().getIdCajon());
            if(cajon.isEmpty()){
                throw new IllegalArgumentException("No existe un cajon con ese id");
            }
            papa.setCajon(cajon.get()); // TODO: TEST
        }
        return papaRepository.save(papa);
    }

    // TODO: PATCH Y PUT CAJONES Y TESTS
}
