package enums;

public enum Funcion {
    DIRECCION("Direccion", 300000.00),
    ADMINISTRACION("Administración", 150000.00),
    RRHH("RRHH", 120000.00),
    MARKETING("Marketing", 100000.00),
    CAPACITADOR("Capacitador", 90000.00),
    SISTEMAS("Sistemas", 160000.00),
    CONTADOR("Contador", 130000.00);

    private String nombre;
    private Double valor;

    Funcion(String nombre, Double valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getValor() {
        return valor;
    }

    public static Funcion nombreFuncion(String nombre) {
        for (Funcion funcion : Funcion.values()) {
            if (funcion.getNombre().equalsIgnoreCase(nombre)) {
                return funcion;
            }
        }
        throw new IllegalArgumentException("No existe una función con el nombre: " + nombre);
    }
}