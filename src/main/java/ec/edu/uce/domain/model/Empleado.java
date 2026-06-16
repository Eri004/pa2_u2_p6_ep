package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleado")

public class Empleado {

    @Id
    @Column(name = "empl_id")    
    @SequenceGenerator(name = "empleado_seq", sequenceName = "empleado_seq", allocationSize = 1)
    @GeneratedValue(generator = "empleado_seq")
    private Integer id;

    @Column(name = "empl_nombre" )
    private String nombre;

    @Column(name = "empl_apellido")
    private String apellido;

    @Column(name = "empl_cargo" )
    private String cargo;

    @Column(name = "empl_fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "empl_salario")
    private Double salario;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name= "empl_ciudadano")
    private Ciudadano ciudadano;

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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
     public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
     }
        public void setFechaNacimiento(LocalDate fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }
    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }   
    @Override
    public String toString() {
        return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido="
                + apellido + ", cargo=" + cargo + ", fechaNacimiento=" + fechaNacimiento + ", salario=" + salario
                + ", ciudadano=" + ciudadano + "]";
    }

}
