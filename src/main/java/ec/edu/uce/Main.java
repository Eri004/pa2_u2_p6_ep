package ec.edu.uce;



import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ec.edu.uce.application.service.AlumnoService;
import ec.edu.uce.application.service.CiudadanoService;
import ec.edu.uce.application.service.ClienteService;
import ec.edu.uce.application.service.EmpleadoService;
import ec.edu.uce.application.service.EstudianteService;
import ec.edu.uce.application.service.MateriaService;
import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.domain.model.Pedido;

@QuarkusMain
public class Main {
    public static void main(String[] args) {
        Quarkus.run(App.class, args);

    }

    public static class App implements QuarkusApplication {

    
        @Inject
        AlumnoService alumnoService;

        @Inject 
        MateriaService materiaService;
         
     
        @Override
        public int run(String... args) throws Exception {

              /* // Crear un nuevo alumno y asociarle dos materias
               Alumno alumno = new Alumno();
                alumno.setNombre("Alison");

                Materia materia = new Materia();
                materia.setNombre("Biologia");

                Materia materia2 = new Materia();
                materia2.setNombre("Ciencias Naturales");

                List<Materia> materias = new ArrayList<>();
                materias.add(materia);
                materias.add(materia2);
                alumnoService.guardar(alumno); 
 
                // Crear una nueva materia y asociarla a dos alumnos
                Materia materia3 = new Materia();
                materia3.setNombre("Fisica Cuantica");
                

                Alumno alumno2 = new Alumno();
                alumno2.setNombre("Brandon");
                alumno2.setMaterias(List.of(materia3));
            
                Alumno alumno3 = new Alumno();
                alumno3.setNombre("Betty");
                alumno3.setMaterias(List.of(materia3));

                List<Alumno> alumnos = new ArrayList<>();
                alumnos.add(alumno2);
                alumnos.add(alumno3);

                materia3.setAlumnos(alumnos);

                materiaService.guardar(materia3); 
                alumno.setMaterias(materias); */
                

              alumnoService.buscarTodos().forEach(System.out::println);
            
              materiaService.buscarTodos().forEach(System.out::println);

              materiaService.buscarPorId(5).getAlumnos().forEach(System.out::println);
                
             alumnoService.buscarPorId(3).getMaterias().forEach(System.out::println);

            
            return 0;
        }
    }
}
