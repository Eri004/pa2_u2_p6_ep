package ec.edu.uce.infrastructure.repository;

import javax.swing.text.html.parser.Entity;

import ec.edu.uce.domain.repository.EstudianteRepositoryV1;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import ec.edu.uce.domain.model.Estudiante;

@ApplicationScoped
@Transactional
public class EstudianteImpl implements EstudianteRepositoryV1 {
    
    @Inject
     private EntityManager em;

    @Override
    public void crear(Estudiante estudiante) {
        this.em.persist(estudiante);
        
    }

    @Override
    public Estudiante seleccionar_id(Integer id) {  
        return this.em.find(Estudiante.class, id);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        
        // Ya debe tener un ID válido para actualizar
        this.em.merge(estudiante);

    }

    @Override
    public void eliminar(Integer id) {
        
        this.em.remove(this.seleccionar_id(id));
    }

}
