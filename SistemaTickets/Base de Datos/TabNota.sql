-- Tabla nota
CREATE TABLE nota (
    id_nota SERIAL PRIMARY KEY,
    ticket_id INT NOT NULL REFERENCES ticket(id_ticket),
    usuario_id INT NOT NULL REFERENCES usuario(id_usuario),
    contenido TEXT,
    fecha DATE NOT NULL DEFAULT CURRENT_DATE
);