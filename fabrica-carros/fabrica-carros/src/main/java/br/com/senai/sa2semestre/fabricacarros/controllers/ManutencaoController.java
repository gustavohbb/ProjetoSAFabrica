package br.com.senai.sa2semestre.fabricacarros.controllers;


import br.com.senai.sa2semestre.fabricacarros.entities.Manutencao;
import br.com.senai.sa2semestre.fabricacarros.repositories.ManutencaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manutencaoes")
public class ManutencaoController {
    @Autowired
    private ManutencaoRepository manutencaoRepository;

    /**
     * Obtém todas as Manutenções.
     *
     * @return uma lista de Manutenções.
     */
    @GetMapping
    public List<Manutencao> getAllManutencao() {
        return manutencaoRepository.findAll();
    }

    /**
     * Obtém uma Manuntenção por ID.
     *
     * @param id o ID da Manutenção.
     * @return a Manutenção com o ID especificado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Manutencao> getManutencaoById(@PathVariable Long id) {
        Optional<Manutencao> manutencaoBuscada = manutencaoRepository.findById(id);
        return manutencaoBuscada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova Manutenção.
     *
     * @param manutencao a nova Manutenção.
     * @return a Manutenção criado.
     */
    @PostMapping
    public Manutencao createManutencao(@Validated @RequestBody Manutencao manutencao) {
        return manutencaoRepository.save(manutencao);
    }

    /**
     * Atualiza uma Manutenção existente.
     *
     * @param id                            o ID da Manutenção a ser atualizada.
     * @param manutencaoComDadosAtualizados novos dados da Manutenção.
     * @return a Manuntenção atualizada.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Manutencao> updateManutencao(@PathVariable Long id, @RequestBody Manutencao manutencaoComDadosAtualizados) {
        Optional<Manutencao> manutencaoExistente = manutencaoRepository.findById(id);
        if (manutencaoExistente.isPresent()) {
            manutencaoComDadosAtualizados.setIdManutencao(id);
            return ResponseEntity.ok(manutencaoRepository.save(manutencaoComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui uma Manutenção por ID.
     *
     * @param id o ID da Manutenção ser excluída.
     * @return uma resposta indicando o sucesso ou falha da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManutencao(@PathVariable Long id) {
        Optional<Manutencao> manutencaoParaDeletar = manutencaoRepository.findById(id);
        if (manutencaoParaDeletar.isPresent()) {
            manutencaoRepository.delete(manutencaoParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
