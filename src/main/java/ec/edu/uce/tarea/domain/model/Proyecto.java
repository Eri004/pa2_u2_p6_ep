package ec.edu.uce.tarea.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyecto")
public class Proyecto {

    @SequenceGenerator(name = "seq_proyecto_generator", sequenceName = "seq_proyecto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_proyecto_generator")
    @Id
    @Column(name = "proy_id")
    private Integer id;

    @Column(name = "proy_titulo")
    private String titulo;

    @Column(name = "proy_tipo")
    private String tipo;

    @ManyToOne
    private Profesor profesor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Proyecto [id=" + id + ", titulo=" + titulo + ", tipo=" + tipo + ", profesor=" + profesor + "]";
    }

    

}
