package models;

import java.util.Date;

public class Jornal extends Empleado {
    private Integer horasTrabajadas;
    private Double valorHora;
    private Double cantidadProduccion;

    public Jornal() {
    }

    public Jornal(Integer id, String nombre, String DNI, Date fechaIngreso, Date fechaEgreso, Integer horasTrabajadas, Double valorHora, Double cantidadProduccion) {
        super(id, nombre, DNI, fechaIngreso, fechaEgreso);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
        this.cantidadProduccion = cantidadProduccion;
    }

    public Integer getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(Integer horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Double getCantidadProduccion() {
        return cantidadProduccion;
    }

    public void setCantidadProduccion(Double cantidadProduccion) {
        this.cantidadProduccion = cantidadProduccion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Horas trabajadas: ").append(getHorasTrabajadas()).append("\n");
        sb.append("Valor hora: ").append(getValorHora()).append("\n");
        sb.append("Cantidad de producción: ").append(getCantidadProduccion()).append("\n");
        return super.toString() + sb;
    }
}
