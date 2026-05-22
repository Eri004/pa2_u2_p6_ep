package ec.edu.uce.tarea.domain.repository;


import ec.edu.uce.tarea.domain.model.Profesor;

public interface ProfesorRepository {
    
    public void crear(Profesor profesor);

    public Profesor seleccionar_id(Integer id);

        public void actualizar(Profesor profesor);
    
        public void eliminar(Integer id);
    
}
