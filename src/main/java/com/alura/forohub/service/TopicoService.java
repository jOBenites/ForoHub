package com.alura.forohub.service;

import com.alura.forohub.controller.dto.TopicoRequest;
import com.alura.forohub.model.Curso;
import com.alura.forohub.model.Topico;
import com.alura.forohub.model.Usuario;
import com.alura.forohub.repository.TopicoRepository;
import com.alura.forohub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository repository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Topico> readTopico(){
        List<Topico> lst = repository.findAll();
        return lst.stream().filter(topico -> topico.getStatus().equals("1")).toList();
    }

    public Topico createTopico(TopicoRequest request){

        Usuario usuario = getAutor(request.autorId());
        if(usuario != null){
            Topico entity =  Topico.builder()
                    .titulo(request.titulo())
                    .mensaje(request.mensaje())
                    .fechaCreacion(new Date())
                    .status("1")
                    .autor(usuario)
                    .curso(Curso.builder().Id(request.cursoId()).build())
                    .build();

            return repository.save(entity);
        }
        return null;
    }

    public Topico updateTopico(TopicoRequest request, Long id){
        Optional<Topico> topico =  repository.findById(id);
        Usuario usuario = getAutor(request.autorId());
        if(topico.isPresent() && usuario != null){
            Topico entity =  Topico.builder()
                    .Id(topico.get().getId())
                    .titulo(request.titulo())
                    .mensaje(request.mensaje())
                    .fechaCreacion(new Date())
                    .status("1")
                    .autor(usuario)
                    .curso(Curso.builder().Id(request.cursoId()).build())
                    .build();

            return repository.save(entity);
        }
        return null;
    }

    public Topico deleteTopico(Long id){
        Optional<Topico> topico =  repository.findById(id);
        if(topico.isPresent()){
            Topico entity =  Topico.builder()
                    .Id(topico.get().getId())
                    .titulo(topico.get().getTitulo())
                    .mensaje(topico.get().getMensaje())
                    .fechaCreacion(topico.get().getFechaCreacion())
                    .status("0")
                    .autor(topico.get().getAutor())
                    .curso(topico.get().getCurso())
                    .build();

            return repository.save(entity);
        }
        return null;
    }

    public Topico findTopico(Long id){
        Optional<Topico> topico = repository.findById(id);
        return topico.orElse(null);
    }

    public Usuario getAutor(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }
}
