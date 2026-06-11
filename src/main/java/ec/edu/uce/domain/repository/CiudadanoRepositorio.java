package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Ciudadano;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class CiudadanoRepositorio {

    @Inject 
    EntityManager em;
    public void crear(Ciudadano ciudadano) {
        this.em.persist(ciudadano);
    }

    public Ciudadano encontrarPorId(Integer id) {
        return this.em.find(Ciudadano.class, id);
    }
}
