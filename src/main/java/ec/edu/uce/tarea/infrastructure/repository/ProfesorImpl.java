package ec.edu.uce.tarea.infrastructure.repository;

import ec.edu.uce.tarea.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import ec.edu.uce.tarea.domain.model.Profesor;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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

    @Override
    public List<Profesor> seleccionarPorApellido(String apellido) {
        TypedQuery<Profesor> query = this.em.createNamedQuery("Profesor.seleccionarPorApellido", Profesor.class);
        query.setParameter("apellido", apellido);
        return query.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorNombre(String nombre) {
        TypedQuery<Profesor> query = this.em.createNamedQuery("Profesor.seleccionarPorNombre", Profesor.class);
        query.setParameter("nombre", nombre);
        return query.getResultList();
    }

    @Override
    public Long contarTodo() {
        TypedQuery<Long> query = this.em.createNamedQuery("Profesor.contarTodo", Long.class);
        return query.getSingleResult(); 
    }

    @Override
    public List<Profesor> seleccionarPorCorreoSensibleNative(String correo) {
       Query query =  this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_correo ILIKE :correo", Profesor.class);
        query.setParameter("correo", "%" + correo + "%");
        return query.getResultList();
    }

    @Override
    public List<Profesor> seleccionarPorNombreOrdenadoNative(String nombre) {
        Query query = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_nombre ILIKE :nombre ORDER BY prof_apellido", Profesor.class);
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
       }

    @Override
    public List<Profesor> buscarApellidoComienzaNative(String prefijo) {
        Query query = this.em.createNativeQuery("SELECT * FROM profesor WHERE prof_apellido ILIKE :prefijo || '%'", Profesor.class);
        query.setParameter("prefijo", prefijo);
        return query.getResultList();
    }

    
    }
