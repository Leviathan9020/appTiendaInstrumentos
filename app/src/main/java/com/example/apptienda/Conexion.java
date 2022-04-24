package com.example.apptienda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexion extends SQLiteOpenHelper {

    public Conexion(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table instrumentos(codigoinstrumentos text primary key,tipo text not null, nombreempleado text not null, activo text not null default'si')");
        sqLiteDatabase.execSQL("create table factura(codigo text primary key, fecha text not null, nombre_cliente text not null, valor text not null, activo text not null default'si')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE instrumentos");{
    onCreate(sqLiteDatabase);
        }
        sqLiteDatabase.execSQL("DROP TABLE factura");{
            onCreate(sqLiteDatabase);
        }
    }
}

