package ec.edu.uce.application.service;

import java.util.List;

import ec.edu.uce.domain.model.Alumno;
import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.domain.repository.MateriaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MateriaService {

    @Inject
    MateriaRepository materiaRepository;

    public void guardar (Materia materia){
        this.materiaRepository.persist(materia);
    }

    
    public Materia buscarPorId(Integer id){
        return this.materiaRepository.findById(Long.valueOf(id));
    }



    
}
