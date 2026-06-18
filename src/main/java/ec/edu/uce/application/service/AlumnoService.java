package ec.edu.uce.application.service;

import ec.edu.uce.domain.repository.AlumnoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AlumnoService {

    @Inject
    AlumnoRepository alumnoRepository;
    public void guardar (Alumno alumno){
        this.alumnoRepository.persist(alumno);
    }
    public Alumno buscarPorId(Integer id){
        return this.alumnoRepository.findById(Long.valueOf(id));
    }
}
