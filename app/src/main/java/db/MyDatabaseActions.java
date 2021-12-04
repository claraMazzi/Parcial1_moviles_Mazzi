package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import model.Transporte;

public class MyDatabaseActions extends MyDatabaseHelper{

    Context context;

    public MyDatabaseActions(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public void insertarDatos(String modelo, String tipo){
            long id = 0;
            try{
                MyDatabaseHelper dbHelper = new MyDatabaseHelper(context);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null) {
                    // inserto en la base de datos
                    ContentValues cv = new ContentValues();
                    if (tipo != null && modelo != null) {
                        cv.put("modelo", modelo);
                        cv.put("tipo", tipo);
                        db.insert("transportes", null, cv);
                    }

                }
            }
            catch (Exception ex){
                ex.toString();
            }
    }

    public ArrayList<Transporte> mostrarDatos() {
        ArrayList<Transporte> listaTransportes = new ArrayList<Transporte>();
        Transporte transporte;
        Cursor cursorTransporte;
        MyDatabaseHelper dbHelper = new MyDatabaseHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        cursorTransporte = db.rawQuery("SELECT * FROM " + DB_NAME+ " ORDER BY tipo ASC", null);

        if (cursorTransporte.moveToFirst()) {
            do {
                transporte = new Transporte(cursorTransporte.getString(0), cursorTransporte.getString(1));

                listaTransportes.add(transporte);
            } while (cursorTransporte.moveToNext());
        }
        cursorTransporte.close();

        return listaTransportes;
    }

}
