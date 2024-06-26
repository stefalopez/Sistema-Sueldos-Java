package models;

import java.util.Date;

public class Mensual extends Empleado {
    private Double basicoFijo;
    private String funcion;

    public Mensual(Integer id, String nombre, String DNI, Date fechaIngreso, Date fechaEgreso, Double basicoFijo, String funcion) {
        super(id, nombre, DNI, fechaIngreso, fechaEgreso);
        this.basicoFijo = basicoFijo;
        this.funcion = funcion;
    }

    public Double getBasico() {
        return basicoFijo;
    }

    public void setBasico(Double basico) {
        this.basicoFijo = basico;
    }

    @Override
    public String toString() {
        return "Mensual{" +
                "basico=" + basicoFijo +
                '}';
    }
}
