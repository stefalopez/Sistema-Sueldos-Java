package models;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import enums.TipoEmpleado;
=======
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
>>>>>>> 5fa23b38e330003b9e7f64b5c2563b52b776476b

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
<<<<<<< HEAD
        @JsonSubTypes.Type(value = Mensual.class, name = "m"),
        @JsonSubTypes.Type(value = Jornal.class, name = "j")
})

public abstract class Empleado {
    private String tipoEmpleado;
=======
        @JsonSubTypes.Type(value = Mensual.class, name = "mensual"),
        @JsonSubTypes.Type(value = Jornal.class, name = "jornal")
})

public class Empleado {
>>>>>>> 5fa23b38e330003b9e7f64b5c2563b52b776476b
    private Integer id;
    private String nombre;
    private String dni;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date fechaIngreso;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date fechaEgreso;

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Empleado() {
    }

    public Empleado(String tipoEmpleado, Integer id, String nombre, String dni, Date fechaIngreso, Date fechaEgreso) {
        this.tipoEmpleado = tipoEmpleado;
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo de empleado: ").append(tipoEmpleado).append("\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("DNI: ").append(dni).append("\n");
        sb.append("Fecha de Ingreso: ").append(dateFormat.format(fechaIngreso)).append("\n");
        if (fechaEgreso != null) {
            sb.append("Fecha de Egreso: ").append(dateFormat.format(fechaEgreso)).append("\n");
        } else {
            sb.append("Fecha de Egreso: -\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(id, empleado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
