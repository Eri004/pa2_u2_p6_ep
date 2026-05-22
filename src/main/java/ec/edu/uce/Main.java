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
           
            Profesor profesor1 = new Profesor();
            profesor1.setNombre("Erick");
            profesor1.setApellido("Paz");
            profesor1.setMateria("Matematicas");

            this.profesorService.guardar(profesor1);
            System.out.println("Profesor guardado: " + profesor1);

             Profesor profesor2 = new Profesor();

             profesor2.setNombre("Maria");
             profesor2.setApellido("Lopez");
             profesor2.setMateria("Lengua");    
                this.profesorService.guardar(profesor2);
                System.out.println("Profesor guardado: " + profesor2);


                profesor1.setMateria("Fisica");
                this.profesorService.actualizar(profesor1.getId(), profesor1);
                System.out.println("Profesor actualizado: " + profesor1);

                Profesor profesorEncontrado = this.profesorService.buscarPorId(profesor1.getId());
                System.out.println("Profesor encontrado: " + profesorEncontrado);

                




                    

            return 0;
        }
    }
}
