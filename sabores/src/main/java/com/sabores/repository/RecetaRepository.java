package com.sabores.repository;

import com.sabores.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Esta interfaz nos da acceso automatico a consultas de Receta
@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long>{
    
}
