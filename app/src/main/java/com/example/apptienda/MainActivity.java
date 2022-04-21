package com.example.apptienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


    }
    //declarar los eventos los metodos para ir a las otras listas

    public void irfactura(View view){
        Intent objfactura = new Intent(this,Factura.class);
        startActivity(objfactura);
    }
    public void irinstrumentos(View view){
        Intent objinstrumento = new Intent(this,Instrumentos.class);
        startActivity(objinstrumento);
    }
}