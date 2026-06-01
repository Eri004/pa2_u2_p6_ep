package ec.edu.uce.tarea.infrastructure.repository;

import ec.edu.uce.tarea.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import ec.edu.uce.tarea.domain.model.Profesor;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    @Override
    public List<Profesor> seleccionarTodo() {
        TypedQuery <Profesor> query = this.em.createQuery("SELECT p FROM Profesor p", Profesor.class);
        return query.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorMateria(String materia) {
        TypedQuery<Profesor> query = this.em.createQuery("SELECT p FROM Profesor p WHERE p.materia = :materia", Profesor.class);
        query.setParameter("materia", materia);
        return query.getResultList();   
    }

    @Override
    public Profesor seleccionarPorCorreo(String correo) {
        TypedQuery<Profesor> query = this.em.createQuery("SELECT p FROM Profesor p WHERE p.correo = :correo", Profesor.class);
        query.setParameter("correo", correo);
        return query.getResultList().getFirst();
    }
    


}
