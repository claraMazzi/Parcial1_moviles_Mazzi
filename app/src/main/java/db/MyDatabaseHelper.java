package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String TRANSPORTES_TABLE_CREATE = "CREATE TABLE transportes(_id INTEGER PRIMARY KEY AUTOINCREMENT, modelo TEXT, tipo TEXT);";
    public static final String DB_NAME = "transportes";
    private static final int DB_VERSION = 1;

    public  MyDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TRANSPORTES_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE " + DB_NAME);
        onCreate(sqLiteDatabase);
    }

}
