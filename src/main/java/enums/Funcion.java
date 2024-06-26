package enums;

public enum Funcion {
    DIRECCION("Direccion"),
    ADMINISTRACION("Administración"),
    RRHH("Recursos Humanos"),
    MARKETING("Marketing"),
    COMERCIO_EXTERIOR("Comercio Exterior"),
    CAPACITADOR("Capacitador"),
    SISTEMAS("Sistemas");

    private String name;

    Funcion(String name) { this.name = name; }

    public String getName() { return name; }
}
