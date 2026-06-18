package ec.edu.uce.domain.model;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Entity
@Table(name="pedido")

public class Pedido {

    @SequenceGenerator(name="pedido_seq", sequenceName="pedido_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pedido_seq")
    @Id
    @Column(name="ped_id")
    private Integer id;
    @Column(name="ped_fecha")
    private LocalDate fecha;

    @Column(name="ped_total")
    private Long total;

    @ManyToOne
    private Cliente cliente;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    

}
