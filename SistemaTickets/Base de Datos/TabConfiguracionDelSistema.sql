-- Tabla configuracion_sistema
CREATE TABLE configuracion_sistema (
    id_configuracion SERIAL PRIMARY KEY,
    nombre_empresa VARCHAR(255),
    logo TEXT,
    idioma_predeterminado VARCHAR(50),
    zona_horaria VARCHAR(50),
    tiempo_vencimiento_inactivos INT,
    nivel_prioridad_default VARCHAR(50)
);