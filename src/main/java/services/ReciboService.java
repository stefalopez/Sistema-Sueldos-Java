package services;

import models.Empleado;
import models.Recibo;
import models.Sueldo;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public interface ReciboService {
<<<<<<< HEAD
    void menuRecibos(HashMap<Empleado, ArrayList<Recibo<Sueldo>>> recibosPorEmpleado) throws InterruptedException;
    void generarRecibo(HashMap<Empleado, ArrayList<Recibo<Sueldo>>> recibosPorEmpleado);
    void eliminarRecibo(HashMap<Empleado, ArrayList<Recibo<Sueldo>>> recibosPorEmpleado);
    void verRecibo(HashMap<Empleado, ArrayList<Recibo<Sueldo>>> recibosPorEmpleado);
    void verTodosRecibos(HashMap<Empleado, ArrayList<Recibo<Sueldo>>> recibosPorEmpleado);
=======
    void menuRecibos(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado) throws InterruptedException;
    void generarRecibo(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado);
    void eliminarRecibo(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado);
    void verRecibo(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado);
    void verTodosRecibos(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado);
>>>>>>> 5fa23b38e330003b9e7f64b5c2563b52b776476b
}