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

INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (0, 0, 'a');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (1, 1, 'a');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (2, 2, 'a');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (3, 3, 'a');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (4, 4, 'a');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (5, 5, 'a');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (6, 6, 'a');
INSERT INTO area_cochera (id, perfil_id, puerta) VALUES (7, 7, 'a');

INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (0, 0, 'a', 'b ','c', 'd ');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (1, 1, 'a', 'b ','c', 'd ');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (2, 2, 'a', 'b ','c', 'd ');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (3, 3, 'a', 'b ','c', 'd ');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (4, 4, 'a', 'b ','c', 'd ');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (5, 5, 'a', 'b ','c', 'd ');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (6, 6, 'a', 'b ','c', 'd ');
INSERT INTO area_frente (id, perfil_id, puerta, luz, sensor, intensidad) VALUES (7, 7, 'a', 'b ','c', 'd ');

INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (0, 0, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (1, 1, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (2, 2, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (3, 3, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (4, 4, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (5, 5, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (6, 6, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab1 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (7, 7, 'a', 'b', 'c', 'd', 'e', 'f', 'g');

INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (0, 0, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (1, 1, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (2, 2, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (3, 3, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (4, 4, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (5, 5, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (6, 6, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_hab2 (id, perfil_id, luz, rgb, ventana, ventilador, autoventi, tempmin, tempmax) VALUES (7, 7, 'a', 'b', 'c', 'd', 'e', 'f', 'g');

INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (0, 0, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (1, 1, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (2, 2, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (3, 3, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (4, 4, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (5, 5, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (6, 6, 'a', 'b', 'c', 'd', 'e', 'f', 'g');
INSERT INTO area_patio (id, perfil_id, luzext, sensorext, intenext, luzpisci, sensorpisci, intenpisci, ventana) VALUES (7, 7, 'a', 'b', 'c', 'd', 'e', 'f', 'g');

INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (0, 0, 'a', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (1, 1, 'a', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (2, 2, 'a', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (3, 3, 'a', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (4, 4, 'a', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (5, 5, 'a', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (6, 6, 'a', 'b', 'c');
INSERT INTO area_sala (id, perfil_id, puerta, ventana, sensormov) VALUES (7, 7, 'a', 'b', 'c');

INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (0, 0, 'a', 'b', 'c', 'd', 'e', 'f');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (1, 1, 'a', 'b', 'c', 'd', 'e', 'f');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (2, 2, 'a', 'b', 'c', 'd', 'e', 'f');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (3, 3, 'a', 'b', 'c', 'd', 'e', 'f');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (4, 4, 'a', 'b', 'c', 'd', 'e', 'f');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (5, 5, 'a', 'b', 'c', 'd', 'e', 'f');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (6, 6, 'a', 'b', 'c', 'd', 'e', 'f');
INSERT INTO alarmas (id, perfil_id, puerta, cochera, sala, habitacion1, habitacion2, sensor) VALUES (7, 7, 'a', 'b', 'c', 'd', 'e', 'f');