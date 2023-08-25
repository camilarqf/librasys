package br.com.librasys.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reserva")
@Getter
@Setter
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1947504941238806324L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private LocalDate dataReserva;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "usuario_fk"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "livro_fk"))
    private Livro livro;

}
