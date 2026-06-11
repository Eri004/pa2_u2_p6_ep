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

/* 
             Oficina oficina1 = new Oficina();
            oficina1.setNombre("Oficina Ingenieria 1");
            oficina1.setCodigo(44335);
        this.oficinaService.crearOficina(oficina1); 

        Profesor profesor1 = new Profesor();
        profesor1.setNombre("Edgar");
        profesor1.setApellido("Mena");
        profesor1.setDireccion("Conocoto");
        profesor1.setCorreo("edgeM3314@gmail.com");
        profesor1.setMateria("Programacion");
        profesor1.setOficina(this.oficinaService.seleccionarOficinaId(1)); */
        
      //  this.profesorService.guardar(profesor1);

            
        System.out.println("Profesor Ingresado:");
        System.out.println(this.profesorService.buscarPorId(1));

        System.out.println("Oficina del Profesor:");
        System.out.println(this.profesorService.buscarPorId(1).getOficina());
        
            return 0;
        }
    }
}
