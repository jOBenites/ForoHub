ALTER table topicos
    ADD CONSTRAINT fk_topicos_cursos
        FOREIGN KEY (curso_id)
            REFERENCES cursos (id);

ALTER table topicos
    ADD CONSTRAINT fk_topicos_autores
        FOREIGN KEY (usuario_id)
            REFERENCES usuarios (id);