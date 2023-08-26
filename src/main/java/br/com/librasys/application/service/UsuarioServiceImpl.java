package br.com.librasys.application.service;

import br.com.librasys.domain.model.Usuario;
import br.com.librasys.domain.port.UsuarioRepository;
import br.com.librasys.domain.port.UsuarioService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @Override
    public void delete(Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    @Override
    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }
}
