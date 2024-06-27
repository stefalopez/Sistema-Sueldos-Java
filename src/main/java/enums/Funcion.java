package enums;

public enum Funcion {
    DIRECCION("Direccion"),
    ADMINISTRACION("Administración"),
    RRHH("Recursos Humanos"),
    MARKETING("Marketing"),
    CAPACITADOR("Capacitador"),
    SISTEMAS("Sistemas"),
    CONTADOR("Contador");

    private String name;

    Funcion(String name) { this.name = name; }

    public String getName() { return name; }
}
