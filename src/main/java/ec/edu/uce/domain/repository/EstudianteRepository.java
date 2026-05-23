package ec.edu.uce.domain.repository;

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

        
    
}
