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
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 5fa23b38e330003b9e7f64b5c2563b52b776476b
import java.util.Scanner;

import static services.Utils.*;

public class Sistema {
    ArrayList<Empleado> empleados;
<<<<<<< HEAD
    HashMap<Empleado, ArrayList<Recibo<Sueldo>>> recibosPorEmpleado;
=======
    HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado;
>>>>>>> 5fa23b38e330003b9e7f64b5c2563b52b776476b
    private EmpleadoService empleadoService;
    private ReciboService reciboService;

    //Constructor de la clase Sistema (inicio del sistema)
<<<<<<< HEAD
    public Sistema() throws Exception {

        try{
            // Leo los empleados mensuales, jornales y recibos y los meto adentro de cada arreglo
            this.empleados = jsonToArrayList("empleados.json", new TypeReference<ArrayList<Empleado>>(){});
            ArrayList<Recibo<Sueldo>> recibos = jsonToArrayList("recibos.json", new TypeReference<ArrayList<Recibo<Sueldo>>>(){});

            // Inicialización del HashMap para almacenar recibos por empleado
            recibosPorEmpleado = new HashMap<>();

            // Inicializamos el HashMap con las claves (empleados) y valores (arraylist vacíos)
            for (Empleado empleado : empleados) {
                recibosPorEmpleado.put(empleado, new ArrayList<>());
            }

            // Leemos los recibos ya guardados en el ArrayList
            // Y los vamos asignando a los empleados correspondientes
            // (Siempre y cuando esten dados de alta en el sistema)
            for (Recibo<Sueldo> recibo : recibos) {
                Empleado empleado = recibo.getEmpleado();
                if (recibosPorEmpleado.containsKey(empleado)) {
                    recibosPorEmpleado.get(empleado).add(recibo);
                }
            }

            this.empleadoService = new EmpleadoServiceImpl();
            this.reciboService = new ReciboServiceImpl();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    // Función genérica para leer un archivo json y pasarlo a un Arraylist, dependiendo del tipo de objecto que se espera (empleados o recibos)
    //public <T> ArrayList<T> jsonToArrayList(String nombreArchivo, TypeReference<ArrayList<T>> typeReference) throws IOException {
    //    ObjectMapper mapper = new ObjectMapper();
     //   return mapper.readValue(new File(nombreArchivo), typeReference);
    //}

    public <T> ArrayList<T> jsonToArrayList(String nombreArchivo, TypeReference<ArrayList<T>> typeReference) throws Exception {
=======
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
>>>>>>> 5fa23b38e330003b9e7f64b5c2563b52b776476b
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<T> lista = mapper.readValue(new File(nombreArchivo), typeReference);

        // Validar cada elemento de la lista
        //for (T elemento : lista) {
        //    if (elemento instanceof Empleado) {
        //        validarDatosEmpleado((Empleado) elemento);
        //    }
        //}

        return lista;
    }

    public void validarDatosEmpleado(Empleado empleado) throws Exception {
       validarTipoEmpleado(empleado.getTipoEmpleado());
       validarNombre(empleado.getNombre());
       validarDni(empleado.getDni());

       //Trabajar conversiones de Date a String para poder validar (queda como objetivo a desarrollar)
       //validarFecha(String.valueOf(empleado.getFechaIngreso()));
       //validarFecha(String.valueOf(empleado.getFechaEgreso()));

       if (empleado instanceof Mensual){
           validarBasicoFijo(((Mensual) empleado).getBasicoFijo());
           validarFuncion(((Mensual) empleado).getFuncion());
       }else if (empleado instanceof Jornal){
            validarHorasTrabajadas(((Jornal) empleado).getHorasTrabajadas());
            validarValorHora(((Jornal) empleado).getValorHora());
            validarCantProduccion(((Jornal) empleado).getCantidadProduccion());
       }
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
<<<<<<< HEAD
=======
                    System.out.println("\nSaliendo del sistema...");
>>>>>>> 5fa23b38e330003b9e7f64b5c2563b52b776476b
                    Thread.sleep(500);
                    break;
                default:
                    System.out.println("\nOpción inválida, volviendo a cargar el menú principal...");
                    Thread.sleep(500);
            }
        }
    }

    public void guardarDatos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("empleados.json"), empleados);
            ArrayList<Recibo<?>> todosRecibos = new ArrayList<>();
            for (ArrayList<Recibo<Sueldo>> recibos : recibosPorEmpleado.values()) {
                todosRecibos.addAll(recibos);
            }
            objectMapper.writeValue(new File("recibos.json"), todosRecibos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
