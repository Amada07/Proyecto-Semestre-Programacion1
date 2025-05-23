SELECT * FROM public.permiso
ORDER BY id_permiso ASC 

UPDATE public.permiso SET id_permiso = 1 WHERE id_permiso = 16;
UPDATE public.permiso SET id_permiso = 2 WHERE id_permiso = 18;

ALTER SEQUENCE public.permiso_id_permiso_seq RESTART WITH 3;
