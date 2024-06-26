package services.impl;

import models.Empleado;
import services.EmpleadoService;

import java.util.ArrayList;
import java.util.Scanner;

public class EmpleadoServiceImpl implements EmpleadoService {

    @Override
    public void menuEmpleados() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 6) {
            System.out.println("\n----Menú Empleados----");
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
                    altaEmpleado();
                    break;
                case 2:
                    Thread.sleep(200);
                    bajaEmpleado();
                    break;
                case 3:
                    Thread.sleep(200);
                    modificarEmpleado();
                    break;
                case 4:
                    Thread.sleep(200);
                    verEmpleado();
                    break;
                case 5:
                    Thread.sleep(200);
                    verTodosEmpleados();
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
    public void altaEmpleado() {
    }

    @Override
    public void bajaEmpleado() {
    }

    @Override
    public void modificarEmpleado() {
    }

    @Override
    public void verEmpleado() {
    }

    @Override
    public void verTodosEmpleados() {
    }

}