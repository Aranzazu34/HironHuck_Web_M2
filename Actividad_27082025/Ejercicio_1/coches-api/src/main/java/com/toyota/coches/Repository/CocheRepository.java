package com.toyota.coches.Repository;

import com.toyota.coches.Entity.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {
    // Aquí puedes añadir métodos personalizados si los necesitas
}

