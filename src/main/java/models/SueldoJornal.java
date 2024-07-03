package models;

public class SueldoJornal extends Sueldo {
    private Double bonificacionProduccion;

    public SueldoJornal() {
    }

    public SueldoJornal(Empleado empleado) {
        super(empleado); //Con el constructor super ya se calcula el básico y descuentos
        this.bonificacionProduccion = 50000.0; //bonificacionProduccion
    }

    public Double getBonificacionProduccion() {
        return bonificacionProduccion;
    }

    public void setBonificacionProduccion(Double bonificacionProduccion) {
        this.bonificacionProduccion = bonificacionProduccion;
    }
}