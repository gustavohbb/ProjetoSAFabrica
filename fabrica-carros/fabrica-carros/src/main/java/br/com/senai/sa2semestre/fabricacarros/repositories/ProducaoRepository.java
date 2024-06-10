package br.com.senai.sa2semestre.fabricacarros.repositories;

import br.com.senai.sa2semestre.fabricacarros.entities.Producao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducaoRepository extends JpaRepository<Producao, Long> {
}
