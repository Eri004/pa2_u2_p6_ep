package ec.edu.uce.tarea.application.service;

import java.util.List;

import ec.edu.uce.tarea.domain.model.Departamento;
import ec.edu.uce.tarea.infrastructure.repository.DepartamentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class DepartamentoService {

    @Inject 
    DepartamentoRepository departamentoRepository;  

    public void guardar (Departamento departamento){
    this.departamentoRepository.persist(departamento);
    }

    public Departamento buscarPorId(Integer id){
        return this.departamentoRepository.findById(Long.valueOf(id));
    }

    public List<Departamento> buscarTodos(){
        return this.departamentoRepository.listAll();
    }
    
}
