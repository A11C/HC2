package com.fiuady.db;

import com.fiuady.db.HomeDbSchema.*;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

class ClassCursor extends CursorWrapper{
    public ClassCursor(Cursor cursor){
        super(cursor);
    }

    public Cuenta getCuenta(){
        Cursor cursor  = getWrappedCursor();
        return new Cuenta(cursor.getInt(cursor.getColumnIndex(CuentasTable.Columns.ID)),
                cursor.getString(cursor.getColumnIndex(CuentasTable.Columns.USUARIO)),
                cursor.getString(cursor.getColumnIndex(CuentasTable.Columns.CONTRASEÑA)));
    }

    public Perfiles getPerfil(){
        Cursor cursor  = getWrappedCursor();
        return new Perfiles(cursor.getInt(cursor.getColumnIndex(PerfilesTable.Columns.ID)),
                cursor.getString(cursor.getColumnIndex(PerfilesTable.Columns.USUARIO_ID)),
                cursor.getString(cursor.getColumnIndex(PerfilesTable.Columns.DESCRIPCION)));
    }

    public Pin_puerta getPin_puerta(){
        Cursor cursor  = getWrappedCursor();
        return new Pin_puerta(cursor.getInt(cursor.getColumnIndex(Pin_PuertaTable.Columns.ID)),
                cursor.getString(cursor.getColumnIndex(Pin_PuertaTable.Columns.USUARIO_ID)),
                cursor.getString(cursor.getColumnIndex(Pin_PuertaTable.Columns.PIN)));
    }

    public Area_cochera getCochera(){
        Cursor cursor  = getWrappedCursor();
        return new Area_cochera(cursor.getInt(cursor.getColumnIndex(Area_CocheraTable.Columns.ID)),
                cursor.getString(cursor.getColumnIndex(Area_CocheraTable.Columns.PERFIL_ID)),
                cursor.getString(cursor.getColumnIndex(Area_CocheraTable.Columns.PUERTA)));
    }

    public Area_frente getFrente(){
        Cursor cursor  = getWrappedCursor();
        return new Area_frente(cursor.getInt(cursor.getColumnIndex(Area_FrenteTable.Columns.ID)),
                cursor.getString(cursor.getColumnIndex(Area_FrenteTable.Columns.PERFIL_ID)),
                cursor.getString(cursor.getColumnIndex(Area_FrenteTable.Columns.PUERTA)),
                cursor.getString(cursor.getColumnIndex(Area_FrenteTable.Columns.LUZ)),
                cursor.getString(cursor.getColumnIndex(Area_FrenteTable.Columns.SENSOR)),
                cursor.getString(cursor.getColumnIndex(Area_FrenteTable.Columns.INTENSIDAD)));
    }

    public Area_hab1 getHabitacion1(){
        Cursor cursor  = getWrappedCursor();
        return new Area_hab1(cursor.getInt(cursor.getColumnIndex(Area_Hab1Table.Columns.ID)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.PERFIL_ID)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.LUZ)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.LUZR)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.LUZG)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.LUZB)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.VENTANA)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.VENTILADOR)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.AUTOVENTI)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.TEMPMIN)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.TEMPMAX)),
                cursor.getString(cursor.getColumnIndex(Area_Hab1Table.Columns.TEMPACT)));
    }

    public Area_hab2 getHabitacion2(){
        Cursor cursor  = getWrappedCursor();
        return new Area_hab2(cursor.getInt(cursor.getColumnIndex(Area_Hab2Table.Columns.ID)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.PERFIL_ID)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.LUZ)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.LUZR)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.LUZG)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.LUZB)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.VENTANA)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.VENTILADOR)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.AUTOVENTI)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.TEMPMIN)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.TEMPMAX)),
                cursor.getString(cursor.getColumnIndex(Area_Hab2Table.Columns.TEMPACT)));
    }

    public Area_patio getPatio(){
        Cursor cursor  = getWrappedCursor();
        return new Area_patio(cursor.getInt(cursor.getColumnIndex(Area_PatioTable.Columns.ID)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.PERFIL_ID)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.LUZEXT)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.SENSOREXT)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.INTENEXT)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.LUZPISCI)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.SENSORPISCI)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.INTENPISCI)),
                cursor.getString(cursor.getColumnIndex(Area_PatioTable.Columns.VENTANA)));
    }

    public Area_sala getSala(){
        Cursor cursor  = getWrappedCursor();
        return new Area_sala(cursor.getInt(cursor.getColumnIndex(Area_SalaTable.Columns.ID)),
                cursor.getString(cursor.getColumnIndex(Area_SalaTable.Columns.PERFIL_ID)),
                cursor.getString(cursor.getColumnIndex(Area_SalaTable.Columns.PUERTA)),
                cursor.getString(cursor.getColumnIndex(Area_SalaTable.Columns.VENTANA)),
                cursor.getString(cursor.getColumnIndex(Area_SalaTable.Columns.SENSORMOV)));
    }
}

public final class Home {

    private HomeHelper homeHelper;
    private SQLiteDatabase db;

    public Home(Context context){
        homeHelper = new HomeHelper (context);
        db = homeHelper.getWritableDatabase();
    }

    public int checkCuenta(String usuario, String contraseña){
        int count = 0;
        String query = "SELECT COUNT(*) FROM cuentas WHERE usuario = '" + usuario + "' AND contraseña = '"+ contraseña +"'";
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

    public List<Perfiles> getAllPerfiles() {
        ArrayList<Perfiles> list = new ArrayList<Perfiles>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM perfiles ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getPerfil());
        }
        cursor.close();

        return list;
    }

    public List<Pin_puerta> getAllPines() {
        ArrayList<Pin_puerta> list = new ArrayList<Pin_puerta>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM pin_puerta ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getPin_puerta());
        }
        cursor.close();

        return list;
    }

    public List<Area_cochera> getAllCochera() {
        ArrayList<Area_cochera> list = new ArrayList<Area_cochera>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM area_cochera ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getCochera());
        }
        cursor.close();

        return list;
    }

    public List<Area_frente> getAllFrente() {
        ArrayList<Area_frente> list = new ArrayList<Area_frente>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM area_frente ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getFrente());
        }
        cursor.close();

        return list;
    }

    public List<Area_hab1> getAllHabitacion1() {
        ArrayList<Area_hab1> list = new ArrayList<Area_hab1>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM area_hab1 ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getHabitacion1());
        }
        cursor.close();

        return list;
    }

    public List<Area_hab2> getAllHabitacion2() {
        ArrayList<Area_hab2> list = new ArrayList<Area_hab2>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM area_hab2 ORDER BY id ASC;", null));
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

    public List<Area_sala> getAllSala() {
        ArrayList<Area_sala> list = new ArrayList<Area_sala>();

        ClassCursor cursor = new ClassCursor(db.rawQuery("SELECT * FROM area_sala ORDER BY id ASC;", null));
        while (cursor.moveToNext()) {
            list.add(cursor.getSala());
        }
        cursor.close();

        return list;
    }


}
