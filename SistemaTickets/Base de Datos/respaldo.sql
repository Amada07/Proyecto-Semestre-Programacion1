--
-- PostgreSQL database cluster dump
--

-- Started on 2025-05-22 18:49:34

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE cloud_admin;
ALTER ROLE cloud_admin WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS;
CREATE ROLE neon_superuser;
ALTER ROLE neon_superuser WITH NOSUPERUSER INHERIT CREATEROLE CREATEDB NOLOGIN REPLICATION BYPASSRLS;
CREATE ROLE neondb_owner;
ALTER ROLE neondb_owner WITH NOSUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:8lRtC49mrYFvL7yIqgGiIA==$ouWnkjdr7iljLLi4LHBSqBc/mCNG0j93okXQ4IFOLdI=:wE8kSE/WtiFLRgKbcS72TzkDXNtLusw/tTQjCblI4sU=';

--
-- User Configurations
--


--
-- Role memberships
--

GRANT neon_superuser TO neondb_owner WITH INHERIT TRUE GRANTED BY cloud_admin;
GRANT pg_create_subscription TO neon_superuser WITH INHERIT TRUE GRANTED BY cloud_admin;
GRANT pg_monitor TO neon_superuser WITH ADMIN OPTION, INHERIT TRUE GRANTED BY cloud_admin;
GRANT pg_read_all_data TO neon_superuser WITH INHERIT TRUE GRANTED BY cloud_admin;
GRANT pg_write_all_data TO neon_superuser WITH INHERIT TRUE GRANTED BY cloud_admin;






--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-05-22 18:49:34

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

-- Completed on 2025-05-22 18:49:39

--
-- PostgreSQL database dump complete
--

--
-- Database "chinook" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-05-22 18:49:39

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3455 (class 1262 OID 24585)
-- Name: chinook; Type: DATABASE; Schema: -; Owner: neondb_owner
--

CREATE DATABASE chinook WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = builtin LOCALE = 'C.UTF-8' BUILTIN_LOCALE = 'C.UTF-8';


ALTER DATABASE chinook OWNER TO neondb_owner;

\connect chinook

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 32769)
-- Name: configuracion_sistema; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.configuracion_sistema (
    id_configuracion integer NOT NULL,
    nombre_empresa character varying(255),
    logo text,
    idioma_predeterminado character varying(50),
    zona_horaria character varying(50),
    tiempo_vencimiento_inactivos integer,
    nivel_prioridad_default character varying(50)
);


ALTER TABLE public.configuracion_sistema OWNER TO neondb_owner;

--
-- TOC entry 217 (class 1259 OID 32768)
-- Name: configuracion_sistema_id_configuracion_seq; Type: SEQUENCE; Schema: public; Owner: neondb_owner
--

CREATE SEQUENCE public.configuracion_sistema_id_configuracion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.configuracion_sistema_id_configuracion_seq OWNER TO neondb_owner;

--
-- TOC entry 3457 (class 0 OID 0)
-- Dependencies: 217
-- Name: configuracion_sistema_id_configuracion_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: neondb_owner
--

ALTER SEQUENCE public.configuracion_sistema_id_configuracion_seq OWNED BY public.configuracion_sistema.id_configuracion;


--
-- TOC entry 220 (class 1259 OID 40961)
-- Name: departamento; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.departamento (
    id_departamento integer NOT NULL,
    nombre character varying(100) NOT NULL,
    descripcion text
);


ALTER TABLE public.departamento OWNER TO neondb_owner;

--
-- TOC entry 219 (class 1259 OID 40960)
-- Name: departamento_id_departamento_seq; Type: SEQUENCE; Schema: public; Owner: neondb_owner
--

CREATE SEQUENCE public.departamento_id_departamento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.departamento_id_departamento_seq OWNER TO neondb_owner;

--
-- TOC entry 3458 (class 0 OID 0)
-- Dependencies: 219
-- Name: departamento_id_departamento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: neondb_owner
--

ALTER SEQUENCE public.departamento_id_departamento_seq OWNED BY public.departamento.id_departamento;


--
-- TOC entry 222 (class 1259 OID 49153)
-- Name: estado_ticket; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.estado_ticket (
    id_estado integer NOT NULL,
    nombre character varying(100) NOT NULL,
    descripcion text,
    estado_final boolean NOT NULL,
    estados_permitidos_siguientes text
);


ALTER TABLE public.estado_ticket OWNER TO neondb_owner;

--
-- TOC entry 221 (class 1259 OID 49152)
-- Name: estado_ticket_id_estado_seq; Type: SEQUENCE; Schema: public; Owner: neondb_owner
--

CREATE SEQUENCE public.estado_ticket_id_estado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.estado_ticket_id_estado_seq OWNER TO neondb_owner;

--
-- TOC entry 3459 (class 0 OID 0)
-- Dependencies: 221
-- Name: estado_ticket_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: neondb_owner
--

ALTER SEQUENCE public.estado_ticket_id_estado_seq OWNED BY public.estado_ticket.id_estado;


--
-- TOC entry 234 (class 1259 OID 57345)
-- Name: historial; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.historial (
    id integer NOT NULL,
    idticket integer NOT NULL,
    cambio text NOT NULL
);


ALTER TABLE public.historial OWNER TO neondb_owner;

--
-- TOC entry 236 (class 1259 OID 65537)
-- Name: historial_cambios; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.historial_cambios (
    id integer NOT NULL,
    accion character varying(255),
    usuario character varying(50),
    fecha timestamp without time zone DEFAULT CURRENT_TIMESTAMP
);


ALTER TABLE public.historial_cambios OWNER TO neondb_owner;

--
-- TOC entry 235 (class 1259 OID 65536)
-- Name: historial_cambios_id_seq; Type: SEQUENCE; Schema: public; Owner: neondb_owner
--

CREATE SEQUENCE public.historial_cambios_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.historial_cambios_id_seq OWNER TO neondb_owner;

--
-- TOC entry 3460 (class 0 OID 0)
-- Dependencies: 235
-- Name: historial_cambios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: neondb_owner
--

ALTER SEQUENCE public.historial_cambios_id_seq OWNED BY public.historial_cambios.id;


--
-- TOC entry 233 (class 1259 OID 57344)
-- Name: historial_id_seq; Type: SEQUENCE; Schema: public; Owner: neondb_owner
--

CREATE SEQUENCE public.historial_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.historial_id_seq OWNER TO neondb_owner;

--
-- TOC entry 3461 (class 0 OID 0)
-- Dependencies: 233
-- Name: historial_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: neondb_owner
--

ALTER SEQUENCE public.historial_id_seq OWNED BY public.historial.id;


--
-- TOC entry 232 (class 1259 OID 49251)
-- Name: nota; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.nota (
    id_nota integer NOT NULL,
    ticket_id integer NOT NULL,
    usuario_id integer NOT NULL,
    contenido text,
    fecha date DEFAULT CURRENT_DATE NOT NULL
);


ALTER TABLE public.nota OWNER TO neondb_owner;

--
-- TOC entry 231 (class 1259 OID 49250)
-- Name: nota_id_nota_seq; Type: SEQUENCE; Schema: public; Owner: neondb_owner
--

CREATE SEQUENCE public.nota_id_nota_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.nota_id_nota_seq OWNER TO neondb_owner;

--
-- TOC entry 3462 (class 0 OID 0)
-- Dependencies: 231
-- Name: nota_id_nota_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: neondb_owner
--

ALTER SEQUENCE public.nota_id_nota_seq OWNED BY public.nota.id_nota;


--
-- TOC entry 224 (class 1259 OID 49172)
-- Name: permiso; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.permiso (
    id_permiso integer NOT NULL,
    nombre character varying(100) NOT NULL,
    descripcion text
);


ALTER TABLE public.permiso OWNER TO neondb_owner;

--
-- TOC entry 223 (class 1259 OID 49171)
-- Name: permiso_id_permiso_seq; Type: SEQUENCE; Schema: public; Owner: neondb_owner
--

CREATE SEQUENCE public.permiso_id_permiso_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.permiso_id_permiso_seq OWNER TO neondb_owner;

--
-- TOC entry 3463 (class 0 OID 0)
-- Dependencies: 223
-- Name: permiso_id_permiso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: neondb_owner
--

ALTER SEQUENCE public.permiso_id_permiso_seq OWNED BY public.permiso.id_permiso;


--
-- TOC entry 226 (class 1259 OID 49181)
-- Name: rol; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.rol (
    id_rol integer NOT NULL,
    nombre character varying(100) NOT NULL,
    descripcion text
);


ALTER TABLE public.rol OWNER TO neondb_owner;

--
-- TOC entry 225 (class 1259 OID 49180)
-- Name: rol_id_rol_seq; Type: SEQUENCE; Schema: public; Owner: neondb_owner
--

CREATE SEQUENCE public.rol_id_rol_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.rol_id_rol_seq OWNER TO neondb_owner;

--
-- TOC entry 3464 (class 0 OID 0)
-- Dependencies: 225
-- Name: rol_id_rol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: neondb_owner
--

ALTER SEQUENCE public.rol_id_rol_seq OWNED BY public.rol.id_rol;


--
-- TOC entry 238 (class 1259 OID 73729)
-- Name: rol_permiso; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.rol_permiso (
    id integer NOT NULL,
    id_rol integer NOT NULL,
    id_permiso integer NOT NULL
);


ALTER TABLE public.rol_permiso OWNER TO neondb_owner;

--
-- TOC entry 237 (class 1259 OID 73728)
-- Name: rol_permiso_id_seq; Type: SEQUENCE; Schema: public; Owner: neondb_owner
--

CREATE SEQUENCE public.rol_permiso_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.rol_permiso_id_seq OWNER TO neondb_owner;

--
-- TOC entry 3465 (class 0 OID 0)
-- Dependencies: 237
-- Name: rol_permiso_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: neondb_owner
--

ALTER SEQUENCE public.rol_permiso_id_seq OWNED BY public.rol_permiso.id;


--
-- TOC entry 230 (class 1259 OID 49221)
-- Name: ticket; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.ticket (
    id_ticket integer NOT NULL,
    titulo character varying(255) NOT NULL,
    descripcion text,
    estado_id integer NOT NULL,
    departamento_asignado_id integer NOT NULL,
    usuario_creador_id integer NOT NULL,
    usuario_asignado_id integer,
    nivel_prioridad character varying(50),
    fecha_creacion date DEFAULT CURRENT_DATE NOT NULL,
    adjuntos text,
    resumen_del_problema text
);


ALTER TABLE public.ticket OWNER TO neondb_owner;

--
-- TOC entry 229 (class 1259 OID 49220)
-- Name: ticket_id_ticket_seq; Type: SEQUENCE; Schema: public; Owner: neondb_owner
--

CREATE SEQUENCE public.ticket_id_ticket_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.ticket_id_ticket_seq OWNER TO neondb_owner;

--
-- TOC entry 3466 (class 0 OID 0)
-- Dependencies: 229
-- Name: ticket_id_ticket_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: neondb_owner
--

ALTER SEQUENCE public.ticket_id_ticket_seq OWNED BY public.ticket.id_ticket;


--
-- TOC entry 228 (class 1259 OID 49210)
-- Name: usuario; Type: TABLE; Schema: public; Owner: neondb_owner
--

CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    nombre character varying(255) NOT NULL,
    correo character varying(255) NOT NULL,
    "contraseña" character varying(255) NOT NULL,
    rol_id integer NOT NULL,
    departamento_id integer NOT NULL
);


ALTER TABLE public.usuario OWNER TO neondb_owner;

--
-- TOC entry 227 (class 1259 OID 49209)
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: neondb_owner
--

CREATE SEQUENCE public.usuario_id_usuario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.usuario_id_usuario_seq OWNER TO neondb_owner;

--
-- TOC entry 3467 (class 0 OID 0)
-- Dependencies: 227
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: neondb_owner
--

ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;


--
-- TOC entry 3237 (class 2604 OID 32772)
-- Name: configuracion_sistema id_configuracion; Type: DEFAULT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.configuracion_sistema ALTER COLUMN id_configuracion SET DEFAULT nextval('public.configuracion_sistema_id_configuracion_seq'::regclass);


--
-- TOC entry 3238 (class 2604 OID 40964)
-- Name: departamento id_departamento; Type: DEFAULT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.departamento ALTER COLUMN id_departamento SET DEFAULT nextval('public.departamento_id_departamento_seq'::regclass);


--
-- TOC entry 3239 (class 2604 OID 49156)
-- Name: estado_ticket id_estado; Type: DEFAULT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.estado_ticket ALTER COLUMN id_estado SET DEFAULT nextval('public.estado_ticket_id_estado_seq'::regclass);


--
-- TOC entry 3247 (class 2604 OID 57348)
-- Name: historial id; Type: DEFAULT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.historial ALTER COLUMN id SET DEFAULT nextval('public.historial_id_seq'::regclass);


--
-- TOC entry 3248 (class 2604 OID 65540)
-- Name: historial_cambios id; Type: DEFAULT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.historial_cambios ALTER COLUMN id SET DEFAULT nextval('public.historial_cambios_id_seq'::regclass);


--
-- TOC entry 3245 (class 2604 OID 49254)
-- Name: nota id_nota; Type: DEFAULT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.nota ALTER COLUMN id_nota SET DEFAULT nextval('public.nota_id_nota_seq'::regclass);


--
-- TOC entry 3240 (class 2604 OID 49175)
-- Name: permiso id_permiso; Type: DEFAULT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.permiso ALTER COLUMN id_permiso SET DEFAULT nextval('public.permiso_id_permiso_seq'::regclass);


--
-- TOC entry 3241 (class 2604 OID 49184)
-- Name: rol id_rol; Type: DEFAULT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.rol ALTER COLUMN id_rol SET DEFAULT nextval('public.rol_id_rol_seq'::regclass);


--
-- TOC entry 3250 (class 2604 OID 73732)
-- Name: rol_permiso id; Type: DEFAULT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.rol_permiso ALTER COLUMN id SET DEFAULT nextval('public.rol_permiso_id_seq'::regclass);


--
-- TOC entry 3243 (class 2604 OID 49224)
-- Name: ticket id_ticket; Type: DEFAULT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.ticket ALTER COLUMN id_ticket SET DEFAULT nextval('public.ticket_id_ticket_seq'::regclass);


--
-- TOC entry 3242 (class 2604 OID 49213)
-- Name: usuario id_usuario; Type: DEFAULT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);


--
-- TOC entry 3429 (class 0 OID 32769)
-- Dependencies: 218
-- Data for Name: configuracion_sistema; Type: TABLE DATA; Schema: public; Owner: neondb_owner
--

COPY public.configuracion_sistema (id_configuracion, nombre_empresa, logo, idioma_predeterminado, zona_horaria, tiempo_vencimiento_inactivos, nivel_prioridad_default) FROM stdin;
4	gestion ticket	\N	Francés	UTC-5	30	Media
5	Ticket 2	\N	Inglés	UTC+1	31	Alta
6	Ticket 2	\N	Inglés	UTC+1	31	Alta
7	Ticket 2	\N	Español	UTC-5	27	Media
2	Ticket 2	\N	Español	UTC-5	27	Media
8	                     TicketPro 1	\N	Español	UTC-6	29	Alta
9	                     TicketPro 1	\N	Español	UTC-6	28	Alta
10	Ticket 	\N	Español	UTC-6	30	Alta
11	 ticket 	\N	Español	UTC-5	22	Media
1	                     TicketPro 1	\N	Español	UTC-6	29	Alta
12	ticket prueba	\N	Español	UTC-5	28	Alta
3	gestion ticket 3	\N	Español	UTC-5	30	Media
\.


--
-- TOC entry 3431 (class 0 OID 40961)
-- Dependencies: 220
-- Data for Name: departamento; Type: TABLE DATA; Schema: public; Owner: neondb_owner
--

COPY public.departamento (id_departamento, nombre, descripcion) FROM stdin;
\.


--
-- TOC entry 3433 (class 0 OID 49153)
-- Dependencies: 222
-- Data for Name: estado_ticket; Type: TABLE DATA; Schema: public; Owner: neondb_owner
--

COPY public.estado_ticket (id_estado, nombre, descripcion, estado_final, estados_permitidos_siguientes) FROM stdin;
\.


--
-- TOC entry 3445 (class 0 OID 57345)
-- Dependencies: 234
-- Data for Name: historial; Type: TABLE DATA; Schema: public; Owner: neondb_owner
--

COPY public.historial (id, idticket, cambio) FROM stdin;
\.


--
-- TOC entry 3447 (class 0 OID 65537)
-- Dependencies: 236
-- Data for Name: historial_cambios; Type: TABLE DATA; Schema: public; Owner: neondb_owner
--

COPY public.historial_cambios (id, accion, usuario, fecha) FROM stdin;
1	Asignación de permiso	Admin	2025-05-22 01:58:25.184977
2	Asignación de permiso	Admin	2025-05-22 02:02:19.2829
3	Asignación de permiso	Admin	2025-05-22 02:03:09.919556
4	Asignación de permiso	Admin	2025-05-22 04:57:10.470531
5	Asignación de permiso	Admin	2025-05-22 04:57:35.231
6	Asignación de permiso	Admin	2025-05-22 04:57:37.021494
7	Asignación de permiso	Admin	2025-05-22 04:57:37.42467
8	Asignación de permiso	Admin	2025-05-22 04:57:37.840442
9	Asignación de permiso	Admin	2025-05-22 05:18:13.641875
10	Asignación de permiso	Admin	2025-05-22 07:43:48.339391
\.


--
-- TOC entry 3443 (class 0 OID 49251)
-- Dependencies: 232
-- Data for Name: nota; Type: TABLE DATA; Schema: public; Owner: neondb_owner
--

COPY public.nota (id_nota, ticket_id, usuario_id, contenido, fecha) FROM stdin;
\.


--
-- TOC entry 3435 (class 0 OID 49172)
-- Dependencies: 224
-- Data for Name: permiso; Type: TABLE DATA; Schema: public; Owner: neondb_owner
--

COPY public.permiso (id_permiso, nombre, descripcion) FROM stdin;
1	Crear Tickets	Puede crear tickets 
\.


--
-- TOC entry 3437 (class 0 OID 49181)
-- Dependencies: 226
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: neondb_owner
--

COPY public.rol (id_rol, nombre, descripcion) FROM stdin;
1	Administrador 	Tiene acceso total
2	Tecnico	Puede gestionar, asignar y resolver tickets
3	Usuario	Puede crear y consultar Tickets
\.


--
-- TOC entry 3449 (class 0 OID 73729)
-- Dependencies: 238
-- Data for Name: rol_permiso; Type: TABLE DATA; Schema: public; Owner: neondb_owner
--

COPY public.rol_permiso (id, id_rol, id_permiso) FROM stdin;
10	1	1
\.


--
-- TOC entry 3441 (class 0 OID 49221)
-- Dependencies: 230
-- Data for Name: ticket; Type: TABLE DATA; Schema: public; Owner: neondb_owner
--

COPY public.ticket (id_ticket, titulo, descripcion, estado_id, departamento_asignado_id, usuario_creador_id, usuario_asignado_id, nivel_prioridad, fecha_creacion, adjuntos, resumen_del_problema) FROM stdin;
\.


--
-- TOC entry 3439 (class 0 OID 49210)
-- Dependencies: 228
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: neondb_owner
--

COPY public.usuario (id_usuario, nombre, correo, "contraseña", rol_id, departamento_id) FROM stdin;
1	Nombre Completo	correo@ejemplo.com	contraseña123	1	2
\.


--
-- TOC entry 3468 (class 0 OID 0)
-- Dependencies: 217
-- Name: configuracion_sistema_id_configuracion_seq; Type: SEQUENCE SET; Schema: public; Owner: neondb_owner
--

SELECT pg_catalog.setval('public.configuracion_sistema_id_configuracion_seq', 12, true);


--
-- TOC entry 3469 (class 0 OID 0)
-- Dependencies: 219
-- Name: departamento_id_departamento_seq; Type: SEQUENCE SET; Schema: public; Owner: neondb_owner
--

SELECT pg_catalog.setval('public.departamento_id_departamento_seq', 1, false);


--
-- TOC entry 3470 (class 0 OID 0)
-- Dependencies: 221
-- Name: estado_ticket_id_estado_seq; Type: SEQUENCE SET; Schema: public; Owner: neondb_owner
--

SELECT pg_catalog.setval('public.estado_ticket_id_estado_seq', 1, false);


--
-- TOC entry 3471 (class 0 OID 0)
-- Dependencies: 235
-- Name: historial_cambios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: neondb_owner
--

SELECT pg_catalog.setval('public.historial_cambios_id_seq', 10, true);


--
-- TOC entry 3472 (class 0 OID 0)
-- Dependencies: 233
-- Name: historial_id_seq; Type: SEQUENCE SET; Schema: public; Owner: neondb_owner
--

SELECT pg_catalog.setval('public.historial_id_seq', 1, false);


--
-- TOC entry 3473 (class 0 OID 0)
-- Dependencies: 231
-- Name: nota_id_nota_seq; Type: SEQUENCE SET; Schema: public; Owner: neondb_owner
--

SELECT pg_catalog.setval('public.nota_id_nota_seq', 1, false);


--
-- TOC entry 3474 (class 0 OID 0)
-- Dependencies: 223
-- Name: permiso_id_permiso_seq; Type: SEQUENCE SET; Schema: public; Owner: neondb_owner
--

SELECT pg_catalog.setval('public.permiso_id_permiso_seq', 3, false);


--
-- TOC entry 3475 (class 0 OID 0)
-- Dependencies: 225
-- Name: rol_id_rol_seq; Type: SEQUENCE SET; Schema: public; Owner: neondb_owner
--

SELECT pg_catalog.setval('public.rol_id_rol_seq', 3, true);


--
-- TOC entry 3476 (class 0 OID 0)
-- Dependencies: 237
-- Name: rol_permiso_id_seq; Type: SEQUENCE SET; Schema: public; Owner: neondb_owner
--

SELECT pg_catalog.setval('public.rol_permiso_id_seq', 10, true);


--
-- TOC entry 3477 (class 0 OID 0)
-- Dependencies: 229
-- Name: ticket_id_ticket_seq; Type: SEQUENCE SET; Schema: public; Owner: neondb_owner
--

SELECT pg_catalog.setval('public.ticket_id_ticket_seq', 2, true);


--
-- TOC entry 3478 (class 0 OID 0)
-- Dependencies: 227
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: neondb_owner
--

SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 1, true);


--
-- TOC entry 3252 (class 2606 OID 32776)
-- Name: configuracion_sistema configuracion_sistema_pkey; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.configuracion_sistema
    ADD CONSTRAINT configuracion_sistema_pkey PRIMARY KEY (id_configuracion);


--
-- TOC entry 3254 (class 2606 OID 40968)
-- Name: departamento departamento_pkey; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (id_departamento);


--
-- TOC entry 3256 (class 2606 OID 49160)
-- Name: estado_ticket estado_ticket_pkey; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.estado_ticket
    ADD CONSTRAINT estado_ticket_pkey PRIMARY KEY (id_estado);


--
-- TOC entry 3272 (class 2606 OID 65543)
-- Name: historial_cambios historial_cambios_pkey; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.historial_cambios
    ADD CONSTRAINT historial_cambios_pkey PRIMARY KEY (id);


--
-- TOC entry 3270 (class 2606 OID 57352)
-- Name: historial historial_pkey; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.historial
    ADD CONSTRAINT historial_pkey PRIMARY KEY (id);


--
-- TOC entry 3268 (class 2606 OID 49259)
-- Name: nota nota_pkey; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.nota
    ADD CONSTRAINT nota_pkey PRIMARY KEY (id_nota);


--
-- TOC entry 3258 (class 2606 OID 49179)
-- Name: permiso permiso_pkey; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.permiso
    ADD CONSTRAINT permiso_pkey PRIMARY KEY (id_permiso);


--
-- TOC entry 3274 (class 2606 OID 73734)
-- Name: rol_permiso rol_permiso_pkey; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.rol_permiso
    ADD CONSTRAINT rol_permiso_pkey PRIMARY KEY (id);


--
-- TOC entry 3260 (class 2606 OID 49188)
-- Name: rol rol_pkey; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id_rol);


--
-- TOC entry 3266 (class 2606 OID 49229)
-- Name: ticket ticket_pkey; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_pkey PRIMARY KEY (id_ticket);


--
-- TOC entry 3262 (class 2606 OID 49219)
-- Name: usuario usuario_correo_key; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_correo_key UNIQUE (correo);


--
-- TOC entry 3264 (class 2606 OID 49217)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 3279 (class 2606 OID 49260)
-- Name: nota nota_ticket_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.nota
    ADD CONSTRAINT nota_ticket_id_fkey FOREIGN KEY (ticket_id) REFERENCES public.ticket(id_ticket);


--
-- TOC entry 3280 (class 2606 OID 49265)
-- Name: nota nota_usuario_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.nota
    ADD CONSTRAINT nota_usuario_id_fkey FOREIGN KEY (usuario_id) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 3281 (class 2606 OID 73740)
-- Name: rol_permiso rol_permiso_id_permiso_fkey; Type: FK CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.rol_permiso
    ADD CONSTRAINT rol_permiso_id_permiso_fkey FOREIGN KEY (id_permiso) REFERENCES public.permiso(id_permiso);


--
-- TOC entry 3282 (class 2606 OID 73735)
-- Name: rol_permiso rol_permiso_id_rol_fkey; Type: FK CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.rol_permiso
    ADD CONSTRAINT rol_permiso_id_rol_fkey FOREIGN KEY (id_rol) REFERENCES public.rol(id_rol);


--
-- TOC entry 3275 (class 2606 OID 49235)
-- Name: ticket ticket_departamento_asignado_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_departamento_asignado_id_fkey FOREIGN KEY (departamento_asignado_id) REFERENCES public.departamento(id_departamento);


--
-- TOC entry 3276 (class 2606 OID 49230)
-- Name: ticket ticket_estado_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_estado_id_fkey FOREIGN KEY (estado_id) REFERENCES public.estado_ticket(id_estado);


--
-- TOC entry 3277 (class 2606 OID 49245)
-- Name: ticket ticket_usuario_asignado_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_usuario_asignado_id_fkey FOREIGN KEY (usuario_asignado_id) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 3278 (class 2606 OID 49240)
-- Name: ticket ticket_usuario_creador_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: neondb_owner
--

ALTER TABLE ONLY public.ticket
    ADD CONSTRAINT ticket_usuario_creador_id_fkey FOREIGN KEY (usuario_creador_id) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 3456 (class 0 OID 0)
-- Dependencies: 3455
-- Name: DATABASE chinook; Type: ACL; Schema: -; Owner: neondb_owner
--

GRANT ALL ON DATABASE chinook TO neon_superuser;


--
-- TOC entry 2095 (class 826 OID 24587)
-- Name: DEFAULT PRIVILEGES FOR SEQUENCES; Type: DEFAULT ACL; Schema: public; Owner: cloud_admin
--

ALTER DEFAULT PRIVILEGES FOR ROLE cloud_admin IN SCHEMA public GRANT ALL ON SEQUENCES TO neon_superuser WITH GRANT OPTION;


--
-- TOC entry 2094 (class 826 OID 24586)
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: public; Owner: cloud_admin
--

ALTER DEFAULT PRIVILEGES FOR ROLE cloud_admin IN SCHEMA public GRANT ALL ON TABLES TO neon_superuser WITH GRANT OPTION;


-- Completed on 2025-05-22 18:49:47

--
-- PostgreSQL database dump complete
--

--
-- Database "neondb" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-05-22 18:49:47

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3332 (class 1262 OID 16389)
-- Name: neondb; Type: DATABASE; Schema: -; Owner: neondb_owner
--

CREATE DATABASE neondb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = builtin LOCALE = 'C.UTF-8' BUILTIN_LOCALE = 'C.UTF-8';


ALTER DATABASE neondb OWNER TO neondb_owner;

\connect neondb

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3333 (class 0 OID 0)
-- Dependencies: 3332
-- Name: DATABASE neondb; Type: ACL; Schema: -; Owner: neondb_owner
--

GRANT ALL ON DATABASE neondb TO neon_superuser;


--
-- TOC entry 2040 (class 826 OID 16392)
-- Name: DEFAULT PRIVILEGES FOR SEQUENCES; Type: DEFAULT ACL; Schema: public; Owner: cloud_admin
--

ALTER DEFAULT PRIVILEGES FOR ROLE cloud_admin IN SCHEMA public GRANT ALL ON SEQUENCES TO neon_superuser WITH GRANT OPTION;


--
-- TOC entry 2039 (class 826 OID 16391)
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: public; Owner: cloud_admin
--

ALTER DEFAULT PRIVILEGES FOR ROLE cloud_admin IN SCHEMA public GRANT ALL ON TABLES TO neon_superuser WITH GRANT OPTION;


-- Completed on 2025-05-22 18:49:52

--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-05-22 18:49:53

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 16390)
-- Name: neon; Type: SCHEMA; Schema: -; Owner: cloud_admin
--

CREATE SCHEMA neon;


ALTER SCHEMA neon OWNER TO cloud_admin;

--
-- TOC entry 9 (class 2615 OID 16469)
-- Name: neon_migration; Type: SCHEMA; Schema: -; Owner: cloud_admin
--

CREATE SCHEMA neon_migration;


ALTER SCHEMA neon_migration OWNER TO cloud_admin;

--
-- TOC entry 3 (class 3079 OID 16430)
-- Name: neon; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS neon WITH SCHEMA neon;


--
-- TOC entry 3406 (class 0 OID 0)
-- Dependencies: 3
-- Name: EXTENSION neon; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION neon IS 'cloud storage for PostgreSQL';


--
-- TOC entry 2 (class 3079 OID 16393)
-- Name: pg_stat_statements; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS pg_stat_statements WITH SCHEMA public;


--
-- TOC entry 3407 (class 0 OID 0)
-- Dependencies: 2
-- Name: EXTENSION pg_stat_statements; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION pg_stat_statements IS 'track planning and execution statistics of all SQL statements executed';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 232 (class 1259 OID 24577)
-- Name: drop_subscriptions_done; Type: TABLE; Schema: neon; Owner: cloud_admin
--

CREATE TABLE neon.drop_subscriptions_done (
    id integer NOT NULL,
    timeline_id text
);


ALTER TABLE neon.drop_subscriptions_done OWNER TO cloud_admin;

--
-- TOC entry 231 (class 1259 OID 24576)
-- Name: drop_subscriptions_done_id_seq; Type: SEQUENCE; Schema: neon; Owner: cloud_admin
--

CREATE SEQUENCE neon.drop_subscriptions_done_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE neon.drop_subscriptions_done_id_seq OWNER TO cloud_admin;

--
-- TOC entry 3411 (class 0 OID 0)
-- Dependencies: 231
-- Name: drop_subscriptions_done_id_seq; Type: SEQUENCE OWNED BY; Schema: neon; Owner: cloud_admin
--

ALTER SEQUENCE neon.drop_subscriptions_done_id_seq OWNED BY neon.drop_subscriptions_done.id;


--
-- TOC entry 230 (class 1259 OID 16470)
-- Name: migration_id; Type: TABLE; Schema: neon_migration; Owner: cloud_admin
--

CREATE TABLE neon_migration.migration_id (
    key integer NOT NULL,
    id bigint DEFAULT 0 NOT NULL
);


ALTER TABLE neon_migration.migration_id OWNER TO cloud_admin;

--
-- TOC entry 229 (class 1259 OID 16462)
-- Name: health_check; Type: TABLE; Schema: public; Owner: cloud_admin
--

CREATE TABLE public.health_check (
    id integer NOT NULL,
    updated_at timestamp with time zone DEFAULT now()
);


ALTER TABLE public.health_check OWNER TO cloud_admin;

--
-- TOC entry 228 (class 1259 OID 16461)
-- Name: health_check_id_seq; Type: SEQUENCE; Schema: public; Owner: cloud_admin
--

CREATE SEQUENCE public.health_check_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.health_check_id_seq OWNER TO cloud_admin;

--
-- TOC entry 3412 (class 0 OID 0)
-- Dependencies: 228
-- Name: health_check_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: cloud_admin
--

ALTER SEQUENCE public.health_check_id_seq OWNED BY public.health_check.id;


--
-- TOC entry 3237 (class 2604 OID 24580)
-- Name: drop_subscriptions_done id; Type: DEFAULT; Schema: neon; Owner: cloud_admin
--

ALTER TABLE ONLY neon.drop_subscriptions_done ALTER COLUMN id SET DEFAULT nextval('neon.drop_subscriptions_done_id_seq'::regclass);


--
-- TOC entry 3234 (class 2604 OID 16465)
-- Name: health_check id; Type: DEFAULT; Schema: public; Owner: cloud_admin
--

ALTER TABLE ONLY public.health_check ALTER COLUMN id SET DEFAULT nextval('public.health_check_id_seq'::regclass);


--
-- TOC entry 3400 (class 0 OID 24577)
-- Dependencies: 232
-- Data for Name: drop_subscriptions_done; Type: TABLE DATA; Schema: neon; Owner: cloud_admin
--

COPY neon.drop_subscriptions_done (id, timeline_id) FROM stdin;
1	44c811601a5f7a315710c23d42ce1ace
\.


--
-- TOC entry 3398 (class 0 OID 16470)
-- Dependencies: 230
-- Data for Name: migration_id; Type: TABLE DATA; Schema: neon_migration; Owner: cloud_admin
--

COPY neon_migration.migration_id (key, id) FROM stdin;
0	11
\.


--
-- TOC entry 3397 (class 0 OID 16462)
-- Dependencies: 229
-- Data for Name: health_check; Type: TABLE DATA; Schema: public; Owner: cloud_admin
--

COPY public.health_check (id, updated_at) FROM stdin;
1	2025-05-06 23:11:37.781171+00
\.


--
-- TOC entry 3413 (class 0 OID 0)
-- Dependencies: 231
-- Name: drop_subscriptions_done_id_seq; Type: SEQUENCE SET; Schema: neon; Owner: cloud_admin
--

SELECT pg_catalog.setval('neon.drop_subscriptions_done_id_seq', 1, false);


--
-- TOC entry 3414 (class 0 OID 0)
-- Dependencies: 228
-- Name: health_check_id_seq; Type: SEQUENCE SET; Schema: public; Owner: cloud_admin
--

SELECT pg_catalog.setval('public.health_check_id_seq', 1, false);


--
-- TOC entry 3243 (class 2606 OID 24584)
-- Name: drop_subscriptions_done drop_subscriptions_done_pkey; Type: CONSTRAINT; Schema: neon; Owner: cloud_admin
--

ALTER TABLE ONLY neon.drop_subscriptions_done
    ADD CONSTRAINT drop_subscriptions_done_pkey PRIMARY KEY (id);


--
-- TOC entry 3241 (class 2606 OID 16475)
-- Name: migration_id migration_id_pkey; Type: CONSTRAINT; Schema: neon_migration; Owner: cloud_admin
--

ALTER TABLE ONLY neon_migration.migration_id
    ADD CONSTRAINT migration_id_pkey PRIMARY KEY (key);


--
-- TOC entry 3239 (class 2606 OID 16468)
-- Name: health_check health_check_pkey; Type: CONSTRAINT; Schema: public; Owner: cloud_admin
--

ALTER TABLE ONLY public.health_check
    ADD CONSTRAINT health_check_pkey PRIMARY KEY (id);


--
-- TOC entry 3408 (class 0 OID 0)
-- Dependencies: 235
-- Name: FUNCTION pg_export_snapshot(); Type: ACL; Schema: pg_catalog; Owner: cloud_admin
--

GRANT ALL ON FUNCTION pg_catalog.pg_export_snapshot() TO neon_superuser;


--
-- TOC entry 3409 (class 0 OID 0)
-- Dependencies: 234
-- Name: FUNCTION pg_log_standby_snapshot(); Type: ACL; Schema: pg_catalog; Owner: cloud_admin
--

GRANT ALL ON FUNCTION pg_catalog.pg_log_standby_snapshot() TO neon_superuser;


--
-- TOC entry 3410 (class 0 OID 0)
-- Dependencies: 233
-- Name: FUNCTION pg_show_replication_origin_status(OUT local_id oid, OUT external_id text, OUT remote_lsn pg_lsn, OUT local_lsn pg_lsn); Type: ACL; Schema: pg_catalog; Owner: cloud_admin
--

GRANT ALL ON FUNCTION pg_catalog.pg_show_replication_origin_status(OUT local_id oid, OUT external_id text, OUT remote_lsn pg_lsn, OUT local_lsn pg_lsn) TO neon_superuser;


-- Completed on 2025-05-22 18:49:59

--
-- PostgreSQL database dump complete
--

-- Completed on 2025-05-22 18:49:59

--
-- PostgreSQL database cluster dump complete
--

