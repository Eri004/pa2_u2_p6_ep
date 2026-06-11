package ec.edu.uce.tarea.domain.repository;

import ec.edu.uce.tarea.domain.model.Oficina;

public interface OficinaRepository {

    public void crearOficina (Oficina oficina);
    public Oficina seleccionarOficinaId (Integer id);
}
