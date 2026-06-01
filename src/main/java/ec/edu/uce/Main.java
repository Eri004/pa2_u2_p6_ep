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
           
        profesorService.listarTodos().forEach(System.out::println);

        Profesor p1 = new Profesor();
        p1.setNombre("Fernando");
        p1.setApellido("Ibarra");
        p1.setMateria("Matematicas");
        p1.setCorreo("fernando.ibarra@uce.edu.ec");
        p1.setDireccion("Av 10 de Agosto");
        profesorService.guardar(p1);


          profesorService.listarPorMateria("Matematicas").forEach(System.out::println);

        Profesor profesorEncontrado = profesorService.buscarPorCorreo("fernando.ibarra@uce.edu.ec");
        System.out.println("Se encontró el profesor: " + profesorEncontrado);
            


                    

            return 0;
        }
    }
}
