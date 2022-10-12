package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Papa {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String nombre;

    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "cajon_id")
    @JsonBackReference
    private Cajon cajon;

    public Papa(Long id, String nombre, Integer edad, Cajon cajon) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.cajon = cajon;
    }

    public Papa() {
    }

    public Papa(String nombre, Integer edad, Cajon cajon) {
        this.nombre = nombre;
        this.edad = edad;
        this.cajon = cajon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Cajon getCajon() {
        return cajon;
    }

    public void setCajon(Cajon cajon) {
        this.cajon = cajon;
    }

    @Override
    public String toString() {
        return "Papa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
