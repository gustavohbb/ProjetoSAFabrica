package br.com.senai.sa2semestre.fabricacarros.controllers;

import br.com.senai.sa2semestre.fabricacarros.entities.Equipamento;
import br.com.senai.sa2semestre.fabricacarros.repositories.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {
    @Autowired
    private EquipamentoRepository equipamentoRepository;
    /**
     * Obtém todos os equipamentos.
     * @return uma lista de equipamentos.
     */
    @GetMapping
    public List<Equipamento> getAllEquipamentos() {
        return equipamentoRepository.findAll();
    }

    /**
     * Obtém um equipamento por ID.
     * @param idParaBuscar o ID do equipamento.
     * @return o equipamento com o ID especificado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Equipamento> getEquipamentoById(@PathVariable Long idParaBuscar) {
        Optional<Equipamento> equipamentoBuscado = equipamentoRepository.findById(idParaBuscar);
        return equipamentoBuscado.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo equipamento.
     * @param equipamento o novo equipamento.
     * @return o equipamento criado.
     */
    @PostMapping
    public Equipamento createEquipamento(@RequestBody Equipamento equipamento) {
        return equipamentoRepository.save(equipamento);
    }

    /**
     * Atualiza um equipamento existente.
     * @param id o ID do equipamento a ser atualizado.
     * @param equipamentoComDadosAtualizados os novos dados do equipamento.
     * @return o equipamento atualizado.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Equipamento> updateEquipamento(@PathVariable Long id,
                                                         @RequestBody Equipamento equipamentoComDadosAtualizados) {
        Optional<Equipamento> equipamentoExistente = equipamentoRepository.findById(id);
        if (equipamentoExistente.isPresent()) {
            equipamentoComDadosAtualizados.setIdEquipameto(id);
            return ResponseEntity.ok(equipamentoRepository.save(equipamentoComDadosAtualizados));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui um equipamento por ID.
     * @param idDoObjetoParaDeletar o ID do equipamento a ser excluído.
     * @return uma resposta indicando o sucesso ou falha da operação.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipamento(@PathVariable Long idDoObjetoParaDeletar) {
        Optional<Equipamento> equipamentoParaDeletar = equipamentoRepository.findById(idDoObjetoParaDeletar);
        if (equipamentoParaDeletar.isPresent()) {
            equipamentoRepository.delete(equipamentoParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
