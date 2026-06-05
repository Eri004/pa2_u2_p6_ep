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

            /*
             * Profesor p1 = new Profesor();
             * p1.setNombre("Erick");
             * p1.setApellido("Zapata");
             * p1.setMateria("Frances");
             * p1.setDireccion("Guangopolo");
             * p1.setCorreo("erick.zapata@uce.edu.ec");
             * profesorService.guardar(p1);
             */

           /*  System.out.println("Imprimiento todos los profesores con correo gmail:");
            profesorService.listarPorCorreoSensible("gmail").forEach(System.out::println);

            System.out.println("Imprimiento todos los profesores con nombre Erick en orden alfabetico de apellido:");
            profesorService.listarPorNombreOrdenado("Erick").forEach(System.out::println);

            System.out.println("Imprimiendo todos los profesores cuyo apellido comienza con P:");
            profesorService.buscarApellidoComienza("P").forEach(System.out::println); */

            
            
            profesorService.listarTodosCriteria().forEach(System.out::println); 

            profesorService.listarPorNombreCriteria("Erick").forEach(System.out::println);

            profesorService.listarNombreApellidoCriteria("Erick", "Zapata").forEach(System.out::println);

            

            return 0;
        }
    }
}
