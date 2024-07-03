package services;

import enums.Funcion;
import enums.TipoEmpleado;
import models.Empleado;
import models.Recibo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public interface Utils {

    // Función auxiliar para generar un nuevo ID de forma autoincremental
    static int generarNuevoId(ArrayList<Empleado> empleados) {
        int maxId = 0;
        for (Empleado empleado : empleados) {
            if (empleado.getId() > maxId) {
                maxId = empleado.getId();
            }
        }
        maxId += 1;

        System.out.print("\nID GENERADO: " + maxId + "\n");

        return maxId;
    }

    // Al tener ENUM para el "TipoEmpleado" utilizamos el siguiente método auxiliar para elegir una de las opciones.
    static String validarTipoEmpleado(String opcion) throws IllegalArgumentException {
        List<String> opciones = new ArrayList<>();

        // Recorrer los valores del enum TipoEmpleado y agregar sus nombres a la lista opciones
        for (TipoEmpleado tipo : TipoEmpleado.values()) {
            opciones.add(tipo.name().toLowerCase()); // Agregar el nombre en minúsculas a la lista
        }

        // Convertir la opción a minúsculas para evitar problemas de mayúsculas/minúsculas
        opcion = opcion.trim().toLowerCase();

        // Validar que la opción ingresada esté en la lista de opciones válidas
        if (opciones.contains(opcion)) {
            return opcion;
        } else {
            throw new IllegalArgumentException("Tipo de empleado inválido.");
        }
    }

    static String validarNombre(String nombre) throws Exception {
        Scanner scanner = new Scanner(System.in);

        if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+")) {
            return nombre;
        } else {
            throw new Exception("El nombre solo puede contener letras y espacios.");
        }
    }

    static String validarDni(String dni) throws Exception {

        if (dni.length() > 8 || dni.length() < 7 || !dni.matches("\\d+")) {
            throw new Exception("El formato del dni es incorrecto.");
        }

        return dni;
    }

    // Función auxiliar para convertir String en Date
    static Date validarFecha(String fecha) throws Exception {

        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new Exception("Formato de fecha incorrecto.");
        }

        Empleado.dateFormat.setLenient(false); // Se activa modo NO PERMISIVO, haciendo que si el formato de alguna forma es incorrecto lance una excepción
        try {
            return Empleado.dateFormat.parse(fecha);
        } catch (ParseException e) {
            throw new Exception("Valor de fecha inválido.");
        }
    }

    static double validarBasicoFijo(double basicoFijo) throws Exception {
        try {
            if (basicoFijo < 0) {
                throw new NumberFormatException();
            }

            return basicoFijo;

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Número inválido");
        }
    }

    // Al tener ENUM para la "Función" de los Mensuales, utilizamos el siguiente método auxiliar para elegir una de las opciones.
    static String validarFuncion(String opcion) {
        List<String> opciones = new ArrayList<>();

        // Recorro los valores del enum Funcion y agregar sus nombres a la lista opciones
        for (Funcion funcion : Funcion.values()) {
            opciones.add(funcion.getNombre()); // Agregar el nombre a la lista de opciones sin formatear, la original
        }

        String opcionesFormat = quitarTildes(opcion.trim().toLowerCase());

        // Convertimos la opción a minúsculas para evitar problemas de mayúsculas/minúsculas
        opcion = quitarTildes(opcion.trim().toLowerCase());

        // Valido que la opción ingresada esté en la lista de opciones válidas (sin tildes y sin mayusuculas)
        for (String funcion : opciones) {
            String funcionSinTildes = quitarTildes(funcion.toLowerCase());
            if (funcionSinTildes.equals(opcionesFormat)) {
                // Devuelve el nombre de la función con la primera letra en mayúscula
                return funcion;
            }
        }

        // Si no encuentra ninguna función válida, lanza una excepción
        throw new IllegalArgumentException("Función inválida.");
    }

    //Función auxiliar
    static String quitarTildes(String texto) {
        String textoSinTildes = texto
                .replaceAll("á", "a")
                .replaceAll("é", "e")
                .replaceAll("í", "i")
                .replaceAll("ó", "o")
                .replaceAll("ú", "u");
        return textoSinTildes;
    }

    static Integer validarHorasTrabajadas(Integer horasTrabajadas) throws Exception {
        Scanner scanner = new Scanner(System.in);

        try {
            if (horasTrabajadas < 0 || horasTrabajadas > 23) {
                throw new NumberFormatException();
            }

            return horasTrabajadas;

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Cantidad de horas trabajadas inválida.");
        }
    }

    static Double validarValorHora(Double valorHora) throws Exception {
        Scanner scanner = new Scanner(System.in);

        try {
            valorHora = Double.parseDouble(String.valueOf(valorHora));
            if (valorHora < 0) {
                throw new NumberFormatException();
            }

            return valorHora;

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Número inválido");
        }
    }

    static Double validarCantProduccion(Double cantProduccion) throws Exception {
        Scanner scanner = new Scanner(System.in);

        try {
            cantProduccion = Double.parseDouble(String.valueOf(cantProduccion));

            if (cantProduccion < 0) {
                throw new NumberFormatException();
            }

            return cantProduccion;

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Número inválido");
        }
    }

    // Función auxiliar para no repetir DNi
    static boolean existeDni(String dni, ArrayList<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            if (empleado.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }

    // Función auxiliar para buscar empleado por DNI
    static Empleado buscarEmpleadoPorDNI(String dniBuscar, ArrayList<Empleado> empleados) {
        for (Empleado empleado : empleados) {
            if (empleado.getDni().equals(dniBuscar)) {
                return empleado;
            }
        }
        return null;
    }

    // Función auxiliar para convertir String en Date
    static Date validarPeriodo() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nPERÍODO (MM/yyyy): ");
        String periodo = scanner.nextLine();

        if (!periodo.matches("\\d{2}/\\d{4}")) {
            throw new Exception("Formato de período incorrecto.");
        }

        SimpleDateFormat periodFormat = new SimpleDateFormat("MM/yyyy");
        periodFormat.setLenient(false); // Se activa modo NO PERMISIVO, haciendo que si el formato de alguna forma es incorrecto lance una excepción
        try {
            return periodFormat.parse(periodo);
        } catch (ParseException e) {
            throw new Exception("Valor de período inválido.");
        }
    }

    // Función auxiliar para buscar empleado por DNI
    static Empleado buscarEmpleadoPorDNIHashMap(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado, String dniEmpleado) {
        for (HashMap.Entry<Empleado, ArrayList<Recibo<?>>> entry : recibosPorEmpleado.entrySet()) {
            Empleado empleado = entry.getKey();
            if (empleado.getDni().equals(dniEmpleado)) {
                return empleado;
            }
        }
        return null;
    }

}
