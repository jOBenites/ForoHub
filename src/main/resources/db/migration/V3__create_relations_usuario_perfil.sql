ALTER table usuarios
    ADD CONSTRAINT fk_usuarios_perfiles
        FOREIGN KEY (perfil_id)
            REFERENCES perfiles (id);