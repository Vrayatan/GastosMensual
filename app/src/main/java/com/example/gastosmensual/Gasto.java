package com.example.gastosmensual;

import java.text.DateFormat;

public class Gasto {

    private String fecha;
    private int agua;
    private int gas;
    private int electricidad;
    private int transp;
    private int tlcom;

    public Gasto(int codigo, String fecha, int agua, int gas, int electricidad, int transp, int tlcom) {
        this.fecha = fecha;
        this.agua = agua;
        this.gas = gas;
        this.electricidad = electricidad;
        this.transp = transp;
        this.tlcom = tlcom;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAgua() {
        return agua;
    }

    public void setAgua(int agua) {
        this.agua = agua;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getElectricidad() {
        return electricidad;
    }

    public void setElectricidad(int electricidad) {
        this.electricidad = electricidad;
    }

    public int getTransp() {
        return transp;
    }

    public void setTransp(int transp) {
        this.transp = transp;
    }

    public int getTlcom() {
        return tlcom;
    }

    public void setTlcom(int tlcom) {
        this.tlcom = tlcom;
    }
}



