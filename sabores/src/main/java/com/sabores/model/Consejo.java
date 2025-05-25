package com.sabores.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Consejo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    //Union a la tabla recetas
    @ManyToOne
    @JsonBackReference // evita bucles
    @JoinColumn(name = "receta_id")
    private Receta receta;

    //Constructo vacio
    public Consejo(){
    }
    //Constructor con parametros
    public Consejo(String texto, Receta receta){
        this.texto = texto;
        this.receta = receta;
    }
    public Long getId(){
        return id;
    }
    //Getter y setters
    public String getTexto(){
        return texto;
    }
    public void setTexto(String texto){
        this.texto=texto;
    }

    public Receta getReceta(){
        return receta;
    } 
    public void setReceta(Receta receta){
        this.receta=receta;
    }
}
