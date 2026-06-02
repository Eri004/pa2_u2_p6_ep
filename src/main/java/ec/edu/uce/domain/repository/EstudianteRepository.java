package ec.edu.uce.domain.repository;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;

public interface EstudianteRepository {
    public void crear(Estudiante estudiante);

    public Estudiante seleccionar_id(Integer id);

        public void actualizar(Estudiante estudiante);
    
        public void eliminar(Integer id);

        public List<Estudiante> seleccionar_todos();

        public List<Estudiante> seleccionar_por_nombre(String nombre);

        public Estudiante seleccionar_por_cedula(String cedula);

        public List<Estudiante> seleccionar_por_genero(String genero);

        public List<Estudiante> seleccionar_por_genero2(String genero);

        public List<Estudiante> seleccionar_por_rango_fecha(LocalDate fechaInicio, LocalDate fechaFin);

        public List<Estudiante> seleccionar_por_apellido(String apellido);

        public Long seleccionar_contar ();

        public List<Estudiante> seleccionar_todos_native();

        public List<Estudiante> seleccionarTodosCriteria();

         public List<Estudiante> seleccionarPorNombreCriteria(String nombre);

         public List<Estudiante> seleccionarNombreApellidoCriteria(String nombre,String apellido);

}
