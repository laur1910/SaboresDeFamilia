package com.sabores.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;;

@Entity
public class Paso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private int orden;

    @ManyToOne
    @JsonBackReference // evita bucles
    @JoinColumn(name = "receta_id")
    private Receta receta;

    //Constructo vacio
    public Paso(){
    }

    //Constructor con campos
    public Paso(String descripcion, int orden, Receta receta){
        this.descripcion = descripcion;
        this.orden = orden;
        this.receta = receta;
    }

    //Getter y setters
    public Long getId(){
        return id;
    }

    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String descripcion){
         this.descripcion = descripcion;
    }

    public int getOrden(){
        return orden;
    }
    public void setOrden(int orden){
        this.orden = orden;
    }

    public Receta getReceta(){
        return receta;
    }
    public void setReceta(Receta receta){
        this.receta = receta;
    }
}
