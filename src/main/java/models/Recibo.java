package models;

import java.util.Objects;

public class Recibo <T> {
    private String periodo; // 202406
    private Empleado empleado; // 12345678
    private T sueldo;

    public Recibo() {
    }

<<<<<<< HEAD
    public Recibo(String periodo, Empleado empleado, T sueldo) {
=======
    public Recibo(String periodo, Empleado empleado) {
>>>>>>> 5fa23b38e330003b9e7f64b5c2563b52b776476b
        this.periodo = periodo;
        this.empleado = empleado;
        this.sueldo = sueldo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public T getSueldo() {
        return sueldo;
    }

    public void setSueldo(T sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recibo<?> recibo = (Recibo<?>) o;
        return Objects.equals(periodo, recibo.periodo) && Objects.equals(empleado, recibo.empleado) && Objects.equals(sueldo, recibo.sueldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(periodo, empleado, sueldo);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n[RECIBO] ").append("\n\n");
        sb.append("PERÍODO: ").append(periodo).append("\n");
        sb.append("EMPLEADO: ").append(empleado.getNombre()).append("\n");

        if (empleado instanceof Jornal) {
            SueldoJornal sueldoJornal = (SueldoJornal) sueldo;
            sb.append("---- SUELDO JORNAL ----\n");
            sb.append("  BÁSICO: $").append(((SueldoJornal) sueldo).getBasico()).append("\n");
            sb.append("  DESCUENTOS: $").append(((SueldoJornal) sueldo).getDescuentos()).append("\n");
            sb.append("  BONIFICACIÓN POR PRODUCCIÓN: $").append(((SueldoJornal) sueldo).getBonificacionProduccion()).append("\n");
        } else if (empleado instanceof Mensual) {
            SueldoMensual sueldoMensual = (SueldoMensual) sueldo;
            sb.append("---- SUELDO MENSUAL ----\n");
            sb.append("  BÁSICO: $").append(((SueldoMensual) sueldo).getBasico()).append("\n");
            sb.append("  DESCUENTOS: $").append(((SueldoMensual) sueldo).getDescuentos()).append("\n");
            sb.append("  ADICIONAL POR FUNCIÓN: $").append(((SueldoMensual) sueldo).getAdicionalFuncion()).append("\n");
        }

        return sb.toString();
    }
}