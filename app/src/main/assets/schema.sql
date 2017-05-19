CREATE TABLE [cuentas](
    [id] INTEGER PRIMARY KEY,
    [usuario] TEXT NOT NULL,
    [contraseña] TEXT NOT NULL);

CREATE TABLE [perfiles](
    [id] INTEGER PRIMARY KEY,
    [usuario_id] INTEGER NOT NULL REFERENCES cuentas([id]),
    [descripcion] TEXT NOT NULL);

CREATE TABLE [pin_puerta](
    [id] INTEGER PRIMARY KEY,
    [usuario_id] INTEGER NOT NULL REFERENCES cuentas([id]) UNIQUE,
    [pin] INTEGER NOT NULL);

CREATE TABLE [area_cochera](
    [id] INTEGER PRIMARY KEY,
    [perfil_id] INTEGER NOT NULL REFERENCES perfiles([id]),
    [dato1] TEXT NOT NULL,
    [dato2] TEXT NOT NULL,
    [dato3] TEXT NOT NULL);

CREATE TABLE [area_frente](
    [id] INTEGER PRIMARY KEY,
    [perfil_id] INTEGER NOT NULL REFERENCES perfiles([id]),
    [dato1] TEXT NOT NULL,
    [dato2] TEXT NOT NULL,
    [dato3] TEXT NOT NULL);

CREATE TABLE [area_hab1](
    [id] INTEGER PRIMARY KEY,
    [perfil_id] INTEGER NOT NULL REFERENCES perfiles([id]),
    [dato1] TEXT NOT NULL,
    [dato2] TEXT NOT NULL,
    [dato3] TEXT NOT NULL);

CREATE TABLE [area_hab2](
    [id] INTEGER PRIMARY KEY,
    [perfil_id] INTEGER NOT NULL REFERENCES perfiles([id]),
    [dato1] TEXT NOT NULL,
    [dato2] TEXT NOT NULL,
    [dato3] TEXT NOT NULL);

CREATE TABLE [area_patio](
    [id] INTEGER PRIMARY KEY,
    [perfil_id] INTEGER NOT NULL REFERENCES perfiles([id]),
    [dato1] TEXT NOT NULL,
    [dato2] TEXT NOT NULL,
    [dato3] TEXT NOT NULL);

CREATE TABLE [area_sala](
    [id] INTEGER PRIMARY KEY,
    [perfil_id] INTEGER NOT NULL REFERENCES perfiles([id]),
    [dato1] TEXT NOT NULL,
    [dato2] TEXT NOT NULL,
    [dato3] TEXT NOT NULL);
