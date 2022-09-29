package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cajon")
public class Cajon {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idCajon;

    private String ubicacion;
    @OneToMany(mappedBy = "cajon")
    private List<Papa> papas;

    public Cajon(Long idCajon, String ubicacion, List<Papa> papas) {
        this.idCajon = idCajon;
        this.ubicacion = ubicacion;
        this.papas = papas;
    }

    public Cajon() {
    }



    public Long getIdCajon() {
        return idCajon;
    }

    public void setIdCajon(Long idCajon) {
        this.idCajon = idCajon;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Papa> getPapas() {
        return papas;
    }

    public void setPapas(List<Papa> papas) {
        this.papas = papas;
    }

    @Override
    public String toString() {
        return "Cajon{" +
                "idCajon=" + idCajon +
                ", ubicacion='" + ubicacion + '\'' +
                ", papas=" + papas +
                '}';
    }
}