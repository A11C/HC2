INSERT INTO cuentas (id, usuario, contraseña) VALUES (0, 'Jessica', 'jessica');
INSERT INTO cuentas (id, usuario, contraseña) VALUES (1, 'Leandro', 'leandro');
INSERT INTO cuentas (id, usuario, contraseña) VALUES (2, 'Wilberth', 'wilo');
INSERT INTO cuentas (id, usuario, contraseña) VALUES (3, 'Luis', 'lichotixko');

INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (0, 0, 'Alegre');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (1, 0, 'Triste');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (2, 1, 'Emocionado');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (3, 1, 'Pensativo');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (4, 2, 'Molesto');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (5, 2, 'Romantico');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (6, 3, 'Enamorado');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (7, 3, 'Borracho');

INSERT INTO pin_puerta (id, usuario_id, pin) VALUES (0, 0, 1234);
INSERT INTO pin_puerta (id, usuario_id, pin) VALUES (1, 1, 5678);
INSERT INTO pin_puerta (id, usuario_id, pin) VALUES (2, 2, 9876);
INSERT INTO pin_puerta (id, usuario_id, pin) VALUES (3, 3, 1111);

INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (0, 0, 'S2c.');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (1, 1, 'S2c.');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (2, 2, 'S2c.');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (3, 3, 'S2c.');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (4, 4, 'S2c.');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (5, 5, 'S2c.');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (6, 6, 'S2c.');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (7, 7, 'S2c.');

INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (0, 0, 'S1a.', 'L1d.','D1a.', '255.');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (1, 1, 'S1c.', 'L1d.','D1a.', '150');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (2, 2, 'S1c.', 'L1d.','D1a.', '135');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (3, 3, 'S1c.', 'L1d.','D1a.', '200');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (4, 4, 'S1c.', 'L1d.','D1a.', '140');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (5, 5, 'S1c.', 'L1d.','D1a.', '255');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (6, 6, 'S1c.', 'L1d.','D1a.', '10');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (7, 7, 'S1c.', 'L1d.','D1a.', '30');

INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (0, 0, 'R1d.', '255180125', 'c', 'V1d.', 'C1d.', '18', '45');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (1, 1, 'R1d.', '255180125', 'c', 'V1d.', 'C1d.', '18', '45');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (2, 2, 'R1d.', '255180125', 'c', 'V1d.', 'C1d.', '18', '45');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (3, 3, 'R1d.', '255180125', 'c', 'V1d.', 'C1d.', '18', '45');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (4, 4, 'R1d.', '255180125', 'c', 'V1d.', 'C1d.', '18', '45');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (5, 5, 'R1d.', '255180125', 'c', 'V1d.', 'C1d.', '18', '45');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (6, 6, 'R1d.', '255180125', 'c', 'V1d.', 'C1d.', '18', '45');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (7, 7, 'R1d.', '255180125', 'c', 'V1d.', 'C1d.', '18', '45');

INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (0, 0, 'R2d.', '255180125', 'c', 'V2d.', 'C2d.', '20', '40');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (1, 1, 'R2d.', '255180125', 'c', 'V2d.', 'C2d.', '20', '40');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (2, 2, 'R2d.', '255180125', 'c', 'V2d.', 'C2d.', '20', '40');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (3, 3, 'R2d.', '255180125', 'c', 'V2d.', 'C2d.', '20', '40');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (4, 4, 'R2d.', '255180125', 'c', 'V2d.', 'C2d.', '20', '40');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (5, 5, 'R2d.', '255180125', 'c', 'V2d.', 'C2d.', '20', '40');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (6, 6, 'R2d.', '255180125', 'c', 'V2d.', 'C2d.', '20', '40');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (7, 7, 'R2d.', '255180125', 'c', 'V2d.', 'C2d.', '20', '40');

INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (0, 0, 'L2d.', 'D2a.', '180', 'L3d.', 'D2a.', '255', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (1, 1, 'L2d.', 'D2a.', '180', 'L3d.', 'D2a.', '255', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (2, 2, 'L2d.', 'D2a.', '180', 'L3d.', 'D2a.', '255', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (3, 3, 'L2d.', 'D2a.', '180', 'L3d.', 'D2a.', '255', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (4, 4, 'L2d.', 'D2a.', '180', 'L3d.', 'D2a.', '255', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (5, 5, 'L2d.', 'D2a.', '180', 'L3d.', 'D2a.', '255', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (6, 6, 'L2d.', 'D2a.', '180', 'L3d.', 'D2a.', '255', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (7, 7, 'L2d.', 'D2a.', '180', 'L3d.', 'D2a.', '255', 'g');

INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (0, 0, 'S1c.', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (1, 1, 'S1c.', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (2, 2, 'S1c.', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (3, 3, 'S1c.', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (4, 4, 'S1c.', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (5, 5, 'S1c.', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (6, 6, 'S1c.', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (7, 7, 'S1c.', 'b', 'c');

INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (0, 0, '0', '1', '0', '1', '0', '1');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (1, 1, '0', '1', '0', '1', '0', '1');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (2, 2, '0', '1', '0', '1', '0', '1');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (3, 3, '0', '1', '0', '1', '0', '1');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (4, 4, '0', '1', '0', '1', '0', '1');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (5, 5, '0', '1', '0', '1', '0', '1');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (6, 6, '0', '1', '0', '1', '0', '1');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (7, 7, '0', '1', '0', '1', '0', '1');