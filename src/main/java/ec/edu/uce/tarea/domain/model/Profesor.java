package ec.edu.uce.tarea.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table (name = "profesor")
@NamedQueries({
    @NamedQuery(name = "Profesor.contarTodo", query = "SELECT COUNT(p) FROM Profesor p"),
    @NamedQuery(name = "Profesor.seleccionarPorApellido", query = "SELECT p FROM Profesor p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Profesor.seleccionarPorNombre", query = "SELECT p FROM Profesor p WHERE p.nombre = :nombre")
}   )   
public class Profesor {
     
    @SequenceGenerator(name = "seq_profesor_generator", sequenceName = "seq_profesor", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profesor_generator")
    @Id
    @Column(name = "prof_id")
    private Integer id;
    @Column(name = "prof_nombre")
    private String nombre;
    @Column(name = "prof_apellido")
    private String apellido;
    @Column(name = "prof_materia")
    private String materia;
    @Column(name = "prof_direccion")
    private String direccion;
    @Column(name="prof_correo")
    private String correo;

    @OneToOne (cascade=CascadeType.ALL)
    @JoinColumn (name = "prof_oficina")
    private Oficina oficina;

    @OneToMany(mappedBy = "profesor",cascade = CascadeType.ALL)
    private List<Proyecto> proyectos;

    public Integer getId() {
        return id;
    }
    public void setId(Integer   id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

        public Oficina getOficina() {
            return oficina;
        }
        public void setOficina(Oficina oficina) {
            this.oficina = oficina;
        }   

        public List<Proyecto> getProyectos() {
            return proyectos;
        }
        public void setProyectos(List<Proyecto> proyectos) {
            this.proyectos = proyectos;
        }
    

    @Override
            public String toString() {
                return "Profesor [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", materia=" + materia + ", direccion=" + direccion + ", correo=" + correo + 
                ", oficina=" + oficina.getId() + "]";

    }
    
}

