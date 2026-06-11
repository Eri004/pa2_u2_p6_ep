package ec.edu.uce;



import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Estudiante;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);

    }

    public static class App implements QuarkusApplication {

        @Inject
        private CiudadanoService ciudadanoService;

         

        @Override
        public int run(String... args) throws Exception {

           /*  Ciudadano ciudadano = new Ciudadano();
            ciudadano.setCedula("1234567890");
            ciudadano.setNombre("Juan");
            ciudadano.setApellido("Pérez");
            ciudadano.setFechaNacimiento(LocalDate.of(1990, 1, 1));
            ciudadanoService.guardar(ciudadano);
 */
          System.out.println("Ciudadano guardado con éxito: " + ciudadanoService.buscarPorId(2));
        
            return 0;
        }
    }
}
