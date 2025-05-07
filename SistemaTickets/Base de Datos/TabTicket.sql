-- Tabla ticket
CREATE TABLE ticket (
    id_ticket SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descripcion TEXT,
    estado_id INT NOT NULL REFERENCES estado_ticket(id_estado),
    departamento_asignado_id INT NOT NULL REFERENCES departamento(id_departamento),
    usuario_creador_id INT NOT NULL REFERENCES usuario(id_usuario),
    usuario_asignado_id INT REFERENCES usuario(id_usuario),
    nivel_prioridad VARCHAR(50),
    fecha_creacion DATE NOT NULL DEFAULT CURRENT_DATE,
    adjuntos TEXT,
    resumen_del_problema TEXT
);