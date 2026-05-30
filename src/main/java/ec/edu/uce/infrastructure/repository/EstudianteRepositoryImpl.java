package ec.edu.uce.infrastructure.repository;

import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import ec.edu.uce.domain.model.Estudiante;

@ApplicationScoped
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {
    
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

    @Override
    public List<Estudiante> seleccionar_todos() {
        TypedQuery<Estudiante> query = this.em.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return query.getResultList();
        
    }

    @Override
    public List<Estudiante> seleccionar_por_nombre(String nombre) {
        TypedQuery<Estudiante> query = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.nombre = :name", Estudiante.class);
        // Los dos puntos significan que es una variable que se va a reemplazar por un valor específico
        query.setParameter("name", nombre);
        return query.getResultList();
    
    }

    @Override
    public Estudiante seleccionar_por_cedula(String cedula) {

        TypedQuery <Estudiante> query = this.em.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :cedula", Estudiante.class);
        query.setParameter("cedula", cedula);

         
           // return query.getSingleResult();
        

        return query.getResultList().stream().findFirst().orElse(null);
        
       // return query.getResultList().getFirst();
        
    
    }

@Override
    public List<Estudiante> seleccionar_por_genero2(String genero) {
        
        Query  query = this.em.createNamedQuery("Estudiante.buscar_por_genero");
        query.setParameter("genero", genero);
        return (List<Estudiante>) query.getResultList();
    }

    @Override
    public List<Estudiante> seleccionar_por_genero(String genero) {
        
        TypedQuery<Estudiante> query = this.em.createNamedQuery("Estudiante.buscar_por_genero", Estudiante.class);
        query.setParameter("genero", genero);
        return query.getResultList();
    }

    @Override
    public List<Estudiante> seleccionar_por_rango_fecha(LocalDate fechaInicio, LocalDate fechaFin) {
            TypedQuery<Estudiante> query = this.em.createNamedQuery("Estudiante.buscar_por_rango_fecha", Estudiante.class);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
            return query.getResultList();
    }

    @Override
    public List<Estudiante> seleccionar_por_apellido(String apellido) {
        TypedQuery<Estudiante> query = this.em.createNamedQuery("Estudiante.buscar_por_apellido", Estudiante.class);
        query.setParameter("apellido", apellido);
        return query.getResultList();
      }

    @Override
    public Long seleccionar_contar() {
        TypedQuery<Long> query = this.em.createNamedQuery("Estudiante.contar", Long.class);
        return query.getSingleResult();
    }
    

}
