package ec.edu.uce;



import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.EmpleadoService;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.model.Estudiante;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);

    }

    public static class App implements QuarkusApplication {

        @Inject
        private CiudadanoService ciudadanoService;

        @Inject 
        private EmpleadoService empleadoService;

         

        @Override
        public int run(String... args) throws Exception {

              Ciudadano ciudadano = new Ciudadano();
            ciudadano.setNombre("Ciudadano");
            ciudadano.setApellido("Cinco");
            ciudadano.setCedula("0401739295");
            ciudadano.setFechaNacimiento(LocalDate.of(2000, 11, 29));
               //  ciudadanoService.guardar(ciudadano); 
                       
            Empleado empleado = new Empleado();
        
            empleado.setNombre("Miguelito");
            empleado.setApellido("Cinco");
            empleado.setFechaNacimiento(LocalDate.of(1980, 10, 10));
            empleado.setCargo("Software Engineer");
            empleado.setSalario(null);
          empleado.setCiudadano(ciudadano);
        
          empleadoService.crearEmpleado(empleado);
            
            return 0;
        }
    }
}
