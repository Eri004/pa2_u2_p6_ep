package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Estudiante;
import ec.edu.uce.domain.repository.EstudianteRepositoryV1;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped

public class EstudianteService {

    @Inject
    private EstudianteRepositoryV1 estudianteRepository;

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

}   
