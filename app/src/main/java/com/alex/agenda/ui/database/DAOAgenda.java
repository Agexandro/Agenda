package com.alex.agenda.ui.database;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DAOAgenda {

    SQLiteDatabase _sqLiteDatabase;
    Context context;

    public DAOAgenda(Context context){
        this.context = context;
        _sqLiteDatabase = new MyDB(context, "notas",null,1).getWritableDatabase();
    }
    public long Insert(Notes notes){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDB.COLUMNS_NAME_AGENDA[1],notes.get_titulo());
        contentValues.put(MyDB.COLUMNS_NAME_AGENDA[2],notes.get_descripcion());
        contentValues.put(MyDB.COLUMNS_NAME_AGENDA[4],notes.get_multimedia());
        return _sqLiteDatabase.insert(MyDB.TABLE_NAME_AGENDA,null,contentValues);
    }

    public void Delete(String titulo){
        String args[]=new String[]{titulo};
        _sqLiteDatabase.delete(MyDB.TABLE_NAME_AGENDA,"titulo = ?", args);
    }

    public ArrayList<Notes> getAll(){
        ArrayList<Notes> lst = null;
        Cursor c = _sqLiteDatabase.query(MyDB.TABLE_NAME_AGENDA, MyDB.COLUMNS_NAME_AGENDA,
                null,null,null,null,null);

        if(c.moveToFirst()){
            lst = new ArrayList<Notes>();
            do{
                Notes notes = new Notes(c.getString(1),c.getString(2),c.getString(3),c.getString(4));
            lst.add(notes);
            }while (c.moveToNext());
        }
        return lst;
    }

}
