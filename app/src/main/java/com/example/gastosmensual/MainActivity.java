package com.example.gastosmensual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Funciones de navegación
    public void Registrar(View v) {
        Intent siguiente = new Intent(this, Registrar.class);
        startActivity(siguiente);
    }
    public void Comparar(View v) {
        Intent siguiente = new Intent(this, Comparar.class);
        startActivity(siguiente);
    }
    public void Historial(View v) {
        Intent siguiente = new Intent(this, Historial.class);
        startActivity(siguiente);
    }


}