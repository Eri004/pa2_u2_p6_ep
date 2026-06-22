package ec.edu.uce.tarea.domain.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento {


        @SequenceGenerator(name="departamento_seq_generator", sequenceName="departamento_seq", allocationSize=1)
        @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="departamento_seq_generator")
        @Id
        @Column(name="dep_id")
        private Integer id;
        @Column(name="dep_nombre")
        private String nombre;
        @Column(name="dep_ubicacion")
        private String ubicacion;

        @ManyToMany (mappedBy = "departamentos", cascade= CascadeType.ALL,fetch = FetchType.EAGER)
        private List<Profesor> profesores;

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

        public String getUbicacion() {
            return ubicacion;
        }

        public void setUbicacion(String ubicacion) {
            this.ubicacion = ubicacion;
        }

        public List<Profesor> getProfesores() {
            return profesores;
        }

        public void setProfesores(List<Profesor> profesores) {
            this.profesores = profesores;
        }

        

        
}
