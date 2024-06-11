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

    /**
     * Obtém todas as Peças.
     *
     * @return uma lista das Peças.
     */
    @GetMapping
    public List<Pecas> getAllPecas() {
        return pecasRepository.findAll();
    }

    /**
     * Obtém uma Peça por ID.
     *
     * @param id o ID da Peça.
     * @return a Peça com o ID especificado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Pecas> getPecasById(@PathVariable Long id) {
        Optional<Pecas> pecasBuscada = pecasRepository.findById(id);
        return pecasBuscada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova Peça.
     *
     * @param pecas a nova Peça.
     * @return a Peça criada.
     */
    @PostMapping
    public Pecas createPecas(@RequestBody Pecas pecas) {
        return pecasRepository.save(pecas);
    }

    /**
     * Atualiza uma Peça existente.
     *
     * @param id        o ID da Peça a ser atualizada.
     * @param novaPecas da Peça.
     * @return a Peça atualizada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Pecas> updatePecas(@PathVariable Long id, @RequestBody Pecas novaPecas) {
        Optional<Pecas> pecaExistente = pecasRepository.findById(id);
        if (pecaExistente.isPresent()) {
            novaPecas.setIdPecas(id);
            return ResponseEntity.ok(pecasRepository.save(novaPecas));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui uma Peça por ID.
     *
     * @param id o ID da Peça ser excluída.
     * @return uma resposta indicando o sucesso ou falha da operação.
     */
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
