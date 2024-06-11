package br.com.senai.sa2semestre.fabricacarros.controllers;

import br.com.senai.sa2semestre.fabricacarros.entities.Veiculo;
import br.com.senai.sa2semestre.fabricacarros.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoRepository veiculoRepository;

    /**
     * Obtém todos os Veiculos.
     *
     * @return uma lista de Veiculo.
     */
    @GetMapping
    public List<Veiculo> getAllVeiculo() {
        return veiculoRepository.findAll();
    }

    /**
     * Obtém um Veiculo por ID.
     *
     * @param chassi o ID do Veiculo.
     * @return o Veiculo com o ID especificado.
     */
    @GetMapping("/{chassi}")
    public ResponseEntity<Veiculo> getVeiculoById(@PathVariable String chassi) {
        Optional<Veiculo> veiculoBuscado = veiculoRepository.findById(chassi);
        return veiculoBuscado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo Veiculo.
     *
     * @param veiculo o novo Veiculo.
     * @return o Veiculo criada.
     */
    @PostMapping
    public Veiculo createVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    /**
     * Atualiza um Veiculo existente.
     *
     * @param chassi            o ID do Veiculo a ser atualizada.
     * @param veiculoAtualizado novos dados do Veiculo.
     * @return o Veiculo atualizado.
     */
    @PutMapping("/{chassi}")
    public ResponseEntity<Veiculo> updateVeiculo(@PathVariable String chassi, @RequestBody Veiculo veiculoAtualizado) {
        Optional<Veiculo> veiculoExistente = veiculoRepository.findById(chassi);
        if (veiculoExistente.isPresent()) {
            veiculoAtualizado.setChassi(chassi);
            return ResponseEntity.ok(veiculoRepository.save(veiculoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Exclui um Veiculo por ID.
     *
     * @param chassi o ID do Veiculo a ser excluída.
     * @return uma resposta indicando o sucesso ou falha da operação.
     */
    @DeleteMapping("/{chassi}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable String chassi) {
        Optional<Veiculo> veiculoParaDeletar = veiculoRepository.findById(chassi);
        if (veiculoParaDeletar.isPresent()) {
            veiculoRepository.delete(veiculoParaDeletar.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
