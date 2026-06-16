package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Empleado;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped

public class EmpleadoRepository implements PanacheRepository<Empleado> {
   
}
