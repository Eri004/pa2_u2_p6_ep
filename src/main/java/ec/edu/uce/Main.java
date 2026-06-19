package ec.edu.uce;



import java.util.ArrayList;

import ec.edu.uce.tarea.application.service.ProfesorService;
import ec.edu.uce.tarea.domain.model.Profesor;
import ec.edu.uce.tarea.domain.model.Proyecto;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;



@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);

    }

    public static class App implements QuarkusApplication {

        
        @Inject
        ProfesorService profesorService;

        @Override
        public int run(String... args) throws Exception {

            // Se agrego Cascade a la relacion entre Profesor y Proyecto, 
            // por lo que al persistir un Profesor, se persistira los Proyectos asociados

            //Crearemos varios proyectos y los mandaremos al servicio de profesor 
            // para que se persista junto con el profesor
            
            Profesor profesor1 = new Profesor();
            profesor1.setNombre("Juan");
            profesor1.setApellido("Perez");
            profesor1.setMateria("Matematicas");
            profesor1.setDireccion("Calle Principal 123");
            profesor1.setCorreo("juanito2544@gmail.com");
            
            Proyecto proyecto1 = new Proyecto();
            proyecto1.setTitulo("Proyecto de Algebra");
            proyecto1.setTipo("Investigacion");

            Proyecto proyecto2 = new Proyecto();
            proyecto2.setTitulo("Proyecto de Geometria");
            proyecto2.setTipo("Desarrollo");

            ArrayList<Proyecto> proyectos = new ArrayList<>();
            proyectos.add(proyecto1);
            proyectos.add(proyecto2);

            profesor1.setProyectos(proyectos);
            profesorService.guardar(profesor1);

            

        
            return 0;
        }
    }
}
