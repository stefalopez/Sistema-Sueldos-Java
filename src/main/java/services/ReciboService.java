package services;

import models.Recibo;

public interface ReciboService {
    void menuRecibos() throws InterruptedException;
    void generarRecibo();
    void eliminarRecibo();
    void verRecibo();
    void verTodosRecibos();
}