package br.com.senai.sa2semestre.fabricacarros.controllers;

import br.com.senai.sa2semestre.fabricacarros.entities.Qualidade;
import br.com.senai.sa2semestre.fabricacarros.repositories.QualidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/qualidade")
public class QualidadeController {
    @Autowired
    private QualidadeRepository qualidadeRepository;

    @GetMapping
    public List<Qualidade> getAllQualidade() {
        return qualidadeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Qualidade> getQualidadeById(@PathVariable Long id) {
        Optional<Qualidade> qualidadeBuscada = qualidadeRepository.findById(id);
        return qualidadeBuscada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Qualidade createQualidade(@RequestBody Qualidade qualidade) {
        return qualidadeRepository.save(qualidade);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Qualidade> updateQualidade(@PathVariable Long id, @RequestBody Qualidade qualidade) {
        Optional<Qualidade> qualidadeExistente = qualidadeRepository.findById(id);
        if (qualidadeExistente.isPresent()) {
            qualidade.setIdInspecao(id);
            return ResponseEntity.ok(qualidadeRepository.save(qualidade));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQualidade(@PathVariable Long id) {
        Optional<Qualidade> qualidadeParaDeletar = qualidadeRepository.findById(id);
        if (qualidadeParaDeletar.isPresent()) {
            qualidadeRepository.delete(qualidadeParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
