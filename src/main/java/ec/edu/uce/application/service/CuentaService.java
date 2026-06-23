package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Cuenta;
import ec.edu.uce.domain.repository.CuentaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class CuentaService {

    @Inject
    CuentaRepository cuentaRepository;

    @Inject 
    EntityManager entityManager;

    public void crearCuenta(Cuenta cuenta) {
        cuentaRepository.persist(cuenta);
    }

    public Cuenta obtenerCuentaPorId(Integer id) {
        return cuentaRepository.findById(Long.valueOf(id));
    }

    public Cuenta obtenerCuentaPorNumero(String numeroCuenta) {

       TypedQuery<Cuenta> query = entityManager.createQuery(
        "SELECT c FROM Cuenta c WHERE c.numeroCuenta = :numeroCuenta", Cuenta.class);
        query.setParameter("numeroCuenta", numeroCuenta);
        return query.getSingleResult();
    }

    public void actualizarCuenta(Integer id, Cuenta cuenta) {

        Cuenta cuentaExistente = cuentaRepository.findById(Long.valueOf(id));
        if (cuentaExistente != null) {
            cuentaExistente.setNumeroCuenta(cuenta.getNumeroCuenta());
            cuentaExistente.setSaldo(cuenta.getSaldo());
            entityManager.merge(cuentaExistente);
        }
    }

    public void eliminarCuenta(Integer id) {
        Cuenta cuentaExistente = cuentaRepository.findById(Long.valueOf(id));
        if (cuentaExistente != null) {
            cuentaRepository.delete(cuentaExistente);
        }
    }
    
}
