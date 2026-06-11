package ec.edu.uce.tarea.domain.model;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table (name = "oficina")
public class Oficina {

    @Id
    @SequenceGenerator(name = "oficina_seq", sequenceName = "oficina_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "oficina_seq")
    @Column(name = "ofi_id")
    private Integer id;

    @Column(name = "ofi_nombre")
    private String nombre;

    @Column(name = "ofi_codigo")
    private Integer codigo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Oficina [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + "]";
    }
}
