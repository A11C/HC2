INSERT INTO cuentas (id, usuario, contraseña) VALUES (0, 'Jessica', 'jessica');
INSERT INTO cuentas (id, usuario, contraseña) VALUES (1, 'Leandro', 'leandro');
INSERT INTO cuentas (id, usuario, contraseña) VALUES (2, 'Wilberth', 'wilo');
INSERT INTO cuentas (id, usuario, contraseña) VALUES (3, 'Luis', 'lichotixko');

INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (0, 0, 'Perfil 1');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (1, 0, 'Perfil 2');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (2, 1, 'Perfil 5');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (3, 1, 'Perfil 6');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (4, 2, 'Perfil 12');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (5, 2, 'Perfil 13');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (6, 3, 'Perfil 56');
INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (7, 3, 'Perfil 57');

INSERT INTO pin_puerta (id, usuario_id, pin) VALUES (0, 0, 1234);
INSERT INTO pin_puerta (id, usuario_id, pin) VALUES (1, 1, 5678);
INSERT INTO pin_puerta (id, usuario_id, pin) VALUES (2, 2, 9876);
INSERT INTO pin_puerta (id, usuario_id, pin) VALUES (3, 3, 1111);