ALTER table respuestas
    ADD CONSTRAINT fk_respuestas_usuarios
        FOREIGN KEY (usuario_id)
            REFERENCES usuarios (id);

ALTER table respuestas
    ADD CONSTRAINT fk_respuestas_topicos
        FOREIGN KEY (topico_id)
            REFERENCES topicos (id);