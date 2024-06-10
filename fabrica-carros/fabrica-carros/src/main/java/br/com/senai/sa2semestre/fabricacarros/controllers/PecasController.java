package br.com.senai.sa2semestre.fabricacarros.controllers;

import br.com.senai.sa2semestre.fabricacarros.entities.Pecas;
import br.com.senai.sa2semestre.fabricacarros.repositories.PecasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pecas")

public class PecasController {
    @Autowired
    private PecasRepository pecasRepository;

    @GetMapping
    public List<Pecas> getAllPecas() {
        return pecasRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pecas> getPecasById(@PathVariable Long id) {
        Optional<Pecas> pecasBuscada = pecasRepository.findById(id);
        return pecasBuscada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pecas createPecas(@RequestBody Pecas pecas) {
        return pecasRepository.save(pecas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pecas> updatePecas(@PathVariable Long id, @RequestBody Pecas pecas) {
        Optional<Pecas> pecaExistente = pecasRepository.findById(id);
        if (pecaExistente.isPresent()) {
            pecas.setIdPecas(id);
            return ResponseEntity.ok(pecasRepository.save(pecas));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeca(@PathVariable Long id) {
        Optional<Pecas> pecaParaDeletar = pecasRepository.findById(id);
        if (pecaParaDeletar.isPresent()) {
            pecasRepository.delete(pecaParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
