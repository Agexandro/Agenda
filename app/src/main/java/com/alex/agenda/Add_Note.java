package com.alex.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.alex.agenda.ui.database.DAOAgenda;
import com.alex.agenda.ui.database.MyDB;
import com.alex.agenda.ui.database.Notes;

import java.security.Timestamp;
import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

public class Add_Note extends AppCompatActivity {
    SQLiteDatabase _sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__note);


    }

}
