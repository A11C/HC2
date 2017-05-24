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
    [puerta] TEXT NOT NULL);

CREATE TABLE [area_frente](
    [id] INTEGER PRIMARY KEY,
    [perfil_id] INTEGER NOT NULL REFERENCES perfiles([id]),
    [puerta] TEXT NOT NULL,
    [luz] TEXT NOT NULL,
    [sensor] TEXT NOT NULL,
    [intensidad] TEXT NOT NULL);

CREATE TABLE [area_hab1](
    [id] INTEGER PRIMARY KEY,
    [perfil_id] INTEGER NOT NULL REFERENCES perfiles([id]),
    [luz] TEXT NOT NULL,
    [luzr] TEXT NOT NULL,
    [luzg] TEXT NOT NULL,
    [luzb] TEXT NOT NULL,
    [ventana] TEXT NOT NULL,
    [ventilador] TEXT NOT NULL,
    [autoventi] TEXT NOT NULL,
    [tempmin] TEXT NOT NULL,
    [tempmax] TEXT NOT NULL,
    [tempact] TEXT NOT NULL);

CREATE TABLE [area_hab2](
    [id] INTEGER PRIMARY KEY,
    [perfil_id] INTEGER NOT NULL REFERENCES perfiles([id]),
    [luz] TEXT NOT NULL,
    [luzr] TEXT NOT NULL,
    [luzg] TEXT NOT NULL,
    [luzb] TEXT NOT NULL,
    [ventana] TEXT NOT NULL,
    [ventilador] TEXT NOT NULL,
    [autoventi] TEXT NOT NULL,
    [tempmin] TEXT NOT NULL,
    [tempmax] TEXT NOT NULL,
    [tempact] TEXT NOT NULL);

CREATE TABLE [area_patio](
    [id] INTEGER PRIMARY KEY,
    [perfil_id] INTEGER NOT NULL REFERENCES perfiles([id]),
    [luzext] TEXT NOT NULL,
    [sensorext] TEXT NOT NULL,
    [intenext] TEXT NOT NULL,
    [luzpisci] TEXT NOT NULL,
    [sensorpisci] TEXT NOT NULL,
    [intenpisci] TEXT NOT NULL,
    [ventana] TEXT NOT NULL);

CREATE TABLE [area_sala](
    [id] INTEGER PRIMARY KEY,
    [perfil_id] INTEGER NOT NULL REFERENCES perfiles([id]),
    [puerta] TEXT NOT NULL,
    [ventana] TEXT NOT NULL,
    [sensormov] TEXT NOT NULL);

CREATE TABLE [alarmas](
    [id] INTEGER PRIMARY KEY,
    [perfil_id] INTEGER NOT NULL REFERENCES perfiles([id]),
    [puerta] TEXT NOT NULL,
    [cochera] TEXT NOT NULL,
    [sala] TEXT NOT NULL,
    [habitacion1] TEXT NOT NULL,
    [habitacion2] TEXT NOT NULL,
    [sensor] TEXT NOT NULL);