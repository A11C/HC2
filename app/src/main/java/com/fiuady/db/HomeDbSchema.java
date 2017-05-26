package com.fiuady.db;


public final class HomeDbSchema {

    public static final class CuentasTable {
        public static final String NAME = "cuentas";

        public static final class Columns {
            public static final String ID = "id";
            public static final String USUARIO = "usuario";
            public static final String CONTRASEÑA = "contraseña";
        }
    }

    public static final class PerfilesTable {
        public static final String NAME = "perfiles";

        public static final class Columns {
            public static final String ID = "id";
            public static final String USUARIO_ID = "usuario_id";
            public static final String DESCRIPCION = "descripcion";
        }
    }

    public static final class Pin_PuertaTable {
        public static final String NAME = "pin_puerta";

        public static final class Columns {
            public static final String ID = "id";
            public static final String USUARIO_ID = "usuario_id";
            public static final String PIN = "pin";
        }
    }

    public static final class Area_CocheraTable {
        public static final String NAME = "area_cochera";

        public static final class Columns {
            public static final String ID = "id";
            public static final String PERFIL_ID = "perfil_id";
            public static final String PUERTA = "puerta";
        }
    }

    public static final class Area_FrenteTable {
        public static final String NAME = "area_frente";

        public static final class Columns {
            public static final String ID = "id";
            public static final String PERFIL_ID = "perfil_id";
            public static final String PUERTA = "puerta";
            public static final String LUZ = "luz";
            public static final String SENSOR = "sensor";
            public static final String INTENSIDAD = "intensidad";
        }
    }

    public static final class Area_Hab1Table {
        public static final String NAME = "area_hab1";

        public static final class Columns {
            public static final String ID = "id";
            public static final String PERFIL_ID = "perfil_id";
            public static final String LUZ = "luz";
            public static final String RGB = "rgb";
            public static final String VENTANA = "ventana";
            public static final String VENTILADOR = "ventilador";
            public static final String AUTOVENTI = "autoventi";
            public static final String TEMPMIN = "tempmin";
            public static final String TEMPMAX = "tempmax";
        }
    }

    public static final class Area_Hab2Table {
        public static final String NAME = "area_hab2";

        public static final class Columns {
            public static final String ID = "id";
            public static final String PERFIL_ID = "perfil_id";
            public static final String LUZ = "luz";
            public static final String RGB = "rgb";
            public static final String VENTANA = "ventana";
            public static final String VENTILADOR = "ventilador";
            public static final String AUTOVENTI = "autoventi";
            public static final String TEMPMIN = "tempmin";
            public static final String TEMPMAX = "tempmax";
        }
    }

    public static final class Area_PatioTable {
        public static final String NAME = "area_patio";

        public static final class Columns {
            public static final String ID = "id";
            public static final String PERFIL_ID = "perfil_id";
           public static final String LUZEXT = "luzext";
           public static final String SENSOREXT = "sensorext";
           public static final String INTENEXT = "intenext";
           public static final String LUZPISCI = "luzpisci";
           public static final String SENSORPISCI = "sensorpisci";
           public static final String INTENPISCI = "intenpisci";
           public static final String VENTANA = "ventana";
        }
    }

    public static final class Area_SalaTable {
        public static final String NAME = "area_sala";

        public static final class Columns {
            public static final String ID = "id";
            public static final String PERFIL_ID = "perfil_id";
            public static final String PUERTA = "puerta";
            public static final String VENTANA = "ventana";
            public static final String SENSORMOV = "sensormov";
        }
    }

    public static final class AlarmaTable {
        public static final String NAME = "alarmas";

        public static final class Columns {
            public static final String ID = "id";
            public static final String PERFIL_ID = "perfil_id";
            public static final String PUERTA = "puerta";
            public static final String COCHERA = "cochera";
            public static final String SALA = "sala";
            public static final String HABITACION1 = "habitacion1";
            public static final String HABITACION2 = "habitacion2";
            public static final String SENSOR = "sensor";
        }
    }
}
