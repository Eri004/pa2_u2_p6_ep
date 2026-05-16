package ec.edu.uce.domain.repository;

import java.util.List;
import java.util.Optional;

import ec.edu.uce.domain.model.Estudiante;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EstudianteRepository implements PanacheRepositoryBase<Estudiante, Integer> {

    @Transactional
    public Estudiante crear(Estudiante estudiante) {
        persist(estudiante);
        return estudiante;
    }

    public Optional<Estudiante> buscarPorId(Integer id) {
        return findByIdOptional(id);
    }

    public List<Estudiante> listarTodos() {
        return listAll();
    }

    @Transactional
    public Optional<Estudiante> actualizar(Integer id, Estudiante datosActualizados) {
        Estudiante estudiante = findById(id);
        if (estudiante == null) {
            return Optional.empty();
        }

        estudiante.setNombre(datosActualizados.getNombre());
        estudiante.setApellido(datosActualizados.getApellido());
        estudiante.setFechaNacimiento(datosActualizados.getFechaNacimiento());
        estudiante.setGenero(datosActualizados.getGenero());

        return Optional.of(estudiante);
    }

    @Transactional
    public boolean eliminar(Integer id) {
        return deleteById(id);
    }
}
