package com.alex.agenda.ui.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDB extends SQLiteOpenHelper{

    //Se crea la tabla
    private String SCRIPT_DB = "create table notas("+
            "_id integer primary key autoincrement,"+
            "titulo varchar(50) not null,"+
            "descripcion text," +
            "fecha datetime default CURRENT_TIMESTAMP,"+
            "multimedia varchar(100));";

    //Arreglo de nombres de las columnas

    public static final String[] COLUMNS_NAME_AGENDA = {"_id","titulo","descripcion","fecha","multimedia"};

    public  static final String TABLE_NAME_AGENDA= "notas";

    public MyDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP table if exists notas");
        onCreate(db);
    }
}
