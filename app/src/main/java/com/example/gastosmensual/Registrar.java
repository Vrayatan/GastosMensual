package com.example.gastosmensual;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

public class Registrar extends AppCompatActivity {
    private EditText edAgua, edElectricidad, edGas, edTransp, edTlcom;
    private DatePickerDialog datePickerDialog;
    private Button edFecha;

    private Spinner spFecha;
    // ArrayList<String> listaGastos;
    // ArrayList<Gasto> gastoMes;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        edAgua = findViewById(R.id.tnAgua);
        edElectricidad = findViewById(R.id.tnElectricidad);
        edGas = findViewById(R.id.tnGas);
        edTransp = findViewById(R.id.tnTransporte);
        edTlcom = findViewById(R.id.tnTlcom);

        initDatePicker();
        edFecha = findViewById(R.id.tnFecha);
        edFecha.setText(getTodaysDate());


        //consultarListaGastos();
        //ArrayAdapter<String> adaptador= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaProductos);
        //spProducto.setAdapter(adaptador);
    }

    //Fecha
    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int año, int mes, int dia) {
mes= mes +1;
String fecha = makeDateString (dia, mes, año);
edFecha.setText(fecha);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
    }

    private String makeDateString(int dia, int mes, int año){
return dia + " " + getMonthFormat(mes) + " " + año;
    }

    private String getMonthFormat(int mes){
        if(mes == 1)
            return "JAN";
        if(mes == 2)
            return "FEB";
        if(mes == 3)
            return "MAR";
        if(mes == 4)
            return "APR";
        if(mes == 5)
            return "MAY";
        if(mes == 6)
            return "JUN";
        if(mes == 7)
            return "JUL";
        if(mes == 8)
            return "AUG";
        if(mes == 9)
            return "SEP";
        if(mes == 10)
            return "OCT";
        if(mes == 11)
            return "NOV";
        if(mes == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

    //Database

    public void crearProducto(View v){
        Admindb admin=new Admindb(this, "gastos", null, 1);
        SQLiteDatabase base = admin.getWritableDatabase();

        String fecha= edFecha.getText().toString();
        String agua = edAgua.getText().toString();
        String electricidad =        edElectricidad.getText().toString();
        String gas =        edGas.getText().toString();
        String transp =        edTransp.getText().toString();
        String tlcom =        edTlcom.getText().toString();



        if(!fecha.isEmpty() && !agua.isEmpty() && !electricidad.isEmpty() && !gas.isEmpty() && !transp.isEmpty() && !tlcom.isEmpty()){

            ContentValues crear = new ContentValues();
            crear.put("fecha", fecha);
            crear.put("agua", agua);
            crear.put("electricidad", electricidad);
            crear.put("gas", gas);
            crear.put("transp", transp);
            crear.put("tlcom", tlcom);

            base.insert("gastos", null, crear);
            base.close();
            edFecha.setText("");
            edAgua.setText("");
            edElectricidad.setText("");
            edGas.setText("");
            edTransp.setText("");
            edTlcom.setText("");


            Toast.makeText(this,"Registro Creado", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Debe completar todos los campos", Toast.LENGTH_LONG).show();
        }
    }



    //navegacion
    public void Volver(View v) {
        Intent siguiente = new Intent(this, MainActivity.class);
        startActivity(siguiente);
    }
    public void Historial(View v) {
        Intent siguiente = new Intent(this, Historial.class);
        startActivity(siguiente);
    }


}