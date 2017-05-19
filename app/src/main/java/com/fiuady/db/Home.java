package com.fiuady.db;

import com.fiuady.db.HomeDbSchema.*;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;

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
}
