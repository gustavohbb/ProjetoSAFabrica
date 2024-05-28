package br.com.senai.sa2semestre.fabricacarros.repositories;


import br.com.senai.sa2semestre.fabricacarros.entities.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
}
