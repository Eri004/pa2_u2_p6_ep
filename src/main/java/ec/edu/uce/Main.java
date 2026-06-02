package ec.edu.uce;



import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Estudiante;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);

    }

    public static class App implements QuarkusApplication {

        @Inject
        private EstudianteService eService;

         

        @Override
        @Transactional
        public int run(String... args) throws Exception {

            
             //this.eService.listarTodosCriteria().forEach(System.out::println);

           // this.eService.listarPorNombreCriteria("Kaladin ").forEach(System.out::println);
            
           /* Estudiante estudiante = new Estudiante();
              estudiante.setNombre("Kaladin");
                estudiante.setApellido(null);
                estudiante.setCedula("1234567890");
                estudiante.setFechaNacimiento(null);
                estudiante.setGenero(null); 

                this.eService.guardar(estudiante);

                Estudiante estudiante2 = new Estudiante();
                estudiante2.setNombre(null);
                estudiante2.setApellido("Stormblessed");
                estudiante2.setCedula("1234567890");
                estudiante2.setFechaNacimiento(null);   
                estudiante2.setGenero(null);
                this.eService.guardar(estudiante2);

                Estudiante estudiante3 = new Estudiante();
                estudiante3.setNombre("Kaladin");
                estudiante3.setApellido("Stormblessed");
                estudiante3.setCedula("1234567890");    
                estudiante3.setFechaNacimiento(null);
                estudiante3.setGenero(null);
                this.eService.guardar(estudiante3);

                Estudiante estudiante4 = new Estudiante();
                estudiante4.setNombre(null);
                estudiante4.setApellido(null);
                estudiante4.setCedula("1234567890");
                estudiante4.setFechaNacimiento(null);
                estudiante4.setGenero(null);
                this.eService.guardar(estudiante4); */

                this.eService.listarPorNombreApellidoCriteria("Kaladin", "Stormblessed").forEach(System.out::println);
                this.eService.listarPorNombreApellidoCriteria("Kaladin", null).forEach(System.out::println);
                this.eService.listarPorNombreApellidoCriteria(null, "Stormblessed").forEach(System.out::println);
                this.eService.listarPorNombreApellidoCriteria(null, null).forEach(System.out::println);

            return 0;
        }
    }
}
