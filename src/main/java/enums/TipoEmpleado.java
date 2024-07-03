package enums;

public enum TipoEmpleado {
    MENSUAL("Mensual"),
    JORNAL("Jornal");

    private String name;

    TipoEmpleado(String name) { this.name = name; }

    public String getName() { return name; }
}
