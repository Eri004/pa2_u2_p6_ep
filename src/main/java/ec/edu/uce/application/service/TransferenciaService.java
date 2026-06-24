package ec.edu.uce.application.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.domain.model.Cuenta;
import ec.edu.uce.domain.model.Transferencia;
import ec.edu.uce.domain.repository.TransferenciaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class TransferenciaService {

    @Inject
    TransferenciaRepository transferenciaRepository;

    @Inject 
    CuentaService cuentaService;

    public void crearTransferencia(Transferencia transferencia) {
        transferenciaRepository.persist(transferencia);
    }

    public Transferencia obtenerTransferenciaPorId(Integer id) {
        return transferenciaRepository.findById(Long.valueOf(id));
    }

    public List<Transferencia> obtenerTodasLasTransferencias() {
        return transferenciaRepository.listAll();
    }

    public void transferir(String numeroCuentaOrigen, String numeroCuentaDestino, BigDecimal monto) {

        // Obtener las cuentas de origen y destino
        Cuenta cuentaOrigen = cuentaService.obtenerCuentaPorNumero(numeroCuentaOrigen);
        Cuenta cuentaDestino = cuentaService.obtenerCuentaPorNumero(numeroCuentaDestino);

        // Verificar si las cuentas existen
        if (cuentaOrigen == null || cuentaDestino == null) {
            System.out.println("Una o ambas cuentas no existen");
            return;
        }   
        else if (cuentaOrigen.getSaldo().compareTo(monto) < 0) {
            System.out.println("Saldo insuficiente en la cuenta de origen");
            return;
        }
        else{
            //Realizar Transferencia

            Transferencia transferencia = new Transferencia();
            transferencia.setMonto(monto);
            transferencia.setCuentaOrigen(cuentaOrigen);
            transferencia.setCuentaDestino(cuentaDestino);
            transferencia.setFecha(LocalDate.now());
            
            cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(monto));
            cuentaDestino.setSaldo(cuentaDestino.getSaldo().add(monto));

           // Actualizar cuentas con esta transferencia
            transferenciaRepository.persist(transferencia);
            System.out.println("Transferencia realizada con éxito");
        }
        


        
    }
}
