package models;

import services.EmpleadoService;
import services.ReciboService;
import services.impl.EmpleadoServiceImpl;
import services.impl.ReciboServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    ArrayList<Mensual> empleadosMensuales;
    ArrayList<Jornal> empleadosJornales;
    private EmpleadoService empleadoService;
    private ReciboService reciboService;

    public Sistema() {
        this.empleadoService = new EmpleadoServiceImpl();
        this.reciboService = new ReciboServiceImpl();
        this.empleadosMensuales = new ArrayList<>();
        this.empleadosJornales = new ArrayList<>();
    }

    public void menu() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        Thread.sleep(200);

        while (opcion != 3) {
            System.out.println("\n----Menú Principal----");
            System.out.println("1. Abrir Menú Empleados");
            System.out.println("2. Abrir Menú Recibos de Sueldo");
            System.out.println("3. Salir");
            System.out.print("\nSeleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Thread.sleep(200);
                    empleadoService.menuEmpleados();
                    break;
                case 2:
                    Thread.sleep(200);
                    reciboService.menuRecibos();
                    break;
                case 3:
                    System.out.println("\nSaliendo del sistema...");
                    Thread.sleep(500);
                    break;
                default:
                    System.out.println("\nOpción inválida, volviendo a cargar el menú principal...");
                    Thread.sleep(500);
            }
        }
    }

}
