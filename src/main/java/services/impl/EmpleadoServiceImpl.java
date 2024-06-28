package services.impl;

import enums.Funcion;
import models.Empleado;
import models.Mensual;
import services.EmpleadoService;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EmpleadoServiceImpl implements EmpleadoService {

    @Override
    public void menuEmpleado(ArrayList<Empleado> empleados) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\n---- MENÚ EMPLEADOS ----");
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
                    altaEmpleado(empleados);
                    break;
                case 2:
                    Thread.sleep(200);
                    bajaEmpleado(empleados);
                    volverAtras();
                    break;
                case 3:
                    Thread.sleep(200);
                    modificarEmpleado(empleados);
                    volverAtras();
                    break;
                case 4:
                    Thread.sleep(200);
                    verEmpleado(empleados);
                    volverAtras();
                    break;
                case 5:
                    Thread.sleep(200);
                    verTodosEmpleados(empleados);
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
    public void altaEmpleado(ArrayList<Empleado> empleados) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\nIngrese los datos del nuevo empleado empleado:");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume la nueva línea pendiente

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("DNI: ");
            String dni = scanner.nextLine();

            System.out.print("Fecha de Ingreso (dd/MM/yyyy): ");
            Date fechaIngreso = obtenerFecha(scanner.nextLine());

            System.out.print("Básico Fijo: ");
            double basicoFijo = scanner.nextDouble();
            scanner.nextLine(); // Consume la nueva línea pendiente

            System.out.print("Función: ");
            String funcion = scanner.nextLine();

            //Empleado nuevoEmpleado = new Empleado(id, nombre, dni, fechaIngreso, null, basicoFijo, funcion);
            //empleados.add(nuevoEmpleado);

            System.out.println("\nEmpleado empleado agregado correctamente.");
        } catch (Exception e) {
            System.out.println("Error al dar de alta empleado: " + e.getMessage());
        }
    }

    @Override
    public void bajaEmpleado(ArrayList<Empleado> empleados) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\nIngrese el DNI del empleado empleado a dar de baja:");
            String dniBuscar = scanner.nextLine();

            // Buscar y eliminar el empleado por DNI
            boolean encontrado = false;
            for (Empleado empleado :empleados) {
                if (empleado.getDni().equals(dniBuscar)) {
                    empleados.remove(empleado);
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                System.out.println("Empleado empleado dado de baja correctamente.");
            } else {
                System.out.println("No se encontró ningún empleado empleado con el DNI especificado.");
            }
        } catch (Exception e) {
            System.out.println("Error al dar de baja empleado empleado: " + e.getMessage());
        }
    }

    @Override
    public void modificarEmpleado(ArrayList<Empleado> empleados) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\nIngrese el DNI del empleado empleado a modificar:");
            String dniBuscar = scanner.nextLine();

            // Buscar el empleado por DNI
            Empleado empleadoEncontrado = buscarEmpleadoPorDNI(dniBuscar,empleados);

            if (empleadoEncontrado != null) {
                // Permitir modificar nombre, fecha de ingreso, básico fijo y función
                System.out.println("Ingrese el nuevo nombre y apellido:");
                String nuevoNombre = scanner.nextLine();
                empleadoEncontrado.setNombre(nuevoNombre);

                System.out.println("Ingrese la nueva fecha de ingreso (dd/MM/yyyy):");
                Date nuevaFechaIngreso = obtenerFecha(scanner.nextLine());
                empleadoEncontrado.setFechaIngreso(nuevaFechaIngreso);

                ///System.out.println("Ingrese el nuevo básico fijo:");
                //double nuevoBasicoFijo = scanner.nextDouble();
                //empleadoEncontrado.setBasicoFijo(nuevoBasicoFijo);
                //scanner.nextLine();

                Funcion funcion = seleccionarFuncion(scanner);

                System.out.println("Empleado empleado modificado correctamente.");
            } else {
                System.out.println("No se encontró ningún empleado empleado con el DNI especificado.");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar empleado empleado: " + e.getMessage());
        }
    }

    @Override
    public void verEmpleado(ArrayList<Empleado> empleados) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("\nIngrese el DNI del empleado empleado a buscar:");
            String dniBuscar = scanner.nextLine();

            // Buscar el empleado por DNI
            Empleado mensualEncontrado = buscarEmpleadoPorDNI(dniBuscar,empleados);

            if (mensualEncontrado != null) {
                System.out.println("\n¡EMPLEADO ENCONTRADO!\n");
                System.out.println(mensualEncontrado);
            } else {
                System.out.println("No se encontró ningún empleado empleado con el DNI especificado.");
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.out.println("Error al buscar empleado empleado: " + e.getMessage());
        }
    }

    @Override
    public void verTodosEmpleados(ArrayList<Empleado> empleados) {
        System.out.println("\n---- Mostrando todos los empleados del sistema ----\n");
        for (Empleado e :empleados){
            System.out.println(e);
        }
    }

    // Al tener ENUM para la función, utilizamos el siguiente método auxiliar para elegir una de las opciones.
    private Funcion seleccionarFuncion(Scanner scanner) {
        System.out.println("Seleccione la función del empleado:");
        for (Funcion f : Funcion.values()) {
            System.out.println(f.ordinal() + 1 + ". " + f.getName());
        }
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Clear newline

        if (opcion < 1 || opcion > Funcion.values().length) {
            throw new IllegalArgumentException("Opción inválida.");
        }

        return Funcion.values()[opcion - 1];
    }

    // Función auxiliar para buscar empleado por DNI
    private Empleado buscarEmpleadoPorDNI(String dniBuscar, ArrayList<Empleado> empleados) {
        for (Empleado empleado : empleados) {
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

    // Función para navegar por el menú más cómodo
    private static void volverAtras() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 1;

        while (opcion == 1){
            System.out.print("Ingrese 0 para volver atrás: ");
            opcion = scanner.nextInt();
        }
    }
}