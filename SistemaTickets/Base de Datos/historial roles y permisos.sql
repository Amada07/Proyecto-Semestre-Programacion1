CREATE TABLE historial_cambios (
    id SERIAL PRIMARY KEY,
    accion VARCHAR(255),
    usuario VARCHAR(50),
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
