package ec.edu.uce.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="materia")
@Entity
public class Materia {

    @SequenceGenerator(name="materia_seq_generator", sequenceName="materia_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="materia_seq_generator")
    @Id
    @Column(name="mat_id")
    private Integer id;
    @Column(name="mat_nombre")
    private String nombre;
    @Column(name="mat_creditos")
    private Integer creditos;

    @ManyToMany(mappedBy = "materias",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List <Alumno> alumnos;

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
    public Integer getCreditos() {
        return creditos;
    }
    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }
    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    @Override
    public String toString() {
        return "Materia [id=" + id + ", nombre=" + nombre + ", creditos=" + creditos ;
    }

    

}
