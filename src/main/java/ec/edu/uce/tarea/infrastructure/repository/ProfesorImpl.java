package ec.edu.uce.tarea.infrastructure.repository;

import javax.swing.text.html.parser.Entity;

import ec.edu.uce.tarea.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import ec.edu.uce.tarea.domain.model.Profesor;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ProfesorImpl implements ProfesorRepository {
    
    @Inject
     private EntityManager em;

    @Override
    public void crear(Profesor profesor) {
        this.em.persist(profesor);
        
    }

    @Override
    public Profesor seleccionar_id(Integer id) {  
        return this.em.find(Profesor.class, id);
    }

    @Override
    public void actualizar(Profesor profesor) {
        
        // Ya debe tener un ID válido para actualizar
        this.em.merge(profesor);

    }

    @Override
    public void eliminar(Integer id) {
        
        this.em.remove(this.seleccionar_id(id));
    }

}
