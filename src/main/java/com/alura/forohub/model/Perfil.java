package com.alura.forohub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "perfiles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String nombre;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
    private List<Usuario> usuario;*/
}
