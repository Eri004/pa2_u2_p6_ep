package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.domain.repository.CiudadanoRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CiudadanoService {

    @Inject
    private CiudadanoRepositorio ciudadanoRepositorio;
    public void guardar (Ciudadano ciudadano){
        // Lógica para guardar un ciudadano
        ciudadanoRepositorio.crear(ciudadano);
    }   

    public Ciudadano buscarPorId(Integer id){
        // Lógica para buscar un ciudadano por ID
        return ciudadanoRepositorio.encontrarPorId(id);
    }

}
