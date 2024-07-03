package models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SueldoMensual.class, name = "m"),
        @JsonSubTypes.Type(value = SueldoJornal.class, name = "j")
})

public class Sueldo {
    private Double basico;
    private Double descuentos;

    public Sueldo() {
    }

    public Sueldo(Empleado empleado) {

        if (empleado instanceof Mensual){
            this.basico = ((Mensual) empleado).getBasicoFijo();
        }else if (empleado instanceof Jornal){
            this.basico = ((Jornal) empleado).getHorasTrabajadas() * ((Jornal) empleado).getValorHora();
        }

        this.descuentos = Math.round((this.basico * 0.17) * 100.0) / 100.0;
    }

    public Double getBasico() {
        return basico;
    }

    public void setBasico(Double basico) {
        this.basico = basico;
    }

    public Double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(Double descuentos) {
        this.descuentos = descuentos;
    }
}