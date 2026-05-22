package ec.edu.uce.tarea.application.service;


import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.tarea.domain.model.Profesor;
import ec.edu.uce.tarea.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProfesorService {

    @Inject
    private ProfesorRepository profesorRepository;

    public void guardar (Profesor profesor){
        this.profesorRepository.crear(profesor);

    }

    public Profesor buscarPorId(Integer id){
        return this.profesorRepository.seleccionar_id(id);
    }

    public void actualizar(Integer id, Profesor profesor){

        Profesor profesorCambiable = this.buscarPorId(id);
        if (profesorCambiable == null) {
            throw new RuntimeException("Profesor no encontrado con ID: " + id);
        }
            profesorCambiable.setNombre(profesor.getNombre());
            profesorCambiable.setApellido(profesor.getApellido());
            profesorCambiable.setMateria(profesor.getMateria());

        
        this.profesorRepository.actualizar(profesorCambiable);
    }

    public void eliminar(Integer id){
        this.profesorRepository.eliminar(id);
    }

}   
