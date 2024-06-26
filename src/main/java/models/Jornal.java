package models;

import java.util.Date;

public class Jornal extends Empleado {
    private Integer horasTrabajadas;
    private Double valorHora;

    public Jornal(Integer id, String nombre, String DNI, Date fechaIngreso, Date fechaEgreso) {
        super(id, nombre, DNI, fechaIngreso, fechaEgreso);
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
}
