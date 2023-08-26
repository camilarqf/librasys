package br.com.librasys.infrastructure.repository;

import br.com.librasys.domain.model.Usuario;
import br.com.librasys.domain.port.UsuarioRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryJPA implements UsuarioRepository {


    private final SpringDataUsuarioRepositoryJPA springDataUsuarioRepositoryJPA;

    public UsuarioRepositoryJPA(SpringDataUsuarioRepositoryJPA springDataUsuarioRepositoryJPA) {
        this.springDataUsuarioRepositoryJPA = springDataUsuarioRepositoryJPA;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return springDataUsuarioRepositoryJPA.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return springDataUsuarioRepositoryJPA.findById(id);
    }

    @Override
    public List<Usuario> findAll(){
        return springDataUsuarioRepositoryJPA.findAll();
    }

    @Override
    public void delete(Usuario usuario){
        springDataUsuarioRepositoryJPA.delete(usuario);
    }

    @Override
    public void deleteById(Long id){
        springDataUsuarioRepositoryJPA.deleteById(id);
    }


}
