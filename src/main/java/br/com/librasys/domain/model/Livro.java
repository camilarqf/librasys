package br.com.librasys.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "livro")
public class Livro implements Serializable {
    private static final long serialVersionUID = -8759583768865477122L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String autor;

    private Integer ano;

    private String imagem;

    @Column(nullable = false)
    private Integer quantidade = 0;

    @JsonIgnore
    @OneToMany(mappedBy = "livro", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Genero> generos = new ArrayList<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

}
