-- Tabla rol
CREATE TABLE rol (
    id_rol SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);