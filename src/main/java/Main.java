import com.fasterxml.jackson.databind.ObjectMapper;
import models.Empleado;
import models.Jornal;
import models.Mensual;
import models.Sistema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Sistema sistema = new Sistema();

        ObjectMapper mapper = new ObjectMapper();
        List<Mensual> mensuales = new ArrayList<>();

        mensuales = Arrays.asList(mapper.readValue(new File("mensuales.json"), Mensual[].class));

        for (Mensual m : mensuales){
            System.out.println(m);
        }




    }
}