package br.com.librasys.domain.model;

import br.com.librasys.domain.enums.TipoPerfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 8599345151675115472L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data = LocalDate.now();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Perfil")
    private Set<Integer> perfis = new HashSet<>();

    public Usuario() {
        addPerfil(TipoPerfil.USUARIO);
    }

    public Usuario(Long id, String login, String senha, LocalDate data) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.data = data;
        addPerfil(TipoPerfil.USUARIO);
    }

    public void addPerfil(TipoPerfil perfil){
        this.perfis.add(perfil.getCodigo());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return getId().equals(usuario.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
