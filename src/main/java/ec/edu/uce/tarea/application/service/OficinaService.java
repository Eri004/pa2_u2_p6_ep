package ec.edu.uce.tarea.application.service;

import ec.edu.uce.tarea.domain.model.Oficina;
import ec.edu.uce.tarea.domain.repository.OficinaRepository;
import ec.edu.uce.tarea.infrastructure.repository.OficinaImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OficinaService {

    @Inject
    private OficinaImpl oficinaImpl;
    
    public void crearOficina (Oficina oficina) {
        this.oficinaImpl.crearOficina(oficina);
    }

    public Oficina seleccionarOficinaId (Integer id) {
        return this.oficinaImpl.seleccionarOficinaId(id);
    }
}
