package services;

import models.Empleado;

import java.util.ArrayList;

public interface EmpleadoService {
    void menuEmpleado(ArrayList<Empleado> empleados) throws InterruptedException;
    void altaEmpleado(ArrayList<Empleado> empleados);
    void bajaEmpleado(ArrayList<Empleado> empleados);
    void modificarEmpleado(ArrayList<Empleado> empleados);
    void verEmpleado(ArrayList<Empleado> empleados);
    void verTodosEmpleados(ArrayList<Empleado> empleados);
}