CREATE TABLE rol_permiso (
    id SERIAL PRIMARY KEY,
    id_rol INT NOT NULL,
    id_permiso INT NOT NULL,
    FOREIGN KEY (id_rol) REFERENCES rol(id_rol),
    FOREIGN KEY (id_permiso) REFERENCES permiso(id_permiso)
);