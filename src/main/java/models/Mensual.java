package models;

import java.util.Date;

public class Mensual extends Empleado {
    private Double basicoFijo;
    private String funcion;

    public Mensual() {
    }

    public Mensual(Integer id, String nombre, String dni, Date fechaIngreso, Date fechaEgreso, Double basicoFijo, String funcion) {
        super(id, nombre, dni, fechaIngreso, fechaEgreso);
        this.basicoFijo = basicoFijo;
        this.funcion = funcion;
    }

    public Double getBasicoFijo() {
        return basicoFijo;
    }

    public void setBasicoFijo(Double basicoFijo) {
        this.basicoFijo = basicoFijo;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
