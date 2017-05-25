package com.fiuady.db;

import com.fiuady.db.HomeDbSchema.*;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

class ClassCursor extends CursorWrapper {
    public ClassCursor(Cursor cursor) {
        super(cursor);
    }

    public Cuenta getCuenta() {
        Cursor cursor = getWrappedCursor();
        return new Cuenta(cursor.getInt(cursor.getColumnIndex(CuentasTable.Columns.ID)),
                cursor.getString(cursor.getColumnIndex(CuentasTable.Columns.USUARIO)),
                cursor.getString(cursor.getColumnIndex(CuentasTable.Columns.CONTRASEÑA)));
    }

    public Perfiles getPerfil() {
        Cursor cursor = getWrappedCursor();
        return new Perfiles(cursor.getInt(cursor.getColumnIndex(PerfilesTable.Columns.ID)),
                cursor.getInt(cursor.getColumnIndex(PerfilesTable.Columns.USUARIO_ID)),
                cursor.getString(cursor.getColumnIndex(PerfilesTable.Columns.DESCRIPCION)));
    }

    public Pin_puerta getPin_puerta() {
        Cursor cursor = getWrappedCursor();
        return new Pin_puerta(cursor.getInt(cursor.getColumnIndex(Pin_PuertaTable.Columns.ID)),
                cursor.getString(cursor.getColumnIndex(Pin_PuertaTable.Columns.USUARIO_ID)),
                cursor.getString(cursor.getColumnIndex(Pin_PuertaTable.Columns.PIN)));
    }

    public Area_cochera getCochera() {
        Cursor cursor = getWrappedCursor();
        return new Area_cochera(cursor.getInt(cursor.getColumnIndex(Area_CocheraTable.Columns.ID)),
                cursor.getInt(cursor.getColumnIndex(Area_CocheraTable.Columns.PERFIL_ID)),
                cursor.getString(cursor.getColumnIndex(Area_CocheraTable.Columns.PUERTA)));
    }

    public Area_frente getFrente() {
        Cursor cursor = getWrappedCursor();
        return new Area_frente(cursor.getInt(cursor.getColumnIndex(Area_FrenteTable.Columns.ID)),
                cursor.getInt(cursor.getColumnIndex(Area_FrenteTable.Columns.PERFIL_ID)),
                cursor.getString(cursor.getColumnIndex(Area_FrenteTable.Columns.PUERTA)),
                cursor.getString(cursor.getColumnIndex(Area_FrenteTable.Columns.LUZ)),
                cursor.getString(cursor.getColumnIndex(Area_FrenteTable.Columns.SENSOR)),
                cursor.getString(cursor.getColumnIndex(Area_FrenteTable.Columns.INTENSIDAD)));
    }

    public Area_hab1 getHabitacion1() {
        Cursor cursor = getWrappedCursor();
        return new Area_hab1(cursor.getInt(cursor.getColumnIndex(Area_Hab1Table.Columns.ID)),
                cursor.getInt(cursor.getColumnIndex(Area_Hab1Table.Columns.PERFIL_ID)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.LUZ)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.RGB)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.VENTANA)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.VENTILADOR)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.AUTOVENTI)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.TEMPMIN)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.TEMPMAX)));
    }

    public Area_hab2 getHabitacion2() {
        Cursor cursor = getWrappedCursor();
        return new Area_hab2(cursor.getInt(cursor.getColumnIndex(Area_Hab2Table.Columns.ID)),
                cursor.getInt(cursor.getColumnIndex(Area_Hab2Table.Columns.PERFIL_ID)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.LUZ)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.RGB)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.VENTANA)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.VENTILADOR)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.AUTOVENTI)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.TEMPMIN)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.TEMPMAX)));
    }

    public Area_patio getPatio() {
        Cursor cursor = getWrappedCursor();
        return new Area_patio(cursor.getInt(cursor.getColumnIndex(Area_PatioTable.Columns.ID)),
                cursor.getInt(cursor.getColumnIndex(Area_PatioTable.Columns.PERFIL_ID)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.LUZEXT)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.SENSOREXT)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.INTENEXT)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.LUZPISCI)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.SENSORPISCI)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.INTENPISCI)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.VENTANA)));
    }

    public Area_sala getSala() {
        Cursor cursor = getWrappedCursor();
        return new Area_sala(cursor.getInt(cursor.getColumnIndex(Area_SalaTable.Columns.ID)),
                cursor.getInt(cursor.getColumnIndex(Area_SalaTable.Columns.PERFIL_ID)),
                cursor.getString(cursor.getColumnIndex(Area_SalaTable.Columns.PUERTA)),
                cursor.getString(cursor.getColumnIndex(Area_SalaTable.Columns.VENTANA)),
                cursor.getString(cursor.getColumnIndex(Area_SalaTable.Columns.SENSORMOV)));
    }

    public Alarmas getAlarma() {
        Cursor cursor = getWrappedCursor();
        return new Alarmas(cursor.getInt(cursor.getColumnIndex(AlarmaTable.Columns.ID)),
                cursor.getInt(cursor.getColumnIndex(AlarmaTable.Columns.PERFIL_ID)),
                cursor.getString(cursor.getColumnIndex(AlarmaTable.Columns.PUERTA)),
                cursor.getString(cursor.getColumnIndex(AlarmaTable.Columns.COCHERA)),
                cursor.getString(cursor.getColumnIndex(AlarmaTable.Columns.SALA)),
                cursor.getString(cursor.getColumnIndex(AlarmaTable.Columns.HABITACION1)),
                cursor.getString(cursor.getColumnIndex(AlarmaTable.Columns.HABITACION2)),
                cursor.getString(cursor.getColumnIndex(AlarmaTable.Columns.SENSOR)));
    }
}

public final class Home {

    private HomeHelper homeHelper;
    private SQLiteDatabase db;

    public Home(Context context) {
        homeHelper = new HomeHelper(context);
        db = homeHelper.getWritableDatabase();
    }

    public int checkCuenta(String usuario, String contraseña) {
        int count = 0;
        String query = "SELECT COUNT(*) FROM cuentas WHERE usuario = '" + usuario + "' AND contraseña = '" + contraseña + "'";
        ClassCursor cursor = new ClassCursor(db.rawQuery(query, null));
        while (cursor.moveToNext()) {
            count = cursor.getInt(0);
        }
        cursor.close();
        return count;
    }

    public List<Cuenta> getAllCuentas() {
        ArrayList<Cuenta> list = new ArrayList<Cuenta>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM cuentas ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getCuenta());
        }
        cursor.close();

        return list;
    }

    public int getIdCuenta(String usuario) {
        int id = 0;

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT id FROM cuentas WHERE usuario = '" + usuario + "';", null));
        while (cursor.moveToNext()) {
            id = cursor.getInt(0);
        }
        cursor.close();
        return id;
    }

    public List<Perfiles> getAllPerfiles(int usuario_id) {
        ArrayList<Perfiles> list = new ArrayList<Perfiles>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM perfiles WHERE usuario_id = " + usuario_id + " ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getPerfil());
        }
        cursor.close();

        return list;
    }

    public int getIdPerfil(String perfil, int id) {
        int idp = 0;

        List<Perfiles> perfiles = getAllPerfiles(id);
        for (Perfiles perfiles1 : perfiles) {
            if (perfiles1.getDescripcion().toUpperCase().equals(perfil.toUpperCase())) {
                idp = perfiles1.getId();
                break;
            }
        }

        return idp;
    }

    public List<Pin_puerta> getAllPines(int perfil_id) {
        ArrayList<Pin_puerta> list = new ArrayList<Pin_puerta>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM pin_puerta WHERE perfil_id = " + perfil_id + " ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getPin_puerta());
        }
        cursor.close();

        return list;
    }

    public List<Area_cochera> getAllCochera(int perfil_id) {
        ArrayList<Area_cochera> list = new ArrayList<Area_cochera>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM area_cochera WHERE perfil_id = " + perfil_id + " ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getCochera());
        }
        cursor.close();

        return list;
    }

    public List<Area_frente> getAllFrente(int perfil_id) {
        ArrayList<Area_frente> list = new ArrayList<Area_frente>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM area_frente WHERE perfil_id = " + perfil_id + " ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getFrente());
        }
        cursor.close();

        return list;
    }

    public List<Area_hab1> getAllHabitacion1(int perfil_id) {
        ArrayList<Area_hab1> list = new ArrayList<Area_hab1>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM area_hab1 WHERE perfil_id = " + perfil_id + " ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getHabitacion1());
        }
        cursor.close();

        return list;
    }

    public List<Area_hab2> getAllHabitacion2(int perfil_id) {
        ArrayList<Area_hab2> list = new ArrayList<Area_hab2>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM area_hab2 WHERE perfil_id = " + perfil_id + " ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getHabitacion2());
        }
        cursor.close();

        return list;
    }

    public List<Area_patio> getAllPatio() {
        ArrayList<Area_patio> list = new ArrayList<Area_patio>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM area_patio ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getPatio());
        }
        cursor.close();

        return list;
    }

    public List<Area_sala> getAllSala(int perfil_id) {
        ArrayList<Area_sala> list = new ArrayList<Area_sala>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM area_sala WHERE perfil_id = " + perfil_id + " ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getSala());
        }
        cursor.close();

        return list;
    }

    public List<Alarmas> getAlmarmas(int perfil_id) {
        ArrayList<Alarmas> list = new ArrayList<Alarmas>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM alarmas WHERE perfil_id = " + perfil_id + " ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getAlarma());
        }
        cursor.close();

        return list;
    }

    public void updateCuenta(String usuario, String contraseña) {
        int idMax = 0;
        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT MAX(id) AS max FROM cuentas", null));
        while (cursor.moveToNext()) {
            idMax = cursor.getInt(0) + 1;
        }
        cursor.close();
        db.execSQL("INSERT INTO cuentas (id, usuario, contraseña) VALUES (" + String.valueOf(idMax) + ", '" + usuario + ", " + contraseña + "')");
    }

    public void updatePerfil(String usuario, String contraseña) {
        int idMax = 0;
        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT MAX(id) AS max FROM perfiles", null));
        while (cursor.moveToNext()) {
            idMax = cursor.getInt(0) + 1;
        }
        cursor.close();
        db.execSQL("INSERT INTO perfiles (id, usuario_id, descripcion) VALUES (" + String.valueOf(idMax) + ", '" + usuario + ", " + contraseña + "')");
    }

    public void updateCochera(int perfil_id, String puerta) {
        db.execSQL("UPDATE area_cochera SET puerta = '" + puerta + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }

    public void updateFrentePuerta(int perfil_id, String puerta) {
        db.execSQL("UPDATE area_frente SET puerta = '" + puerta + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateFrenteLuz(int perfil_id, String luz) {
        db.execSQL("UPDATE area_frente SET luz = '" + luz + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateFrenteSensor(int perfil_id, String sensor) {
        db.execSQL("UPDATE area_frente SET sensor = '" + sensor + "' WHERE perfil_id = " + String.valueOf(perfil_id));

    }
    public void updateFrenteIntensidad(int perfil_id, String intensidad) {
        db.execSQL("UPDATE area_frente SET intensidad = '" + intensidad + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }

    public void updateHab1Luz(int perfil_id, String luz) {
        db.execSQL("UPDATE area_hab1 SET luz = '" + luz + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateHab1Rgb(int perfil_id, String rgb) {
        db.execSQL("UPDATE area_hab1 SET rgb = '" + rgb + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateHab1Ventana(int perfil_id, String ventana) {
        db.execSQL("UPDATE area_hab1 SET ventana = '" + ventana + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateHab1Ventilador(int perfil_id, String ventilador) {
        db.execSQL("UPDATE area_hab1 SET ventilador = '" + ventilador + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateHab1Autoventi(int perfil_id, String autoventi) {
        db.execSQL("UPDATE area_hab1 SET autoventi = '" + autoventi + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateHab1TempMin(int perfil_id, String tempmin) {
        db.execSQL("UPDATE area_hab1 SET tempmin = '" + tempmin + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateHab1TempMax(int perfil_id, String tempsmax) {
        db.execSQL("UPDATE area_hab1 SET tempsmax = '" + tempsmax + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }

    public void updateHab2Luz(int perfil_id, String luz) {
        db.execSQL("UPDATE area_hab2 SET luz = '" + luz + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateHab2Rgb(int perfil_id, String rgb) {
        db.execSQL("UPDATE area_hab2 SET rgb = '" + rgb + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateHab2Ventana(int perfil_id, String ventana) {
        db.execSQL("UPDATE area_hab2 SET ventana = '" + ventana + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateHab2Ventilador(int perfil_id, String ventilador) {
        db.execSQL("UPDATE area_hab2 SET ventilador = '" + ventilador + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateHab2Autoventi(int perfil_id, String autoventi) {
        db.execSQL("UPDATE area_hab2 SET autoventi = '" + autoventi + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateHab2TempMin(int perfil_id, String tempmin) {
        db.execSQL("UPDATE area_hab2 SET tempmin = '" + tempmin + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateHab2TempMax(int perfil_id, String tempsmax) {
        db.execSQL("UPDATE area_hab2 SET tempsmax = '" + tempsmax + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }

    public void updatePatioLuzExt(int perfil_id, String luzext) {
        db.execSQL("UPDATE area_patio SET luzext = '" + luzext + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updatePatioSensorExt(int perfil_id, String sensorext) {
        db.execSQL("UPDATE area_patio SET sensorext = '" + sensorext + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updatePatioIntenExt(int perfil_id, String intenext) {
        db.execSQL("UPDATE area_patio SET intenext = '" + intenext + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updatePatioLuzPisci(int perfil_id, String luzpisci) {
        db.execSQL("UPDATE area_patio SET luzpisci = '" + luzpisci + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updatePatioSensorPisci(int perfil_id, String sensorpisci) {
        db.execSQL("UPDATE area_patio SET sensorpisci = '" + sensorpisci + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updatePatioIntenPisci(int perfil_id, String intenpisci) {
        db.execSQL("UPDATE area_patio SET intenpisci = '" + intenpisci + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updatePatioVentana(int perfil_id, String ventana) {
        db.execSQL("UPDATE area_patio SET ventana = '" + ventana + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }

    public void updateSalaPuerta(int perfil_id, String puerta) {
        db.execSQL("UPDATE area_patio SET puerta = '" + puerta + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateSalaVentana(int perfil_id, String ventana) {
        db.execSQL("UPDATE area_patio SET ventana = '" + ventana + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateSalaSensorMov(int perfil_id, String sensormov) {
        db.execSQL("UPDATE area_patio SET sensormov = '" + sensormov + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }

    public void updateAlarmaPuerta(int perfil_id, String puerta) {
        db.execSQL("UPDATE area_patio SET puerta = '" + puerta + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateAlarmaCochera(int perfil_id, String cochera) {
        db.execSQL("UPDATE area_patio SET cochera = '" + cochera + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateAlarmaSala(int perfil_id, String sala) {
        db.execSQL("UPDATE area_patio SET sala = '" + sala + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateAlarmaHab1(int perfil_id, String habitacion1) {
        db.execSQL("UPDATE area_patio SET habitacion1 = '" + habitacion1 + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateAlarmaHab2(int perfil_id, String habitacion2) {
        db.execSQL("UPDATE area_patio SET habitacion2 = '" + habitacion2 + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
    public void updateAlarmaSensor(int perfil_id, String sensor) {
        db.execSQL("UPDATE area_patio SET sensor = '" + sensor + "' WHERE perfil_id = " + String.valueOf(perfil_id));
    }
}
