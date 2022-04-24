package com.example.apptienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Factura extends AppCompatActivity {

    EditText etcodigo,etfecha,etnombrec,etvalor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);
        getSupportActionBar().hide();

        etcodigo = findViewById(R.id.etcodigo);
        etfecha = findViewById(R.id.etfecha);
        etnombrec = findViewById(R.id.etnombrec);
        etvalor = findViewById(R.id.etvalor);
    }

    public void consultar_factura(View view){
        String  codigo;
        codigo = etcodigo.getText().toString();
        if(codigo.isEmpty()){
            Toast.makeText(this, "Debes ingresar un codigo!", Toast.LENGTH_SHORT).show();
            etcodigo.requestFocus();
        }
        else{
            Conexion admin = new Conexion(this, "TiendaInstrumentos2.db",null, 1);
            SQLiteDatabase bd = admin.getReadableDatabase();
            Cursor fila = bd.rawQuery("select * from factura where codigo='"+codigo+"'",null);
            if(fila.moveToNext()){
                etfecha.setText(fila.getString(1));
                etnombrec.setText(fila.getString(2));
                etvalor.setText(fila.getString(3));
                Toast.makeText(this, "Ok se encontraron los Datos", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "F no se encontro la factura", Toast.LENGTH_SHORT).show();
            }
            bd.close();
        }
    }
    public void regresar (View view){
        Intent regresar = new Intent(this,MainActivity.class);
        startActivity(regresar);
    }
}