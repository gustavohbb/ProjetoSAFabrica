package br.com.senai.sa2semestre.fabricacarros.repositories;

import br.com.senai.sa2semestre.fabricacarros.entities.Pecas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PecasRepository extends JpaRepository<Pecas, Long > {
}
