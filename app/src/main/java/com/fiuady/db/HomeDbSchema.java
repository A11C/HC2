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
            public static final String DATO1 = "dato1";
            public static final String DATO2 = "dato2";
            public static final String DATO3 = "dato3";
        }
    }

    public static final class Area_FrenteTable {
        public static final String NAME = "area_frente";

        public static final class Columns {
            public static final String ID = "id";
            public static final String PERFIL_ID = "perfil_id";
            public static final String DATO1 = "dato1";
            public static final String DATO2 = "dato2";
            public static final String DATO3 = "dato3";
        }
    }

    public static final class Area_Hab1Table {
        public static final String NAME = "area_hab1";

        public static final class Columns {
            public static final String ID = "id";
            public static final String PERFIL_ID = "perfil_id";
            public static final String DATO1 = "dato1";
            public static final String DATO2 = "dato2";
            public static final String DATO3 = "dato3";
        }
    }

    public static final class Area_Hab2Table {
        public static final String NAME = "area_hab2";

        public static final class Columns {
            public static final String ID = "id";
            public static final String PERFIL_ID = "perfil_id";
            public static final String DATO1 = "dato1";
            public static final String DATO2 = "dato2";
            public static final String DATO3 = "dato3";
        }
    }

    public static final class Area_PatioTable {
        public static final String NAME = "area_patio";

        public static final class Columns {
            public static final String ID = "id";
            public static final String PERFIL_ID = "perfil_id";
            public static final String DATO1 = "dato1";
            public static final String DATO2 = "dato2";
            public static final String DATO3 = "dato3";
        }
    }

    public static final class Area_SalaTable {
        public static final String NAME = "area_sala";

        public static final class Columns {
            public static final String ID = "id";
            public static final String PERFIL_ID = "perfil_id";
            public static final String DATO1 = "dato1";
            public static final String DATO2 = "dato2";
            public static final String DATO3 = "dato3";
        }
    }
}
