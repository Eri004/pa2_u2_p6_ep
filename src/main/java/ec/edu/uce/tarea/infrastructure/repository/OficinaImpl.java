package ec.edu.uce.tarea.infrastructure.repository;

import ec.edu.uce.tarea.domain.model.Oficina;
import ec.edu.uce.tarea.domain.repository.OficinaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class OficinaImpl implements OficinaRepository {

    @Inject
    EntityManager em;
    
    @Override
    public void crearOficina(Oficina oficina) {
        this.em.persist(oficina);
        
    }

    @Override
    public Oficina seleccionarOficinaId(Integer id) {
        return this.em.find(Oficina.class, id);
    }

}
