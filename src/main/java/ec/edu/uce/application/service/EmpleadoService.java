package ec.edu.uce.application.service;

import java.time.LocalDate;

import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.model.Empleado;
import ec.edu.uce.domain.repository.EmpleadoRepository;
import io.quarkus.narayana.jta.runtime.TransactionConfiguration;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class EmpleadoService {

    @Inject
    EmpleadoRepository empleadoRepository;

    @Inject
    CiudadanoService ciudadanoService;

    @Inject 
    EntityManager em;

    @Transactional
    public void crearEmpleado(Empleado empleado) {
        
        // Ciudadano ciudadano = new Ciudadano();
          /*   ciudadano.setNombre("Ciudadano");
            ciudadano.setApellido("TRES");
            ciudadano.setCedula("0401739295");
            ciudadano.setFechaNacimiento(LocalDate.of(2000, 11, 29));
            ciudadanoService.guardar(ciudadano);

            //Cambio a ciudadano
            ciudadano.setApellido("Modificado");
            empleado.setCiudadano(ciudadano); */


        empleadoRepository.persist(empleado);
    }

    public Empleado buscarEmpleadoPorId(Integer id) {
        return empleadoRepository.findById(Long.valueOf(id));
    }

    public void eliminarEmpleado(Integer id) {
        Empleado empleado = empleadoRepository.findById(Long.valueOf(id));
        if (empleado != null) {
            empleadoRepository.delete(empleado);
        }
    }

    public void actualizarEmpleado (Integer id, Empleado empleado) {
        Empleado empleadoExistente = empleadoRepository.findById(Long.valueOf(id));
        if (empleadoExistente != null) {
            empleadoExistente.setNombre(empleado.getNombre());
            empleadoExistente.setApellido(empleado.getApellido());
            empleadoExistente.setFechaNacimiento(empleado.getFechaNacimiento());
            empleadoExistente.setCargo(empleado.getCargo());
            empleadoExistente.setSalario(empleado.getSalario());
            empleadoExistente.setCiudadano(empleado.getCiudadano());
           this.em.merge(empleadoExistente);
        }
    }
   



}
