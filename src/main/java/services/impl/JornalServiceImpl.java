package services.impl;

import models.Empleado;
import models.Jornal;
import services.JornalService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class JornalServiceImpl implements JornalService {

    @Override
    public void menuJornal(ArrayList<Jornal> jornales) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\n---- MENÚ JORNALES ----");
            System.out.println("1. Alta");
            System.out.println("2. Baja");
            System.out.println("3. Modificación");
            System.out.println("4. Ver uno");
            System.out.println("5. Ver todos");
            System.out.println("6. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Thread.sleep(200);
                    altaJornal(jornales);
                    volverAtras();
                    break;
                case 2:
                    Thread.sleep(200);
                    bajaJornal(jornales);
                    volverAtras();
                    break;
                case 3:
                    Thread.sleep(200);
                    modificarJornal(jornales);
                    volverAtras();
                    break;
                case 4:
                    Thread.sleep(200);
                    verJornal(jornales);
                    volverAtras();
                    break;
                case 5:
                    Thread.sleep(200);
                    verTodosJornal(jornales);
                    volverAtras();
                    break;
                case 6:
                    System.out.println("\nVolviendo al menú principal...");
                    Thread.sleep(500);
                    return;
                default:
                    System.out.println("\nOpción inválida, volviendo a cargar menú...");
                    Thread.sleep(500);
            }
        }
    }

    @Override
    public void altaJornal(ArrayList<Jornal> jornales) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\nIngrese los datos del nuevo empleado jornal:");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume la nueva línea pendiente

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("DNI: ");
            String dni = scanner.nextLine();

            System.out.print("Fecha de Ingreso (dd/MM/yyyy): ");
            Date fechaIngreso = obtenerFecha(scanner.nextLine());

            /*System.out.print("Básico Fijo: ");
            double basicoFijo = scanner.nextDouble();
            scanner.nextLine(); // Consume la nueva línea pendiente

            System.out.print("Función: ");
            String funcion = scanner.nextLine();

            Jornal nuevoEmpleado = new Jornal(id, nombre, dni, fechaIngreso, null, basicoFijo, funcion);
            jornales.add(nuevoEmpleado);*/

            System.out.println("\nEmpleado jornal agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al dar de alta empleado: " + e.getMessage());
        }
    }

    @Override
    public void bajaJornal(ArrayList<Jornal> jornales) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\nIngrese el DNI del empleado jornal a dar de baja:");
            String dniBuscar = scanner.nextLine();

            // Buscar y eliminar el empleado por DNI
            boolean encontrado = false;
            for (Jornal jornal : jornales) {
                if (jornal.getDni().equals(dniBuscar)) {
                    jornales.remove(jornal);
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                System.out.println("Empleado jornal dado de baja correctamente.");
            } else {
                System.out.println("No se encontró ningún empleado jornal con el DNI especificado.");
            }
        } catch (Exception e) {
            System.out.println("Error al dar de baja empleado jornal: " + e.getMessage());
        }
    }

    @Override
    public void modificarJornal(ArrayList<Jornal> jornales) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\nIngrese el DNI del empleado jornal a modificar:");
            String dniBuscar = scanner.nextLine();

            // Buscar el empleado por DNI
            Jornal jornalEncontrado = buscarJornalPorDNI(dniBuscar, jornales);

            if (jornalEncontrado != null) {
                /*// Permitir modificar nombre, fecha de ingreso, básico fijo y función
                System.out.println("Ingrese el nuevo nombre del empleado jornal:");
                String nuevoNombre = scanner.nextLine();
                jornalEncontrado.setNombre(nuevoNombre);

                System.out.println("Ingrese la nueva fecha de ingreso del empleado jornal (dd/MM/yyyy):");
                Date nuevaFechaIngreso = obtenerFecha(scanner.nextLine());
                jornalEncontrado.setFechaIngreso(nuevaFechaIngreso);

                System.out.println("Ingrese el nuevo básico fijo del empleado jornal:");
                double nuevoBasicoFijo = scanner.nextDouble();
                jornalEncontrado.setBasicoFijo(nuevoBasicoFijo);
                scanner.nextLine();

                System.out.println("Ingrese la nueva función del empleado jornal:");
                String nuevaFuncion = scanner.nextLine();
                jornalEncontrado.setFuncion(nuevaFuncion);*/

                System.out.println("Empleado jornal modificado correctamente.");
            } else {
                System.out.println("No se encontró ningún empleado jornal con el DNI especificado.");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar empleado jornal: " + e.getMessage());
        }
    }

    @Override
    public void verJornal(ArrayList<Jornal> jornales) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\nIngrese el DNI del empleado jornal a buscar:");
            String dniBuscar = scanner.nextLine();

            // Buscar el empleado por DNI
            Jornal jornalEncontrado = buscarJornalPorDNI(dniBuscar, jornales);

            if (jornalEncontrado != null) {
                System.out.println("\n¡Empleado jornal encontrado!");
                System.out.println(jornalEncontrado);
            } else {
                System.out.println("No se encontró ningún empleado jornal con el DNI especificado. Volviendo al menú...");
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar empleado jornal: " + e.getMessage());
        }
    }

    @Override
    public void verTodosJornal(ArrayList<Jornal> jornales) {
        System.out.println("\n---- Mostrando todos los empleados jornales del sistema ----\n");
        for (Jornal m : jornales){
            System.out.println(m);
        }
    }

    // Función auxiliar para buscar empleado por DNI
    private Jornal buscarJornalPorDNI(String dniBuscar, ArrayList<Jornal> empleados) {
        for (Jornal empleado : empleados) {
            if (empleado.getDni().equals(dniBuscar)) {
                return empleado;
            }
        }
        return null;
    }

    // Función auxiliar para convertir String en Date
    private Date obtenerFecha(String fechaString) throws Exception {
        try {
            return Empleado.dateFormat.parse(fechaString);
        } catch (Exception e) {
            throw new Exception("Formato de fecha incorrecto. Use el formato dd/MM/yyyy.");
        }
    }

    private static void volverAtras() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 1;

        while (opcion == 1){
            System.out.print("Ingrese 0 para volver atrás: ");
            opcion = scanner.nextInt();
        }
    }
}