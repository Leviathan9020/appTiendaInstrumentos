package com.example.apptienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Instrumentos extends AppCompatActivity {

    EditText etcodigoinst,ettipo,etempleado;
    long resp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrumentos);
        getSupportActionBar().hide();

        etcodigoinst = findViewById(R.id.etcodigoinst);
        ettipo = findViewById(R.id.ettipo);
        etempleado = findViewById(R.id.etempleado);

    }
    public void Guardar(View view){
        String  codigo,tipo,empleado;
        codigo = etcodigoinst.getText().toString();
        tipo = ettipo.getText().toString();
        empleado = etempleado.getText().toString();
        if(codigo.isEmpty()|| tipo.isEmpty() || empleado.isEmpty()){
            Toast.makeText(this, "Todos los datos deben ser diligenciados", Toast.LENGTH_SHORT).show();
        }else{
            Conexion admin = new Conexion(this, "TiendaInstrumentos.db",null, 1);
            SQLiteDatabase db = admin.getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("codigoinstrumentos", codigo);
            registro.put("tipo", tipo);
            registro.put("nombreempleado", empleado);
            resp = db.insert("instrumentos",null,registro);
            if(resp > 0){
                Toast.makeText(this, "Instrumento Agregado Correctamente", Toast.LENGTH_SHORT).show();
                etcodigoinst.setText("");
                ettipo.setText("");
                etempleado.setText("");
            }else{
                Toast.makeText(this, "No se Guardo el Instrumento", Toast.LENGTH_SHORT).show();
            }
            db.close();
        }
    }
    public void Consultar(View view){
        String  codigo;
        codigo = etcodigoinst.getText().toString();
        if (codigo.isEmpty()){
            Toast.makeText(this, "Todos los datos son consultados", Toast.LENGTH_SHORT).show();
            etcodigoinst.setText("");
        }else {
            Conexion admin = new Conexion(this, "TiendaInstrumentos.db",null, 1);
            SQLiteDatabase db = admin.getReadableDatabase();
            Cursor fila = db.rawQuery("select * from instrumentos where codigoinstrumentos='"+codigo+"'",null);
            if(fila.moveToNext()){
                ettipo.setText(fila.getString(1));
                etempleado.setText(fila.getString(2));
                Toast.makeText(this, "Ok se encontraron los Datos", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "F no se encontro el Instrumento", Toast.LENGTH_SHORT).show();
            }
            db.close();
        }


    }
}