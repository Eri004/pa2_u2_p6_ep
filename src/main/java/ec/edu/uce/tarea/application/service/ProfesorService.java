package ec.edu.uce.tarea.application.service;


import java.util.List;
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

    public List<Profesor> listarTodos(){
        return this.profesorRepository.seleccionarTodo();
    }

    public List<Profesor> listarPorMateria(String materia){
        return this.profesorRepository.seleccionarPorMateria(materia);
    }

    public Profesor buscarPorCorreo(String correo){
        return this.profesorRepository.seleccionarPorCorreo(correo);
    }

    public List<Profesor> listarPorApellido(String apellido){
        return this.profesorRepository.seleccionarPorApellido(apellido);
    }   
    public List<Profesor> listarPorNombre(String nombre){
        return this.profesorRepository.seleccionarPorNombre(nombre);
    }
    public Long contarProfesores(){
        return this.profesorRepository.contarTodo();
    }

    public List<Profesor> listarPorCorreoSensible(String correo){
        return this.profesorRepository.seleccionarPorCorreoSensibleNative(correo);
    }

    public List<Profesor> listarPorNombreOrdenado(String nombre){
        return this.profesorRepository.seleccionarPorNombreOrdenadoNative(nombre);
    }

    public List<Profesor> buscarApellidoComienza(String prefijo){
        return this.profesorRepository.buscarApellidoComienzaNative(prefijo);
    }

}   
