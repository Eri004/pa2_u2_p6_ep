package ec.edu.uce.domain.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cuenta")
public class Cuenta {

    @Id
    @Column(name = "cue_id")
    @SequenceGenerator(name = "cuenta_seq", sequenceName = "cuenta_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuenta_seq")
    private Integer id;
    
    @Column(name = "cue_numeroCuenta")
    private String numeroCuenta;

    @Column(name = "cue_saldo")
    private BigDecimal saldo;

    /* @OneToMany(mappedBy = "cuentaOrigen", cascade = CascadeType.ALL)
    private List<Transferencia> transferenciasOrigen;

    @OneToMany(mappedBy = "cuentaDestino", cascade = CascadeType.ALL)
    private List<Transferencia> transferenciasDestino;
 */

   


    /* public List<Transferencia> getTransferenciasOrigen() {
        return transferenciasOrigen;
    }

    public void setTransferenciasOrigen(List<Transferencia> transferenciasOrigen) {
        this.transferenciasOrigen = transferenciasOrigen;
    }

    public List<Transferencia> getTransferenciasDestino() {
        return transferenciasDestino;
    }

    public void setTransferenciasDestino(List<Transferencia> transferenciasDestino) {
        this.transferenciasDestino = transferenciasDestino;
    } */

    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                '}';
            }





}
