package com.sabores.config;

import com.sabores.model.*;
import com.sabores.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader {

    @Bean
CommandLineRunner initDatabase(
        RecetaRepository recetaRepo,
        IngredienteRepository ingredienteRepo,
        PasoRepository pasoRepo,
        ConsejoRepository consejoRepo) {

    return args -> {
    try {
        System.out.println("📥 Insertando receta de prueba...");

        Receta receta = new Receta("Tarta de manzana", "Receta tradicional de mi abuela para los domingos.");
        receta = recetaRepo.save(receta);
        System.out.println("✅ Receta guardada con ID: " + receta.getId());

        Ingrediente i1 = new Ingrediente("Manzanas", "3", receta);
        Ingrediente i2 = new Ingrediente("Harina", "200g", receta);
        ingredienteRepo.saveAll(Arrays.asList(i1, i2));
        System.out.println("✅ Ingredientes guardados");

        Paso p1 = new Paso("Pelar las manzanas", 1, receta);
        Paso p2 = new Paso("Mezclar con la harina", 2, receta);
        pasoRepo.saveAll(Arrays.asList(p1, p2));
        System.out.println("✅ Pasos guardados");

        Consejo c1 = new Consejo("Usar manzanas verdes", receta);
        Consejo c2 = new Consejo("Hornear a 180°C por 40 min", receta);
        consejoRepo.saveAll(Arrays.asList(c1, c2));
        System.out.println("✅ Consejos guardados");

        System.out.println("✅ Todo cargado correctamente.");

    } catch (Exception e) {
        System.out.println("❌ Error durante la carga de prueba:");
        e.printStackTrace();
    }
};
}

}
