package br.com.librasys.infrastructure.repository;

import br.com.librasys.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUsuarioRepositoryJPA extends JpaRepository<Usuario, Long> {

}
