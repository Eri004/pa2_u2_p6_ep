package ec.edu.uce.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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

@Entity
@Table(name = "transferencia")
public class Transferencia {

    @Id
    @SequenceGenerator(name = "transferencia_seq", sequenceName = "transferencia_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transferencia_seq")
    @Column(name = "tra_id")
    private Integer id; 

    @Column(name = "tra_monto")
    private BigDecimal monto;

    @Column(name = "tra_fecha")
    private LocalDate fecha;

    @ManyToOne (cascade= CascadeType.ALL)
    @JoinColumn(name = "cue_trasferencia_origen")
    private Cuenta cuentaOrigen;

    @ManyToOne (cascade= CascadeType.ALL)
    @JoinColumn(name = "cue_trasferencia_destino")
    private Cuenta cuentaDestino;

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    
}
