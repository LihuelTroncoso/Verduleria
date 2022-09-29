package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Verduleria {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String nombre;

    @ManyToMany(mappedBy = "verdulerias")
    private List<Empleado> empleados;

    public Verduleria(Long id, String nombre, List<Empleado> empleados) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = empleados;
    }

    public Verduleria() {
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

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Verduleria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", empleados=" + empleados +
                '}';
    }
}
