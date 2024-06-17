package br.com.senai.sa2semestre.fabricacarros.controllers;

import br.com.senai.sa2semestre.fabricacarros.entities.Qualidade;
import br.com.senai.sa2semestre.fabricacarros.repositories.QualidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/qualidades")
public class QualidadeController {

    @Autowired
    private QualidadeRepository qualidadeRepository;

    /**
     * Obtém todas as Qualidades.
     *
     * @return uma lista de Qualidade.
     */
    @GetMapping
    public List<Qualidade> getAllQualiade() {
        return qualidadeRepository.findAll();
    }
    /**
     * Obtém uma Qualidade por ID.
     *
     * @param id o ID da Qualidade.
     * @return a Qualidade com o ID especificado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Qualidade> getQualidadeById(@PathVariable Long id) {
        Optional<Qualidade> qualidadeBuscada = qualidadeRepository.findById(id);
        return qualidadeBuscada.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }
    /**
     * Cria uma nova Qualidade.
     *
     * @param qualidade a nova Qualidade.
     * @return a Qualidade criada.
     */
    @PostMapping
    public Qualidade createQualidade(@RequestBody Qualidade qualidade) {
        return qualidadeRepository.save(qualidade);
    }
    /**
     * Atualiza uma Qualidade existente.
     *
     * @param id             o ID da Qualidade a ser atualizada.
     * @param qualidadeComDadosAtualizados novos dados da Qualidade.
     * @return a Qualidade atualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Qualidade> uptadeQualidade(@PathVariable Long id, @RequestBody Qualidade qualidadeComDadosAtualizados) {
        Optional<Qualidade> qualidadeExistente = qualidadeRepository.findById(id);
        if (qualidadeExistente.isPresent()) {
            qualidadeComDadosAtualizados.setIdInspecao(id);
            return ResponseEntity.ok(qualidadeRepository.save(qualidadeComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /**
     * Exclui uma Qualidade por ID.
     *
     * @param id o ID da Qualidade a ser excluída.
     * @return uma resposta indicando o sucesso ou falha da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeca(@PathVariable Long id) {
        Optional<Qualidade> qualidadeParaExcluir = qualidadeRepository.findById(id);
        if (qualidadeParaExcluir.isPresent()) {
            qualidadeRepository.delete(qualidadeParaExcluir.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}