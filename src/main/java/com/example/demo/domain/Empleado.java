package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Empleado {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String nombre;
    private Integer edad;
    @ManyToMany
    @JoinTable(name = "rel__verduleria_empleado",
            joinColumns = @JoinColumn(name = "verduleria_id"),
            inverseJoinColumns = @JoinColumn(name = "empleado_id"))
    private List<Verduleria> verdulerias;

    public Empleado(Long id, String nombre, Integer edad, List<Verduleria> verdulerias) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.verdulerias = verdulerias;
    }

    public Empleado(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Empleado() {
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

    public List<Verduleria> getVerdulerias() {
        return verdulerias;
    }

    public void setVerdulerias(List<Verduleria> verdulerias) {
        this.verdulerias = verdulerias;
    }

    @Override
    public String toString() {
        return "EmpleadoController{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", verdulerias=" + verdulerias +
                '}';
    }
}