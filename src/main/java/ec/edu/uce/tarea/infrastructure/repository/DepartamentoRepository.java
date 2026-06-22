package ec.edu.uce.tarea.infrastructure.repository;

import ec.edu.uce.tarea.domain.model.Departamento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DepartamentoRepository implements PanacheRepository<Departamento> {

}
