package ec.edu.uce;



import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.tarea.application.service.DepartamentoService;
import ec.edu.uce.tarea.application.service.ProfesorService;
import ec.edu.uce.tarea.domain.model.Departamento;
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

        @Inject
        DepartamentoService departamentoService;


        @Override
        public int run(String... args) throws Exception {

            
            
            /* System.out.println("Creando profesor y departamentos apartir de el");
            Profesor profesor1 = new Profesor();
            profesor1.setNombre("Jose");
            profesor1.setApellido("Perez");
            profesor1.setMateria("Fisica");
            profesor1.setDireccion("Calle Principal 123");
            profesor1.setCorreo("jose123@gmail.com");

            Departamento departamento1 = new Departamento();
            departamento1.setNombre("Matematicas");
            departamento1.setUbicacion("Edificio A");

            Departamento departamento2 = new Departamento();
            departamento2.setNombre("Fisica");
            departamento2.setUbicacion("Edificio B");

            profesor1.setDepartamentos(List.of(departamento1,departamento2));
            profesorService.guardar(profesor1);
 */
           System.out.println("Creando Departamento y profesores apartir de el");
          
            Departamento departamento1 = new Departamento();
            departamento1.setNombre("Medicina");
            departamento1.setUbicacion("Torre A");

             Profesor profesor1 = new Profesor();
            profesor1.setNombre("Maria");
            profesor1.setApellido("Davila");
            profesor1.setMateria("Cardiologia");
            profesor1.setDireccion("calle 24");
            profesor1.setCorreo("maria123@gmail.com");

              Profesor profesor2 = new Profesor();
            profesor2.setNombre("Arleth");
            profesor2.setApellido("Muñoz");
            profesor2.setMateria("Embriologia");
            profesor2.setDireccion("Calle123");
            profesor2.setCorreo("ari123@gmail.com");

            departamento1.setProfesores(List.of(profesor1,profesor2));

            departamentoService.guardar(departamento1);


            //profesorService.listarTodos().forEach(System.out::println);



            

        
            return 0;
        }
    }
}
