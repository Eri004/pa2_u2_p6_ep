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

@Table(name="alumno")
@Entity
public class Alumno {

    @SequenceGenerator(name="alumno_seq_generator", sequenceName="alumno_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="alumno_seq_generator")
    @Id
    @Column(name="alu_id")
    private Integer id;

    @Column(name="alu_nombre")
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "alumno_materia",joinColumns=@JoinColumn(name="alma_id_alumno"), inverseJoinColumns=@JoinColumn(name="alma_id_materia"))      
    List <Materia> materias;
    

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

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public String toString() {
        return "Alumno [id=" + id + ", nombre=" + nombre + ", materias=" + listarMaterias() + "]";
    }

    private String listarMaterias() {
        StringBuilder sb = new StringBuilder();
        for (Materia materia : materias) {
            sb.append(materia.getNombre()).append(", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2); // Eliminar la última coma y espacio
        }
        return sb.toString();
    } 

    
}
