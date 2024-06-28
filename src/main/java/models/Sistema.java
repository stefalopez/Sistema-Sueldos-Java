package models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import services.EmpleadoService;
import services.ReciboService;

import services.impl.EmpleadoServiceImpl;
import services.impl.ReciboServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    ArrayList<Empleado> empleados;
    HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado;
    private EmpleadoService empleadoService;
    private ReciboService reciboService;

    //Constructor de la clase Sistema (inicio del sistema)
    public Sistema() throws IOException {

        // Leo los empleadoes, jornales y recibos y los meto adentro de cada arreglo
        this.empleados = jsonToArrayList("empleados.json", new TypeReference<ArrayList<Empleado>>(){});
        ArrayList<Recibo<?>> recibos = jsonToArrayList("recibos.json", new TypeReference<ArrayList<Recibo<?>>>(){});

        // Creamos el HashMap para almacenar los recibos por empleado
        recibosPorEmpleado = new HashMap<>();

        // Inicializamos el HashMap con los empleados empleadoes y jornales
        for (Empleado empleado : empleados) {
            recibosPorEmpleado.put(empleado, new ArrayList<>());
        }

        // Leemos los recibos ya guardados en el ArrayList
        // Y los vamos asignando a los empleados correspondientes
        // (Siempre y cuando esten dados de alta en el sistema)
        for (Recibo<?> recibo : recibos) {
            Empleado empleado = recibo.getEmpleado();
            if (recibosPorEmpleado.containsKey(empleado)) {
                recibosPorEmpleado.get(empleado).add(recibo);
            }
        }

        this.empleadoService = new EmpleadoServiceImpl();
        this.reciboService = new ReciboServiceImpl();
    }

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
            System.out.println("1. Gestión Empleados");
            System.out.println("2. Gestión Recibos de Sueldo");
            System.out.println("3. Salir");
            System.out.print("\nSeleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Thread.sleep(200);
                    empleadoService.menuEmpleado(empleados);
                    break;
                case 2:
                    Thread.sleep(200);
                    reciboService.menuRecibos(recibosPorEmpleado);
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
