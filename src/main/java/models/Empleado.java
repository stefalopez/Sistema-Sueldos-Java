package models;

import java.util.Date;

public class Empleado {
    private Integer id;
    private String nombre;
    private String DNI;
    private Date fechaIngreso;
    private Date fechaEgreso;

    public Empleado(Integer id, String nombre, String DNI, Date fechaIngreso, Date fechaEgreso) {
        this.id = id;
        this.nombre = nombre;
        this.DNI = DNI;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaEgreso=" + fechaEgreso +
                '}';
    }
}
