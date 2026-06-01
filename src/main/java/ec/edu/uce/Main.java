package ec.edu.uce;


import ec.edu.uce.tarea.application.service.ProfesorService;
import ec.edu.uce.tarea.domain.model.Profesor;
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
        ProfesorService profesorService;

        @Override
        @Transactional
        public int run(String... args) throws Exception {
           
           /*  Profesor p1 = new Profesor();
            p1.setNombre("Erick");
            p1.setApellido("Guaman");
            p1.setMateria("Programacion");
            p1.setDireccion("Av. 6 de Diciembre");
            p1.setCorreo("erick.guaman@uce.edu.ec");
            profesorService.guardar(p1); */

       profesorService.listarPorApellido("Ibarra").forEach(System.out::println);

            
      profesorService.listarPorNombre("Erick").forEach(System.out::println);

      System.out.println("Total de profesores: " + profesorService.contarProfesores());


                    

            return 0;
        }
    }
}
