package ec.edu.uce.tarea.infrastructure.repository;

import ec.edu.uce.tarea.domain.repository.ProfesorRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import ec.edu.uce.tarea.domain.model.Profesor;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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


    @Override
    public List<Profesor> seleccionarTodosCriteria() {

        //Crea una instancia de la clase que va a ser la encargada de construir la consulta
        CriteriaBuilder cb = this.em.getCriteriaBuilder();

        // Crea una consulta de tipo CriteriaQuery para la entidad Estudiante
        //Define el tipo de objeto de retorno de la consulta
        CriteriaQuery<Profesor> myQuery = cb.createQuery(Profesor.class);

        //Se define las entidades del FROM
        Root<Profesor> root = myQuery.from(Profesor.class);

        //Defino que tipo de SQL voy a utilizar
        //SELECT en este caso

        myQuery.select(root);

        //Hasta aqui terminamos de construir la consulta, ahora la ejecutamos
        TypedQuery<Profesor> query = this.em.createQuery(myQuery);
        return query.getResultList();
            
    }

    
    @Override
    public List<Profesor> seleccionarPorNombreCriteria(String nombre) {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> myQuery = cb.createQuery(Profesor.class);
        Root<Profesor> root = myQuery.from(Profesor.class);

        //WHERE e.nombre = :nombre
        Predicate predicate = cb.equal(root.get("nombre"), nombre);
        myQuery.select(root).where(predicate);

        TypedQuery<Profesor> query = this.em.createQuery(myQuery);
        return query.getResultList();
    }


    @Override
    public List<Profesor> seleccionarNombreApellidoCriteria (String nombre, String apellido) {

        CriteriaBuilder cb = this.em.getCriteriaBuilder();
        CriteriaQuery<Profesor> myQuery = cb.createQuery(Profesor.class);
        Root<Profesor> root = myQuery.from(Profesor.class);
        List <Predicate> predicates = new ArrayList<>();


       //Queremos que se cumplan dos condiciones, el nombre y el apellido, 
       //Pero si es null el apellido, se imprima solo por nombre, y si es null el nombre, se imprima solo por apellido
       // y si los dos son null, se imprima todo

       if(nombre != null){
        Predicate predicateNombre = cb.equal(root.get("nombre"), nombre);
       predicates.add(predicateNombre);
       }
       
       if(apellido != null){
        Predicate predicateApellido = cb.equal(root.get("apellido"), apellido);
        predicates.add(predicateApellido);
       }
            myQuery.select(root).where(predicates);

        TypedQuery<Profesor> query = this.em.createQuery(myQuery);
        return query.getResultList();
    
    }



    


    
    }
