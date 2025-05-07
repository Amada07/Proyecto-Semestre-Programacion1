-- Crear un nuevo ticket
INSERT INTO ticket (titulo, descripcion, estado_id, departamento_asignado_id, usuario_creador_id, usuario_asignado_id, nivel_prioridad, fecha_creacion, resumen_del_problema) 
VALUES ('Problema del sistema', 'Descripción del problema', 1, 2, 1, 3, 'Alta', NOW(), 'No se puede acceder al sistema');

-- Leer tickets
SELECT * FROM ticket;

-- Actualizar un ticket
UPDATE ticket 
SET titulo = 'Nuevo Título', descripcion = 'Nueva descripción', estado_id = 2, usuario_asignado_id = 4, nivel_prioridad = 'Media' 
WHERE id_ticket = 1;

-- Eliminar un ticket
DELETE FROM ticket 
WHERE id_ticket = 1;