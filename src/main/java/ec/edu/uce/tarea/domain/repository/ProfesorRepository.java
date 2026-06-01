package ec.edu.uce.tarea.domain.repository;

import java.util.List;

import ec.edu.uce.tarea.domain.model.Profesor;

public interface ProfesorRepository {

    public void crear(Profesor profesor);

    public Profesor seleccionar_id(Integer id);

    public void actualizar(Profesor profesor);

    public void eliminar(Integer id);

    public List<Profesor> seleccionarTodo();

    public List<Profesor> seleccionarPorMateria(String materia);

    public Profesor seleccionarPorCorreo(String correo);

    public List<Profesor> seleccionarPorApellido(String apellido);

    public List<Profesor> seleccionarPorNombre(String nombre);

    public Long contarTodo();

    public List<Profesor> seleccionarPorCorreoSensibleNative(String correo);

    public List<Profesor> seleccionarPorNombreOrdenadoNative(String nombre);

    public List<Profesor> buscarApellidoComienzaNative(String prefijo);

}
