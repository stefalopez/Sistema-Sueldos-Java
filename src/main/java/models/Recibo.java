package models;

public class Recibo <T> {
    private String periodo;
    private Empleado empleado;
    private T sueldo;

    public Recibo(String periodo, Empleado empleado) {
        this.periodo = periodo;
        this.empleado = empleado;
        this.sueldo = calcularSueldo();
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

    public T calcularSueldo(){
        return sueldo;
    }

    @Override
    public String toString() {
        return "Recibo{" +
                "periodo='" + periodo + '\'' +
                ", empleado=" + empleado +
                ", sueldo=" + sueldo +
                '}';
    }
}
