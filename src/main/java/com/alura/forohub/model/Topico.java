package com.alura.forohub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String titulo;
    @Column
    private String mensaje;
    @Column
    private Date fechaCreacion;
    @Column
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario autor;
}
