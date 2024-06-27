package services;

import models.Mensual;

import java.util.ArrayList;

public interface MensualService {
    void menuMensual(ArrayList<Mensual> mensuales) throws InterruptedException;
    void altaMensual(ArrayList<Mensual> mensuales);
    void bajaMensual(ArrayList<Mensual> mensuales);
    void modificarMensual(ArrayList<Mensual> mensuales);
    void verMensual(ArrayList<Mensual> mensuales);
    void verTodosMensual(ArrayList<Mensual> mensuales);
}