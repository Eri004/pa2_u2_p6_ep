package ec.edu.uce;


import ec.edu.uce.application.service.EstudianteService;
import java.time.LocalDate;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);

    }

    public static class App implements QuarkusApplication {
        
        @Inject
        EstudianteService estudianteService;

        @Override
        @Transactional
        public int run(String... args) throws Exception {

            this.estudianteService.listarPorApellido("Davar").forEach(System.out::println);
            System.out.println("/////////////Separador de metodos u.u////////////");

            LocalDate fechaInicio = LocalDate.of(2003, 1, 1);
            LocalDate fechaFin = LocalDate.of(2003, 12, 31);
            this.estudianteService.listarPorRangoFecha(fechaInicio, fechaFin).forEach(System.out::println);
            System.out.println("/////////////Separador de metodos u.u////////////");
                    
            System.out.println(this.estudianteService.seleccionarContar());  
            return 0;
        }
    }
}
