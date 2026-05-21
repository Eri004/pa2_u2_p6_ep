package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepositoryV1;
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
        EstudianteService estudianteService;

        @Override
        @Transactional
        public int run(String... args) throws Exception {
            
            Estudiante estudiante1 = new Estudiante();
            estudiante1.setNombre("Shallan");
            estudiante1.setApellido("Davar");
            estudiante1.setFechaNacimiento(LocalDate.of(2004, 12, 31));
            estudiante1.setGenero("Masculino");
            this.estudianteService.guardar(estudiante1);
           
            Estudiante estudianteNuevo = new Estudiante();
            estudianteNuevo.setNombre("Kaladin");
                estudianteNuevo.setApellido("Soria");
                estudianteNuevo.setFechaNacimiento(LocalDate.of(2003, 12, 31));
                estudianteNuevo.setGenero("Femenino");
                this.estudianteService.guardar(estudianteNuevo);

            Estudiante estudianteEncontrado = this.estudianteService.buscarPorId(estudiante1.getId());
            System.out.println("Estudiante encontrado: " + estudianteEncontrado);
            
            Estudiante estudianteEncontrado2 = this.estudianteService.buscarPorId(estudianteNuevo.getId());
            System.out.println("Estudiante encontrado: " + estudianteEncontrado2);
            



                    

            return 0;
        }
    }
}
