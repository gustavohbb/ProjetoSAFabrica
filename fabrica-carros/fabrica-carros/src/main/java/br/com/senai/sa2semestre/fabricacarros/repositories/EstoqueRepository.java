package br.com.senai.sa2semestre.fabricacarros.repositories;

import br.com.senai.sa2semestre.fabricacarros.entities.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
