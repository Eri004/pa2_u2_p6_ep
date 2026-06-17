package ec.edu.uce;



import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

import ec.edu.uce.tarea.application.service.OficinaService;
import ec.edu.uce.tarea.application.service.ProfesorService;
import ec.edu.uce.tarea.domain.model.Oficina;
import ec.edu.uce.tarea.domain.model.Profesor;



@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);

    }

    public static class App implements QuarkusApplication {

        @Inject
        OficinaService oficinaService;
        
        @Inject
        ProfesorService profesorService;

        @Override
        public int run(String... args) throws Exception {

            // Se agrego Cascade a la relacion entre Profesor y Oficina, 
            // por lo que al persistir un Profesor, se persistira su Oficina asociada

            //Crearemos una oficina y la mandare al servicio de profesor 
            // para que se persista junto con el profesor
            
            Oficina oficina1 = new Oficina();
            oficina1.setNombre("Oficina Principal");
            oficina1.setCodigo(101);

            Profesor profesor1 = new Profesor();
            profesor1.setNombre("Erick");
            profesor1.setApellido("Paz");
            profesor1.setMateria("Matematicas");
            profesor1.setCorreo("espazminov@gmail.com");
            profesor1.setOficina(oficina1);

            profesorService.guardar(profesor1);

        
            return 0;
        }
    }
}
