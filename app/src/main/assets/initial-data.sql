INSERT INTO cuentas (id, usuario, contraseña) VALUES (0, 'Jessica', 'jessica');
INSERT INTO cuentas (id, usuario, contraseña) VALUES (1, 'Leandro', 'leandro');
INSERT INTO cuentas (id, usuario, contraseña) VALUES (2, 'Wilberth', 'wilo');
INSERT INTO cuentas (id, usuario, contraseña) VALUES (3, 'Luis', 'lichotixko');

INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (0, 0, 'Perfil 1');

INSERT INTO pin_puerta (id, usuario_id, pin) VALUES (0, 0, 1234);
INSERT INTO pin_puerta (id, usuario_id, pin) VALUES (1, 1, 5678);
INSERT INTO pin_puerta (id, usuario_id, pin) VALUES (2, 2, 9876);
INSERT INTO pin_puerta (id, usuario_id, pin) VALUES (3, 3, 1111);

INSERT INTO area_cochera (id, perfil_id, dato1, dato2, dato3) VALUES (0, 0, 'asd', 'ert', 'jkl');