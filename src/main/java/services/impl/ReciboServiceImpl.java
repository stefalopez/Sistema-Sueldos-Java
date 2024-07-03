package services.impl;
import models.*;
import services.ReciboService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import static services.Utils.*;

public class ReciboServiceImpl implements ReciboService {

    @Override
<<<<<<< HEAD
    public void menuRecibos(HashMap<Empleado, ArrayList<Recibo<Sueldo>>> recibosPorEmpleado) throws InterruptedException {
=======
    public void menuRecibos(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado) throws InterruptedException {
>>>>>>> 5fa23b38e330003b9e7f64b5c2563b52b776476b
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            System.out.println("\n----MENÚ RECIBOS DE SUELDO----");
            System.out.println("1. Generar");
            System.out.println("2. Eliminar");
<<<<<<< HEAD
            System.out.println("3. Ver un recibo específico");
=======
            System.out.println("3. Ver uno");
>>>>>>> 5fa23b38e330003b9e7f64b5c2563b52b776476b
            System.out.println("4. Ver todos los recibos de un empleado");
            System.out.println("5. Volver al menú principal");
            System.out.print("\nSeleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Thread.sleep(200);
<<<<<<< HEAD
                    System.out.println("\n---- GENERACIÓN DE RECIBO ----");
=======
>>>>>>> 5fa23b38e330003b9e7f64b5c2563b52b776476b
                    generarRecibo(recibosPorEmpleado);
                    break;
                case 2:
                    Thread.sleep(200);
<<<<<<< HEAD
                    System.out.println("\n---- ELIMINACIÓN DE RECIBO ----");
                    eliminarRecibo(recibosPorEmpleado);
                    break;
                case 3:
                    System.out.println("\n---- VISUALIZACIÓN DE RECIBO ----");
=======
                    eliminarRecibo(recibosPorEmpleado);
                    break;
                case 3:
>>>>>>> 5fa23b38e330003b9e7f64b5c2563b52b776476b
                    verRecibo(recibosPorEmpleado);
                    Thread.sleep(200);
                    break;
                case 4:
                    System.out.println("\n---- LISTADO DE RECIBOS ----");
                    Thread.sleep(200);
                    verTodosRecibos(recibosPorEmpleado);
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
<<<<<<< HEAD
    public void generarRecibo(HashMap<Empleado, ArrayList<Recibo<Sueldo>>> recibosPorEmpleado) {
        try{
            Scanner scanner = new Scanner(System.in);

            System.out.print("\nDNI: ");
            String dni = scanner.nextLine();
            dni = validarDni(dni);

            Empleado empleado = buscarEmpleadoPorDNIHashMap(recibosPorEmpleado, dni);

            if (empleado == null){
                throw new Exception("Empleado no encontrado.");
            }

            if (empleado.getFechaEgreso() != null){
                throw new Exception("El empleado seleccionado ya no forma parte de la empresa.");
            }

            SimpleDateFormat formatoPeriodo = new SimpleDateFormat("MM/yyyy");
            String periodo = formatoPeriodo.format(validarPeriodo());

            //Creamos instancia genérica de recibo y en base al empleado le pasamos el tipo de sueldo
            Recibo<Sueldo> nuevoRecibo;
            if (empleado instanceof Mensual){
                Sueldo sueldo = new SueldoMensual(empleado);
                nuevoRecibo = new Recibo<Sueldo>(periodo, empleado, sueldo);
            }else{
                Sueldo sueldo = new SueldoJornal(empleado);
                nuevoRecibo = new Recibo<Sueldo>(periodo, empleado, sueldo);
            }

            // Buscamos los recibos del empleado para agregar el nuevo, pero si es el PRIMER recibo, le creamos el arraylist en el VALOR del hashmap
            ArrayList<Recibo<Sueldo>> recibosEmpleado = recibosPorEmpleado.get(empleado);
            if (recibosEmpleado == null) {
                recibosEmpleado = new ArrayList<>();
                recibosPorEmpleado.put(empleado, recibosEmpleado);
            }

            // Agregar el nuevo recibo a la lista
            recibosEmpleado.add(nuevoRecibo);

            System.out.println("\n¡RECIBO GENERADO CON ÉXITO!");

        }catch (Exception e){
            System.out.println("\nERROR: " + e.getMessage());
        }

    }

    @Override
    public void eliminarRecibo(HashMap<Empleado, ArrayList<Recibo<Sueldo>>> recibosPorEmpleado) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("\nDNI: ");
            String dni = scanner.nextLine();
            dni = validarDni(dni);

            //Usamos la función que tenemos ya que si lo encuentra necesitamos el empleado. Descartamos el containsKey para la verificación
            Empleado empleado = buscarEmpleadoPorDNIHashMap(recibosPorEmpleado, dni);

            if (empleado == null){
                throw new Exception("Empleado no encontrado.");
            }

            ArrayList<Recibo<Sueldo>> recibos = recibosPorEmpleado.get(empleado);
            mostrarRecibos(recibos);

            System.out.print("\nIngrese el N° de recibo a eliminar: ");

            try {
                int nroRecibo = scanner.nextInt();

                if (nroRecibo > 0 && nroRecibo <= recibos.size()) {
                    recibos.remove(nroRecibo - 1);
                    System.out.println("\n¡RECIBO ELIMINADO CON ÉXITO!");
                }else {
                    throw new Exception("Opción inválida");
                }

            }catch (Exception e){
                throw new Exception("Opción inválida.");
            }

        }catch (Exception e){
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    @Override
    public void verRecibo(HashMap<Empleado, ArrayList<Recibo<Sueldo>>> recibosPorEmpleado) {
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.print("\nDNI: ");
            String dni = scanner.nextLine();
            dni = validarDni(dni);

            SimpleDateFormat formatoPeriodo = new SimpleDateFormat("MM/yyyy");
            String periodo = formatoPeriodo.format(validarPeriodo());

            // Se busca al empleado y mostramos el recibo específico
            Empleado empleado = buscarEmpleadoPorDNIHashMap(recibosPorEmpleado, dni);

            if (empleado == null){
                throw new Exception("Empleado no encontrado.");
            }

            ArrayList<Recibo<Sueldo>> recibos = recibosPorEmpleado.get(empleado);

            for (Recibo<Sueldo> recibo : recibos) {
                if (recibo.getPeriodo().equals(periodo)) {
                    System.out.println(recibo);
                }
            }

        } catch (Exception e){
            System.out.println("\nERROR: " + e.getMessage());
        }

    }

    @Override
    public void verTodosRecibos(HashMap<Empleado, ArrayList<Recibo<Sueldo>>> recibosPorEmpleado) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("\nDNI: ");
            String dni = scanner.nextLine();
            dni = validarDni(dni);

            for (HashMap.Entry<Empleado, ArrayList<Recibo<Sueldo>>> entry : recibosPorEmpleado.entrySet()) {
                Empleado empleado = entry.getKey();
                ArrayList<Recibo<Sueldo>> recibos = entry.getValue();

                if (empleado.getDni().equals(dni)) {
                    mostrarRecibos(recibos);
                }
            }
        } catch (Exception e){
            System.out.println("\nERROR: " + e.getMessage());
        }
    }

    // Función auxiliar para mostrar recibos
    private void mostrarRecibos(ArrayList<Recibo<Sueldo>> recibos) throws Exception {
        if (recibos != null && !recibos.isEmpty()) {
            System.out.println("\n");
            int contador = 1;
            for (Recibo<Sueldo> recibo : recibos) {
                System.out.println("["+contador+"]\n" + recibo);
                contador++;
            }
        } else {
            throw new Exception("No hay recibos de sueldos para mostrar.");
        }
    }

    // Función auxiliar para buscar empleado por DNI
    private Empleado buscarEmpleadoPorDNIHashMap(HashMap<Empleado, ArrayList<Recibo<Sueldo>>> recibosPorEmpleado, String dniEmpleado) {
        for (HashMap.Entry<Empleado, ArrayList<Recibo<Sueldo>>> entry : recibosPorEmpleado.entrySet()) {
            Empleado empleado = entry.getKey();
            if (empleado.getDni().equals(dniEmpleado)) {
                return empleado;
            }
        }
        return null;
    }
=======
    public void generarRecibo(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado) {
    }

    @Override
    public void eliminarRecibo(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado) {
    }

    @Override
    public void verRecibo(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado) {
    }

    @Override
    public void verTodosRecibos(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado) {
    }

>>>>>>> 5fa23b38e330003b9e7f64b5c2563b52b776476b
}