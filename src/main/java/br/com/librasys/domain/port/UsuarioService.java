package br.com.librasys.domain.port;

import br.com.librasys.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Long id);
    List<Usuario> findAll();
    void delete(Usuario usuario);
    void deleteById(Long id);
}
