package br.com.librasys.infrastructure.controller;

import br.com.librasys.domain.model.Usuario;
import br.com.librasys.domain.port.UsuarioService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Usuario usuario){
        try {
            usuarioService.save(usuario);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @GetMapping
    public ResponseEntity<Usuario> getById(@RequestParam Long id){
        try {
            Optional<Usuario> usuarioOptional = usuarioService.findById(id);
            if(usuarioOptional.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Usuario usuario = usuarioOptional.get();
            return new ResponseEntity<>(usuario, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Usuario>> findAll(){
        try {
            List<Usuario> usuarioList = usuarioService.findAll();
            if(usuarioList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<List<Usuario>>(usuarioList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Usuario> edit(@RequestParam Long id, @RequestBody Usuario usuario){
        try {
            usuario.setId(id);
            usuarioService.save(usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<Usuario> delete(@RequestParam Long id){
        try {
            usuarioService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
