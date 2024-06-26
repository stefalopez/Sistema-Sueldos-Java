package services.impl;

import models.Empleado;
import models.Recibo;
import services.ReciboService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReciboServiceImpl implements ReciboService {

    @Override
    public void menuRecibos() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n----Menú Recibos de Sueldo----");
            System.out.println("1. Generar");
            System.out.println("2. Eliminar");
            System.out.println("3. Ver uno");
            System.out.println("4. Ver todos");
            System.out.println("5. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Thread.sleep(200);
                    generarRecibo();
                    break;
                case 2:
                    Thread.sleep(200);
                    eliminarRecibo();
                    break;
                case 3:
                    verRecibo();
                    Thread.sleep(200);
                    break;
                case 4:
                    Thread.sleep(200);
                    verTodosRecibos();
                    break;
                case 5:
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
    public void generarRecibo() {
    }

    @Override
    public void eliminarRecibo() {
    }

    @Override
    public void verRecibo() {
    }

    @Override
    public void verTodosRecibos() {
    }

}