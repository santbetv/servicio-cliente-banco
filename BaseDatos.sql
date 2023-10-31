--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.18
-- Dumped by pg_dump version 12.16 (Ubuntu 12.16-0ubuntu0.20.04.1)

-- Started on 2023-10-20 04:11:12 -05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- TOC entry 182 (class 1259 OID 51918)
-- Name: clientes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.clientes (
    estado boolean,
    id_cliente bigint NOT NULL,
    contrasena character varying(255),
    direccion character varying(255),
    edad character varying(255),
    genero character varying(255),
    identificacion character varying(255),
    nombre character varying(255),
    telefono character varying(255)
);


ALTER TABLE public.clientes OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 51916)
-- Name: clientes_id_cliente_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.clientes_id_cliente_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clientes_id_cliente_seq OWNER TO postgres;

--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 181
-- Name: clientes_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.clientes_id_cliente_seq OWNED BY public.clientes.id_cliente;


--
-- TOC entry 184 (class 1259 OID 51932)
-- Name: cuentas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cuentas (
    estado boolean,
    saldo_inicial numeric(38,2),
    id_cliente bigint,
    id_cuenta bigint NOT NULL,
    numero_nuenta character varying(255),
    tipo_cuenta character varying(255)
);


ALTER TABLE public.cuentas OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 51930)
-- Name: cuentas_id_cuenta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cuentas_id_cuenta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cuentas_id_cuenta_seq OWNER TO postgres;

--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 183
-- Name: cuentas_id_cuenta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cuentas_id_cuenta_seq OWNED BY public.cuentas.id_cuenta;


--
-- TOC entry 186 (class 1259 OID 51943)
-- Name: movimientos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movimientos (
    fecha date,
    saldo numeric(38,2),
    valor numeric(38,2),
    id_cliente bigint,
    id_cuenta bigint,
    id_movimiento bigint NOT NULL,
    tipo_movimiento character varying(255)
);


ALTER TABLE public.movimientos OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 51941)
-- Name: movimientos_id_movimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.movimientos_id_movimiento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.movimientos_id_movimiento_seq OWNER TO postgres;

--
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 185
-- Name: movimientos_id_movimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.movimientos_id_movimiento_seq OWNED BY public.movimientos.id_movimiento;


--
-- TOC entry 2073 (class 2604 OID 51921)
-- Name: clientes id_cliente; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes ALTER COLUMN id_cliente SET DEFAULT nextval('public.clientes_id_cliente_seq'::regclass);


--
-- TOC entry 2074 (class 2604 OID 51935)
-- Name: cuentas id_cuenta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuentas ALTER COLUMN id_cuenta SET DEFAULT nextval('public.cuentas_id_cuenta_seq'::regclass);


--
-- TOC entry 2075 (class 2604 OID 51946)
-- Name: movimientos id_movimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimientos ALTER COLUMN id_movimiento SET DEFAULT nextval('public.movimientos_id_movimiento_seq'::regclass);


--
-- TOC entry 2200 (class 0 OID 51918)
-- Dependencies: 182
-- Data for Name: clientes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.clientes (estado, id_cliente, contrasena, direccion, edad, genero, identificacion, nombre, telefono) FROM stdin;
t	2	5678	Amazonas y NNUU	29	F	5678	Marianela Montalvo	097548965
t	3	1245	13 junio y Equinoccial	29	M	1245	Juan Osorio	098874587
t	1	1234	Otavalo sn y principal	29	M	1234	Jose Lema	098254785
\.


--
-- TOC entry 2202 (class 0 OID 51932)
-- Dependencies: 184
-- Data for Name: cuentas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cuentas (estado, saldo_inicial, id_cliente, id_cuenta, numero_nuenta, tipo_cuenta) FROM stdin;
t	100.00	2	2	225487	Corriente
t	0.00	3	3	495878	Ahorro
t	540.00	2	4	496825	Ahorro
t	1000.00	1	5	585545	Corriente
f	540.00	1	1	010101	Ahorros
\.


--
-- TOC entry 2204 (class 0 OID 51943)
-- Dependencies: 186
-- Data for Name: movimientos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movimientos (fecha, saldo, valor, id_cliente, id_cuenta, id_movimiento, tipo_movimiento) FROM stdin;
2023-10-20	700.00	600.00	2	2	2	DEPOSITO
2023-10-20	150.00	150.00	3	3	3	DEPOSITO
2023-10-20	0.00	540.00	2	4	4	RETIRO
2023-10-20	1690.00	575.00	1	1	1	RETIRO
\.


--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 181
-- Name: clientes_id_cliente_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.clientes_id_cliente_seq', 4, true);


--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 183
-- Name: cuentas_id_cuenta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cuentas_id_cuenta_seq', 6, true);


--
-- TOC entry 2216 (class 0 OID 0)
-- Dependencies: 185
-- Name: movimientos_id_movimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.movimientos_id_movimiento_seq', 4, true);


--
-- TOC entry 2077 (class 2606 OID 51928)
-- Name: clientes clientes_identificacion_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_identificacion_key UNIQUE (identificacion);


--
-- TOC entry 2079 (class 2606 OID 51926)
-- Name: clientes clientes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id_cliente);


--
-- TOC entry 2081 (class 2606 OID 51940)
-- Name: cuentas cuentas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuentas
    ADD CONSTRAINT cuentas_pkey PRIMARY KEY (id_cuenta);


--
-- TOC entry 2083 (class 2606 OID 51948)
-- Name: movimientos movimientos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT movimientos_pkey PRIMARY KEY (id_movimiento);


--
-- TOC entry 2084 (class 2606 OID 51949)
-- Name: movimientos fklebenvy2r7bf11m3tfi8uc9gu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT fklebenvy2r7bf11m3tfi8uc9gu FOREIGN KEY (id_cuenta) REFERENCES public.cuentas(id_cuenta);


--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2023-10-20 04:11:13 -05

--
-- PostgreSQL database dump complete
--

