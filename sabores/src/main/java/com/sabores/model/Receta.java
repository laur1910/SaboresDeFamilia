package com.sabores.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;


//Representacion de una entidad receta(tabla de la bbdd)
@Entity
public class Receta {
    //Clave primaria de la tabla, se generera automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  Long id;
     //Titulo y historia de la receta
     private String titulo;
     private String historia;

     @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL)
     @JsonManagedReference
     private List<Ingrediente> ingredientes = new ArrayList<>();
     @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL)
     @JsonManagedReference
     private List<Paso> pasos = new ArrayList<>();
     @OneToMany(mappedBy = "receta", cascade = CascadeType.ALL)
     @JsonManagedReference
     private List<Consejo> consejos = new ArrayList<>();

    //Constructor vacio requerido por JPA
    public Receta(){
    };
     //Constructor con parametros para crear objetos
    public Receta(String titulo, String historia) {
        this.titulo = titulo;
        this.historia = historia;
    }
    //Getter del id, sin setter proque se genera solo
    public Long getId(){
        return id;
    }
    //Getter y setter del titulo
    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    //Getter y setter de historia
    public String getHistoria(){
        return historia;
    }
    public void setHistoria(String historia){
        this.historia = historia;
    }
    //Getter y setter de ingredientes
    public List<Ingrediente> getIngredientes(){
        return ingredientes;
    }
    public void setIngredientes(List<Ingrediente> ingredentes){
        this.ingredientes = ingredentes;
    } 
    //Getter y setter de pasos
    public List<Paso> getPasos(){
        return pasos;
    }
    public void setPasos(List<Paso> pasos){
        this.pasos = pasos;
    }
    //Getter y setter de consejos
    public List<Consejo> getConsejos(){
        return consejos;
    }
    public void setConsejos(List<Consejo> consejos){
        this.consejos=consejos;
    }
}
