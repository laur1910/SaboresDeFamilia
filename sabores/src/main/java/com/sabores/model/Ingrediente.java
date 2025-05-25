package com.sabores.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Ingrediente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String cantidad;

    @ManyToOne
    @JsonBackReference // evita bucles
    @JoinColumn(name = "receta_id")
    private Receta receta;

    //Contructor vacio
    public Ingrediente(){
    }
    //Constructor con parametros
    public Ingrediente(String nombre, String cantidad, Receta receta){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.receta = receta;
    }

    //Getters and Setters

    public Long getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public String getCantidad(){
        return cantidad;
    }
    public void setCantidad(String cantidad){
        this.cantidad=cantidad;
    }

    public Receta getReceta(){
        return receta;
    }
    public void setReceta(Receta receta){
        this.receta = receta;
    }
}
