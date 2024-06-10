package br.com.senai.sa2semestre.fabricacarros.repositories;

import br.com.senai.sa2semestre.fabricacarros.entities.Qualidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualidadeRepository extends JpaRepository<Qualidade, Long> {
}
