-- Tabla estado_ticket
CREATE TABLE estado_ticket (
    id_estado SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    estado_final BOOLEAN NOT NULL,
    estados_permitidos_siguientes TEXT
);