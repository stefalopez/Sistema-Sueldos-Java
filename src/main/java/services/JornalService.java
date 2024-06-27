package services;

import models.Jornal;

import java.util.ArrayList;

public interface JornalService {
    void menuJornal(ArrayList<Jornal> jornales) throws InterruptedException;
    void altaJornal(ArrayList<Jornal> jornales);
    void bajaJornal(ArrayList<Jornal> jornales);
    void modificarJornal(ArrayList<Jornal> jornales);
    void verJornal(ArrayList<Jornal> jornales);
    void verTodosJornal(ArrayList<Jornal> jornales);
}