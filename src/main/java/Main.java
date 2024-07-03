import models.Sistema;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Sistema sistema = new Sistema();
            sistema.menu();

            Scanner scanner = new Scanner(System.in);

            //En desarrollo
            //System.out.print("\n¿Desea guardar los cambios antes de salir? (s/n): ");
            //char respuesta = scanner.next().charAt(0);
            //if (respuesta == 's' || respuesta == 'S') {
            //    sistema.guardarDatos();
            //}

        }catch (Exception e){
            System.out.println("\nERROR: " + e.getMessage());
        }
    }
}