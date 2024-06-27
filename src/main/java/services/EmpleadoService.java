package services;

import models.Empleado;

import java.util.ArrayList;

public interface EmpleadoService {
    void menuEmpleados(ArrayList<Empleado> empleados) throws InterruptedException;
    void altaEmpleado();
    void bajaEmpleado();
    void modificarEmpleado(ArrayList<Empleado> empleados);
    void verEmpleado(ArrayList<Empleado> empleados);
    void verTodosEmpleados(ArrayList<Empleado> empleados);
}