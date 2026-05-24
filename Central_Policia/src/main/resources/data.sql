
INSERT INTO dep_data (name) VALUES ('San salvador') ON CONFLICT (name) DO NOTHING;
INSERT INTO dep_data (name) VALUES ('Ahuachapán') ON CONFLICT (name) DO NOTHING;
INSERT INTO dep_data (name) VALUES ('Santa Ana') ON CONFLICT (name) DO NOTHING;
INSERT INTO dep_data (name) VALUES ('Sonsonate') ON CONFLICT (name) DO NOTHING;
INSERT INTO dep_data (name) VALUES ('Chalatenango') ON CONFLICT (name) DO NOTHING;
INSERT INTO dep_data (name) VALUES ('La Libertad') ON CONFLICT (name) DO NOTHING;
INSERT INTO dep_data (name) VALUES ('Cuscatlán') ON CONFLICT (name) DO NOTHING;
INSERT INTO dep_data (name) VALUES ('La Paz') ON CONFLICT (name) DO NOTHING;
INSERT INTO dep_data (name) VALUES ('Cabañas') ON CONFLICT (name) DO NOTHING;
INSERT INTO dep_data (name) VALUES ('San Vicente') ON CONFLICT (name) DO NOTHING;
INSERT INTO dep_data (name) VALUES ('Usulután') ON CONFLICT (name) DO NOTHING;
INSERT INTO dep_data (name) VALUES ('San Miguel') ON CONFLICT (name) DO NOTHING;
INSERT INTO dep_data (name) VALUES ('Morazán') ON CONFLICT (name) DO NOTHING;
INSERT INTO dep_data (name) VALUES ('La Unión') ON CONFLICT (name) DO NOTHING;

-- Cargando municipios --

-- 1. San Salvador (ID 1)
INSERT INTO mun_data (name, dep_id) VALUES ('San Salvador', 1) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('Mejicanos', 1) ON CONFLICT (name) DO NOTHING;

-- 2. Ahuachapán (ID 2)
INSERT INTO mun_data (name, dep_id) VALUES ('Ahuachapán', 2) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('Concepción de Ataco', 2) ON CONFLICT (name) DO NOTHING;

-- 3. Santa Ana (ID 3)
INSERT INTO mun_data (name, dep_id) VALUES ('Santa Ana', 3) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('Metapán', 3) ON CONFLICT (name) DO NOTHING;

-- 4. Sonsonate (ID 4)
INSERT INTO mun_data (name, dep_id) VALUES ('Sonsonate', 4) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('Izalco', 4) ON CONFLICT (name) DO NOTHING;

-- 5. Chalatenango (ID 5)
INSERT INTO mun_data (name, dep_id) VALUES ('Chalatenango', 5) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('La Palma', 5) ON CONFLICT (name) DO NOTHING;

-- 6. La Libertad (ID 6)
INSERT INTO mun_data (name, dep_id) VALUES ('Santa Tecla', 6) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('Antiguo Cuscatlán', 6) ON CONFLICT (name) DO NOTHING;

-- 7. Cuscatlán (ID 7)
INSERT INTO mun_data (name, dep_id) VALUES ('Cojutepeque', 7) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('Suchitoto', 7) ON CONFLICT (name) DO NOTHING;

-- 8. La Paz (ID 8)
INSERT INTO mun_data (name, dep_id) VALUES ('Zacatecoluca', 8) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('Olocuilta', 8) ON CONFLICT (name) DO NOTHING;

-- 9. Cabañas (ID 9)
INSERT INTO mun_data (name, dep_id) VALUES ('Sensuntepeque', 9) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('Ilobasco', 9) ON CONFLICT (name) DO NOTHING;

-- 10. San Vicente (ID 10)
INSERT INTO mun_data (name, dep_id) VALUES ('San Vicente', 10) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('Apastepeque', 10) ON CONFLICT (name) DO NOTHING;

-- 11. Usulután (ID 11)
INSERT INTO mun_data (name, dep_id) VALUES ('Usulután', 11) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('Jiquilisco', 11) ON CONFLICT (name) DO NOTHING;

-- 12. San Miguel (ID 12)
INSERT INTO mun_data (name, dep_id) VALUES ('San Miguel', 12) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('Ciudad Barrios', 12) ON CONFLICT (name) DO NOTHING;

-- 13. Morazán (ID 13)
INSERT INTO mun_data (name, dep_id) VALUES ('San Francisco Gotera', 13) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('Perquín', 13) ON CONFLICT (name) DO NOTHING;

-- 14. La Unión (ID 14)
INSERT INTO mun_data (name, dep_id) VALUES ('La Unión', 14) ON CONFLICT (name) DO NOTHING;
INSERT INTO mun_data (name, dep_id) VALUES ('Santa Rosa de Lima', 14) ON CONFLICT (name) DO NOTHING;

-- Insertando direcciones

INSERT INTO dir_data (calle,colonia, municipio_id) VALUES ('Altanir Logaznos','Los santos de los santos', 12 );
INSERT INTO dir_data (calle, colonia, municipio_id) VALUES ('Avenida Los Pinos', 'Residencial Las Margaritas', 5);
INSERT INTO dir_data (calle, colonia, municipio_id) VALUES ('Calle El Pedregal', 'Urbanización La Cumbre', 18);
INSERT INTO dir_data (calle, colonia, municipio_id) VALUES ('Bulevar Los Próceres', 'Colonia San Benito', 2);
INSERT INTO dir_data (calle, colonia, municipio_id) VALUES ('Avenida Independencia', 'Barrio San Jacinto', 27);
INSERT INTO dir_data (calle, colonia, municipio_id) VALUES ('Calle Los Castaños', 'Residencial Los Cerezos', 14);
INSERT INTO dir_data (calle, colonia, municipio_id) VALUES ('Paseo Principal', 'Colonia Campestre', 9);
INSERT INTO dir_data (calle, colonia, municipio_id) VALUES ('Avenida Bernal', 'Reparto Los Héroes', 22);
INSERT INTO dir_data (calle, colonia, municipio_id) VALUES ('Calle Antigua', 'Residencial Santa Teresa', 3);
INSERT INTO dir_data (calle, colonia, municipio_id) VALUES ('Bulevar Constitución', 'Colonia Satélite', 11);
INSERT INTO dir_data (calle, colonia, municipio_id) VALUES ('Avenida Jerusalén', 'Urbanización Maquilishuat', 25);


-- Insertando personas

INSERT INTO person_data(id, name, dui, tel, dir_id) VALUES (gen_random_uuid(), 'Jaimito lopez Santos de la madre', '06536410-0','7197-1030', 1) ON CONFLICT (dui) DO NOTHING;

INSERT INTO person_data(id, name, dui, tel, dir_id) VALUES (gen_random_uuid(), 'Ana María Mancia', '01234567-8', '7234-5678', 2) ON CONFLICT (dui) DO NOTHING;

INSERT INTO person_data(id, name, dui, tel, dir_id) VALUES (gen_random_uuid(), 'Carlos Roberto Fuentes', '02345678-9', '6345-6789', 3) ON CONFLICT (dui) DO NOTHING;

INSERT INTO person_data(id, name, dui, tel, dir_id) VALUES (gen_random_uuid(), 'Laura Beatriz Pineda', '03456789-0', '7456-7890', 4) ON CONFLICT (dui) DO NOTHING;

INSERT INTO person_data(id, name, dui, tel, dir_id) VALUES (gen_random_uuid(), 'José Antonio Martínez', '04567890-1', '6567-8901', 5) ON CONFLICT (dui) DO NOTHING;

INSERT INTO person_data(id, name, dui, tel, dir_id) VALUES (gen_random_uuid(), 'Carmen Elena Quintanilla', '05678901-2', '7678-9012', 6) ON CONFLICT (dui) DO NOTHING;
-- Insertando Policias

INSERT INTO policia_data (id, numero_identificacion, placa, persona_id, estacion_id)
VALUES (
           gen_random_uuid(),
           '001',
           'NPC-001',
           (SELECT id FROM person_data WHERE dui = '06536410-0'),
           null
       );

INSERT INTO policia_data (id, numero_identificacion, placa, persona_id, estacion_id)
VALUES (
           gen_random_uuid(),
           '002',
           'NPC-002',
           (SELECT id FROM person_data WHERE dui = '01234567-8'),
           null
       );

INSERT INTO policia_data (id, numero_identificacion, placa, persona_id, estacion_id)
VALUES (
           gen_random_uuid(),
           '003',
           'NPC-003',
           (SELECT id FROM person_data WHERE dui = '02345678-9'),
           null
       );

INSERT INTO policia_data (id, numero_identificacion, placa, persona_id, estacion_id)
VALUES (
           gen_random_uuid(),
           '004',
           'NPC-004',
           (SELECT id FROM person_data WHERE dui = '03456789-0'),
           null
       );

INSERT INTO estacion_policial (id,nombre,direccion_id,director_id)
VALUES (1, 'Estacion gran central', 2,
        (SELECT id from policia_data WHERE placa = 'NPC-001'));

INSERT INTO estacion_policial (id,nombre,direccion_id,director_id)
VALUES (2, 'NSCCS', 1,
    (SELECT id from policia_data WHERE placa = 'NPC-002'));

UPDATE policia_data set estacion_id = 1 WHERE placa = 'NPC-001';

UPDATE policia_data set estacion_id = 2 where placa = 'NPC-003';

UPDATE policia_data set estacion_id = 2 where placa = 'NPC-002';

UPDATE policia_data set estacion_id = 1 where placa = 'NPC-004';




