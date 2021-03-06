PGDMP                         z            catalogo_libri    14.1    14.1 &    *           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            +           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ,           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            -           1262    30931    catalogo_libri    DATABASE     j   CREATE DATABASE catalogo_libri WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE catalogo_libri;
                postgres    false            ?            1259    42148    autore    TABLE     |   CREATE TABLE public.autore (
    id bigint NOT NULL,
    cognome character varying(255),
    nome character varying(255)
);
    DROP TABLE public.autore;
       public         heap    postgres    false            ?            1259    39615    autore_libro    TABLE     b   CREATE TABLE public.autore_libro (
    autore_id bigint NOT NULL,
    libro_id bigint NOT NULL
);
     DROP TABLE public.autore_libro;
       public         heap    postgres    false            ?            1259    42155 	   categoria    TABLE     [   CREATE TABLE public.categoria (
    id bigint NOT NULL,
    nome character varying(255)
);
    DROP TABLE public.categoria;
       public         heap    postgres    false            ?            1259    39718    categoria_libro    TABLE     h   CREATE TABLE public.categoria_libro (
    categoria_id bigint NOT NULL,
    libro_id bigint NOT NULL
);
 #   DROP TABLE public.categoria_libro;
       public         heap    postgres    false            ?            1259    42147    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    42160    libro    TABLE     ?   CREATE TABLE public.libro (
    id bigint NOT NULL,
    anno integer NOT NULL,
    prezzo double precision NOT NULL,
    titolo character varying(255)
);
    DROP TABLE public.libro;
       public         heap    postgres    false            ?            1259    42165    libro_autore    TABLE     b   CREATE TABLE public.libro_autore (
    libro_id bigint NOT NULL,
    autore_id bigint NOT NULL
);
     DROP TABLE public.libro_autore;
       public         heap    postgres    false            ?            1259    42168    libro_categoria    TABLE     h   CREATE TABLE public.libro_categoria (
    libro_id bigint NOT NULL,
    categoria_id bigint NOT NULL
);
 #   DROP TABLE public.libro_categoria;
       public         heap    postgres    false            ?            1259    42171    role    TABLE     W   CREATE TABLE public.role (
    id integer NOT NULL,
    name character varying(255)
);
    DROP TABLE public.role;
       public         heap    postgres    false            ?            1259    42176 	   user_role    TABLE     ^   CREATE TABLE public.user_role (
    user_id integer NOT NULL,
    role_id integer NOT NULL
);
    DROP TABLE public.user_role;
       public         heap    postgres    false            ?            1259    42181    user_spring    TABLE     ?   CREATE TABLE public.user_spring (
    id integer NOT NULL,
    email character varying(255),
    is_active boolean NOT NULL,
    password character varying(255),
    user_name character varying(255)
);
    DROP TABLE public.user_spring;
       public         heap    postgres    false                       0    42148    autore 
   TABLE DATA           3   COPY public.autore (id, cognome, nome) FROM stdin;
    public          postgres    false    212   ?(                 0    39615    autore_libro 
   TABLE DATA           ;   COPY public.autore_libro (autore_id, libro_id) FROM stdin;
    public          postgres    false    209   8)       !          0    42155 	   categoria 
   TABLE DATA           -   COPY public.categoria (id, nome) FROM stdin;
    public          postgres    false    213   U)                 0    39718    categoria_libro 
   TABLE DATA           A   COPY public.categoria_libro (categoria_id, libro_id) FROM stdin;
    public          postgres    false    210   ?)       "          0    42160    libro 
   TABLE DATA           9   COPY public.libro (id, anno, prezzo, titolo) FROM stdin;
    public          postgres    false    214   ?)       #          0    42165    libro_autore 
   TABLE DATA           ;   COPY public.libro_autore (libro_id, autore_id) FROM stdin;
    public          postgres    false    215   *       $          0    42168    libro_categoria 
   TABLE DATA           A   COPY public.libro_categoria (libro_id, categoria_id) FROM stdin;
    public          postgres    false    216   )*       %          0    42171    role 
   TABLE DATA           (   COPY public.role (id, name) FROM stdin;
    public          postgres    false    217   N*       &          0    42176 	   user_role 
   TABLE DATA           5   COPY public.user_role (user_id, role_id) FROM stdin;
    public          postgres    false    218   *       '          0    42181    user_spring 
   TABLE DATA           P   COPY public.user_spring (id, email, is_active, password, user_name) FROM stdin;
    public          postgres    false    219   ?*       .           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 14, true);
          public          postgres    false    211            ?           2606    42154    autore autore_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.autore
    ADD CONSTRAINT autore_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.autore DROP CONSTRAINT autore_pkey;
       public            postgres    false    212            ?           2606    42159    categoria categoria_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.categoria DROP CONSTRAINT categoria_pkey;
       public            postgres    false    213            ?           2606    42164    libro libro_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.libro
    ADD CONSTRAINT libro_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.libro DROP CONSTRAINT libro_pkey;
       public            postgres    false    214            ?           2606    42175    role role_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.role DROP CONSTRAINT role_pkey;
       public            postgres    false    217            ?           2606    42180    user_role user_role_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT user_role_pkey PRIMARY KEY (user_id, role_id);
 B   ALTER TABLE ONLY public.user_role DROP CONSTRAINT user_role_pkey;
       public            postgres    false    218    218            ?           2606    42187    user_spring user_spring_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.user_spring
    ADD CONSTRAINT user_spring_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.user_spring DROP CONSTRAINT user_spring_pkey;
       public            postgres    false    219            ?           2606    42203 +   libro_categoria fk11952p0wwxdk8rtrftctop2on    FK CONSTRAINT     ?   ALTER TABLE ONLY public.libro_categoria
    ADD CONSTRAINT fk11952p0wwxdk8rtrftctop2on FOREIGN KEY (libro_id) REFERENCES public.libro(id);
 U   ALTER TABLE ONLY public.libro_categoria DROP CONSTRAINT fk11952p0wwxdk8rtrftctop2on;
       public          postgres    false    3205    216    214            ?           2606    42208 %   user_role fka68196081fvovjhkek5m97n3y    FK CONSTRAINT     ?   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fka68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES public.role(id);
 O   ALTER TABLE ONLY public.user_role DROP CONSTRAINT fka68196081fvovjhkek5m97n3y;
       public          postgres    false    217    3207    218            ?           2606    42198 +   libro_categoria fkj6mhf7vwwovtyqpcxj7r9nlvg    FK CONSTRAINT     ?   ALTER TABLE ONLY public.libro_categoria
    ADD CONSTRAINT fkj6mhf7vwwovtyqpcxj7r9nlvg FOREIGN KEY (categoria_id) REFERENCES public.categoria(id);
 U   ALTER TABLE ONLY public.libro_categoria DROP CONSTRAINT fkj6mhf7vwwovtyqpcxj7r9nlvg;
       public          postgres    false    216    3203    213            ?           2606    42213 %   user_role fkjnbh64dhuo55gh2jd9d21d245    FK CONSTRAINT     ?   ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fkjnbh64dhuo55gh2jd9d21d245 FOREIGN KEY (user_id) REFERENCES public.user_spring(id);
 O   ALTER TABLE ONLY public.user_role DROP CONSTRAINT fkjnbh64dhuo55gh2jd9d21d245;
       public          postgres    false    219    3211    218            ?           2606    42193 (   libro_autore fkjqi5oqp3sw7g9mm1bhhqy1pi8    FK CONSTRAINT     ?   ALTER TABLE ONLY public.libro_autore
    ADD CONSTRAINT fkjqi5oqp3sw7g9mm1bhhqy1pi8 FOREIGN KEY (libro_id) REFERENCES public.libro(id);
 R   ALTER TABLE ONLY public.libro_autore DROP CONSTRAINT fkjqi5oqp3sw7g9mm1bhhqy1pi8;
       public          postgres    false    214    215    3205            ?           2606    42188 (   libro_autore fksgfg0ss84qscvi1l8fdd45qwj    FK CONSTRAINT     ?   ALTER TABLE ONLY public.libro_autore
    ADD CONSTRAINT fksgfg0ss84qscvi1l8fdd45qwj FOREIGN KEY (autore_id) REFERENCES public.autore(id);
 R   ALTER TABLE ONLY public.libro_autore DROP CONSTRAINT fksgfg0ss84qscvi1l8fdd45qwj;
       public          postgres    false    3201    212    215                =   x?3??/.???M,???2?K-J??t??/J?8?2???ļ?L.Cc +??b???? $u?            x?????? ? ?      !   :   x?3???M̫??2?t,-?O??O/JL?L?24???/*?/?24?t??+I?????? ???            x?????? ? ?      "   8   x???4202?44ҳ???Q?+??I??
q??Yp?d?*?&??p??qqq ?<      #      x???4???4?????? ??      $      x???4???4?????? ??      %   !   x?3???q?wt????2?pB?]??b???? s??      &      x?3?4?????? f      '   a   x?3?LL???sH??M???K???,?T1JT14P??Kqr?J	(2?p3r?????/.??3)rq??2?L?O֫*?4̫??,???J)sN??????? Z?     