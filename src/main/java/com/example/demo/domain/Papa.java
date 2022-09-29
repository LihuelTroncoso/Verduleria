package com.example.demo.domain;


import javax.persistence.*;

@Entity
@Table(name = "papa")
public class Papa {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    private String nombre;

    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "cajon_id")
    private Cajon cajon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "Papa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
