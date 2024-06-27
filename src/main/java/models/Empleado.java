package models;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Empleado {
    private Integer id;
    private String nombre;
    private String dni;
    private Date fechaIngreso;
    private Date fechaEgreso;

    // Definir SimpleDateFormat como estático y final para garantizar una única instancia segura
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Empleado() {
    }

    public Empleado(Integer id, String nombre, String dni, Date fechaIngreso, Date fechaEgreso) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("DNI: ").append(dni).append("\n");
        sb.append("Fecha de Ingreso: ").append(dateFormat.format(fechaIngreso)).append("\n");
        if (fechaEgreso != null) {
            sb.append("Fecha de Egreso: ").append(dateFormat.format(fechaEgreso)).append("\n");
        } else {
            sb.append("Fecha de Egreso: -\n");
        }
        sb.append("--------------------\n");
        return sb.toString();
    }
}
