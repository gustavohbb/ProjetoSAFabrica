package br.com.senai.sa2semestre.fabricacarros.controllers;

import br.com.senai.sa2semestre.fabricacarros.entities.Producao;
import br.com.senai.sa2semestre.fabricacarros.repositories.ProducaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producaoes")
public class ProducaoController {
    @Autowired
    private ProducaoRepository producaoRepository;

    /**
     * Obtém todas as Produções.
     *
     * @return uma lista das Produções.
     */
    @GetMapping
    public List<Producao> getAllProducao() {
        return producaoRepository.findAll();
    }

    /**
     * Obtém uma Produção por ID.
     *
     * @param id o ID da Produção.
     * @return a PRodução com o ID especificado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Producao> getProducaoById(@PathVariable Long id) {
        Optional<Producao> producaoBuscada = producaoRepository.findById(id);
        return producaoBuscada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova Produção.
     *
     * @param producao a nova Produção.
     * @return a Produção criada.
     */
    @PostMapping
    public Producao createProducao(@RequestBody Producao producao) {
        return producaoRepository.save(producao);
    }

    /**
     * Atualiza uma Produção existente.
     *
     * @param id           o ID da Produção a ser atualizada.
     * @param novaProducao da Peça.
     * @return a Produção atualizada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Producao> updateProducao(@PathVariable Long id, @RequestBody Producao novaProducao) {
        Optional<Producao> producaoExistente = producaoRepository.findById(id);
        if (producaoExistente.isPresent()) {
            novaProducao.setIdProducao(id);
            return ResponseEntity.ok(producaoRepository.save(novaProducao));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui uma Produção por ID.
     *
     * @param id o ID da Produção ser excluída.
     * @return uma resposta indicando o sucesso ou falha da operação.
     */
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
