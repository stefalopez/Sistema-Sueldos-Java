package models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import services.MensualService;
import services.JornalService;
import services.ReciboService;

import services.impl.JornalServiceImpl;
import services.impl.MensualServiceImpl;
import services.impl.ReciboServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    ArrayList<Mensual> mensuales;
    ArrayList<Jornal> jornales;
    private MensualService mensualService;
    private JornalService jornalService;
    private ReciboService reciboService;

    public Sistema() throws IOException {
        this.mensuales = jsonToArrayList("mensuales.json", new TypeReference<ArrayList<Mensual>>(){});
        this.jornales = jsonToArrayList("jornales.json", new TypeReference<ArrayList<Jornal>>(){});
        this.mensualService = new MensualServiceImpl();
        this.jornalService = new JornalServiceImpl();
        this.reciboService = new ReciboServiceImpl();
    }

    /*// Función para combinar empleados mensuales y jornales en un arreglo de Empleado general
    public ArrayList<Empleado> combinarEmpleados() throws IOException {
        ArrayList<Empleado> empleados = new ArrayList<>();

        // Agregar empleados mensuales como Empleado
        for (Mensual mensual : jsonToArrayList("mensuales.json", new TypeReference<ArrayList<Mensual>>(){})) {
            empleados.add(mensual);
        }

        // Agregar empleados jornales como Empleado
        for (Jornal jornal : jsonToArrayList("jornales.json", new TypeReference<ArrayList<Jornal>>(){})) {
            empleados.add(jornal);
        }

        return empleados;
    }*/

    // Función genérica para leer un archivo json y pasarlo a un Arraylist, dependiendo del tipo de objecto que se espera
    public <T> ArrayList<T> jsonToArrayList(String nombreArchivo, TypeReference<ArrayList<T>> typeReference) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(nombreArchivo), typeReference);
    }

    public void menu() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        Thread.sleep(200);

        while (opcion != 3) {
            System.out.println("\n---- MENÚ PRINCIPAL ----");
            System.out.println("1. Mensuales");
            System.out.println("2. Jornales");
            System.out.println("3. Recibos de Sueldo");
            System.out.println("4. Salir");
            System.out.print("\nSeleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Thread.sleep(200);
                    mensualService.menuMensual(mensuales);
                    break;
                case 2:
                    Thread.sleep(200);
                    jornalService.menuJornal(jornales);
                    break;
                case 3:
                    Thread.sleep(200);
                    reciboService.menuRecibos();
                    break;
                case 4:
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
