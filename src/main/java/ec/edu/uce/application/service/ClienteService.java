package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Cliente;
import ec.edu.uce.domain.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    public void guardar (Cliente cliente){
        this.clienteRepository.persist(cliente);
    }

    public Cliente buscarPorId(Integer id){
        return this.clienteRepository.findById(Long.valueOf(id));
    }
}
