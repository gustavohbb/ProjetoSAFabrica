package br.com.senai.sa2semestre.fabricacarros.controllers;

import br.com.senai.sa2semestre.fabricacarros.entities.Producao;
import br.com.senai.sa2semestre.fabricacarros.repositories.ProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producao")
public class ProducaoController {
    @Autowired
    private ProducaoRepository producaoRepository;

    @GetMapping
    public List<Producao> getAllProducao() {
        return producaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producao> getProducaoById(@PathVariable Long id) {
        Optional<Producao> producaoBuscada = producaoRepository.findById(id);
        return producaoBuscada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producao createProducao(@RequestBody Producao producao) {
        return producaoRepository.save(producao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producao> updateProducao(@PathVariable Long id, @RequestBody Producao producao) {
        Optional<Producao> producaoExistente = producaoRepository.findById(id);
        if (producaoExistente.isPresent()) {
            producao.setIdProducao(id);
            return ResponseEntity.ok(producaoRepository.save(producao));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduca(@PathVariable Long id) {
        Optional<Producao> producaoParaDeletar = producaoRepository.findById(id);
        if (producaoParaDeletar.isPresent()) {
            producaoRepository.delete(producaoParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
