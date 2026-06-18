package ec.edu.uce.domain.repository;

import ec.edu.uce.domain.model.Alumno;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlumnoRepository implements PanacheRepository<Alumno> {

}
