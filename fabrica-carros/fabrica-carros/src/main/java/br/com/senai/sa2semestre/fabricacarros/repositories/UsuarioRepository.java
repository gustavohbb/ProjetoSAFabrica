package br.com.senai.sa2semestre.fabricacarros.repositories;

import br.com.senai.sa2semestre.fabricacarros.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
