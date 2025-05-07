-- Tabla permiso
CREATE TABLE permiso (
    id_permiso SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);