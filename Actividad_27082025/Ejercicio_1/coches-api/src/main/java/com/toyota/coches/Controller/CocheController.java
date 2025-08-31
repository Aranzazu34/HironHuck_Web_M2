package com.toyota.coches.Controller;

import com.toyota.coches.Entity.Coche;
import com.toyota.coches.Repository.CocheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coches")
public class CocheController {

    @Autowired
    private CocheRepository cocheRepository;

    @GetMapping
    public List<Coche> getAllCoches() {
        return cocheRepository.findAll();
    }

    @PostMapping
    public Coche createCoche(@RequestBody Coche coche) {
        return cocheRepository.save(coche);
    }

    @GetMapping("/{id}")
    public Coche getCocheById(@PathVariable Long id) {
        return cocheRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteCoche(@PathVariable Long id) {
        cocheRepository.deleteById(id);
    }
}

