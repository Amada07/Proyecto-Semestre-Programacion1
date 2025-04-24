-- Crear un nuevo usuario
INSERT INTO usuario (nombre, correo, contraseña, rol_id, departamento_id) 
VALUES ('Nombre Completo', 'correo@ejemplo.com', 'contraseña123', 1, 2);

-- Leer usuarios
SELECT * FROM usuario;

-- Actualizar un usuario
UPDATE usuario 
SET nombre = 'Nuevo Nombre', correo = 'nuevo_correo@ejemplo.com', contraseña = 'nuevaContraseña123', rol_id = 2, departamento_id = 3 
WHERE id_usuario = 1;

-- Eliminar un usuario
DELETE FROM usuario 
WHERE id_usuario = 1;