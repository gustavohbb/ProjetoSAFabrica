package br.com.senai.sa2semestre.fabricacarros.controllers;

import br.com.senai.sa2semestre.fabricacarros.entities.Estoque;
import br.com.senai.sa2semestre.fabricacarros.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping
    public List<Estoque> getAllEstoques() {
        return estoqueRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> getEstoqueById(@PathVariable Long id) {
        Optional<Estoque> estoqueBuscado = estoqueRepository.findById(id);
        return estoqueBuscado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estoque createEstoque(@RequestBody Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estoque> updateEstoque(@PathVariable Long id, @RequestBody Estoque estoque) {
        Optional<Estoque> estoqueExistente = estoqueRepository.findById(id);
        if (estoqueExistente.isPresent()) {
            estoque.setId(id);
            return ResponseEntity.ok(estoqueRepository.save(estoque));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstoque(@PathVariable Long id) {
        Optional<Estoque> estoqueParaDeletar = estoqueRepository.findById(id);
        if (estoqueParaDeletar.isPresent()) {
            estoqueRepository.delete(estoqueParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
