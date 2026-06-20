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

              
              /*  Alumno alumno = new Alumno();
                alumno.setNombre("Serena");

                Materia materia = new Materia();
                materia.setNombre("Matematica");

                Materia materia2 = new Materia();
                materia2.setNombre("Lengua");

                List<Materia> materias = new ArrayList<>();
                materias.add(materia);
                materias.add(materia2);

                alumno.setMaterias(materias);
                alumnoService.guardar(alumno); */

                /* Materia materia2 = new Materia();
                materia2.setNombre("Progra 1");

                Alumno alumno2 = new Alumno();
                alumno2.setNombre("Abidi");
                alumno2.setMaterias(List.of(materia2));
            
                Alumno alumno3 = new Alumno();
                alumno3.setNombre("Fenix");
                alumno3.setMaterias(List.of(materia2));

                List<Alumno> alumnos = new ArrayList<>();
                alumnos.add(alumno2);
                alumnos.add(alumno3);

                materia2.setAlumnos(alumnos);

                materiaService.guardar(materia2); */

             //   System.out.println(materiaService.buscarPorId(1));
             materiaService.buscarPorId(1).getAlumnos().forEach(System.out::println);
                
             alumnoService.buscarPorId(3).getMaterias().forEach(System.out::println);

            
            return 0;
        }
    }
}
