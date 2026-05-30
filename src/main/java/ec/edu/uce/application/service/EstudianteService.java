package ec.edu.uce.application.service;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped

public class EstudianteService {

    @Inject
    private EstudianteRepository estudianteRepository;

    public void guardar (Estudiante estudiante){
        this.estudianteRepository.crear(estudiante);

    }

    public Estudiante buscarPorId(Integer id){
        return this.estudianteRepository.seleccionar_id(id);
    }

    public void actualizar(Integer id, Estudiante estudiante){

        Estudiante estudianteCambiable = this.buscarPorId(id);
        if (estudianteCambiable == null) {
            throw new RuntimeException("Estudiante no encontrado con ID: " + id);
        }
            estudianteCambiable.setNombre(estudiante.getNombre());
            estudianteCambiable.setApellido(estudiante.getApellido());
            estudianteCambiable.setFechaNacimiento(estudiante.getFechaNacimiento());
            estudianteCambiable.setGenero(estudiante.getGenero());

        
        this.estudianteRepository.actualizar(estudiante);
    }

    public void eliminar(Integer id){
        this.estudianteRepository.eliminar(id);
    }

    public List<Estudiante> listarTodos() {
        return this.estudianteRepository.seleccionar_todos();
    }

    public List<Estudiante> listarPorNombre(String nombre) {
        return this.estudianteRepository.seleccionar_por_nombre(nombre);
    }

    public Estudiante listarPorCedula(String cedula) {
        return this.estudianteRepository.seleccionar_por_cedula(cedula);    
    }

    public List<Estudiante> listarPorGenero(String genero) {
        return this.estudianteRepository.seleccionar_por_genero(genero);
    }
    public List<Estudiante> listarPorGenero2(String genero) {
        return this.estudianteRepository.seleccionar_por_genero2(genero);
    }

    public List<Estudiante> listarPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        return this.estudianteRepository.seleccionar_por_rango_fecha(fechaInicio, fechaFin);
    }

    public List<Estudiante> listarPorApellido(String apellido) {
        return this.estudianteRepository.seleccionar_por_apellido(apellido);
    }

    public Long seleccionarContar() {
        return this.estudianteRepository.seleccionar_contar();
    }

    public List<Estudiante> listarTodosNative() {
        return this.estudianteRepository.seleccionar_todos_native();
    }
}   
