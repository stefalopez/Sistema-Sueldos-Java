package models;

import enums.Funcion;
import services.EmpleadoService;

public class SueldoMensual extends Sueldo {
    private Double adicionalFuncion;

    public SueldoMensual() {
    }

    public SueldoMensual(Empleado empleado) {
        super(empleado); //Con el constructor super ya se calcula el básico y descuentos
        Funcion funcion = Funcion.nombreFuncion(((Mensual) empleado).getFuncion());
        this.adicionalFuncion = funcion.getValor();
    }

    public Double getAdicionalFuncion() {
        return adicionalFuncion;
    }

    public void setAdicionalFuncion(Double adicionalFuncion) {
        this.adicionalFuncion = adicionalFuncion;
    }
}