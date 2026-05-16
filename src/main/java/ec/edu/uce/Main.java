package ec.edu.uce;

import java.time.LocalDate;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
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
        EstudianteRepository estudianteRepository;

        @Override
        @Transactional
        public int run(String... args) throws Exception {
            
            Estudiante estudiante = new Estudiante();
            estudiante.setNombre("Juan");
            estudiante.setApellido("Perez");
            estudiante.setFechaNacimiento(LocalDate.of(2001, 5, 10));
            estudiante.setGenero("M");
            estudianteRepository.crear(estudiante);

            estudianteRepository.listarTodos().forEach(est -> {
                System.out.println("Estudiante: " + est.getNombre() + " " + est.getApellido());
            });
            return 0;
        }
    }
}
