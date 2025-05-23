SELECT * FROM public.rol
ORDER BY id_rol ASC 

UPDATE public.rol SET id_rol = 1 WHERE id_rol = 16;
UPDATE public.rol SET id_rol = 2 WHERE id_rol = 18;

ALTER SEQUENCE public.rol_id_rol_seq RESTART WITH 3;
