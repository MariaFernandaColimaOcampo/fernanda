package mx.edu.utez.proyecto1D.model.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.proyecto1D.model.cursos.Curso;
import mx.edu.utez.proyecto1D.model.persona.Persona;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username1", nullable = false, unique = true)
    private String username;
    private String password;
    private boolean isEnable;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private Roles rol;
    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
/*
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"),
            name = "personas_cursos"
    )
    private List<Curso> cursos;*/
}

