package services;

import models.Empleado;
import models.Recibo;

import java.util.ArrayList;
import java.util.HashMap;

public interface ReciboService {
    void menuRecibos(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado) throws InterruptedException;
    void generarRecibo(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado);
    void eliminarRecibo(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado);
    void verRecibo(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado);
    void verTodosRecibos(HashMap<Empleado, ArrayList<Recibo<?>>> recibosPorEmpleado);
}