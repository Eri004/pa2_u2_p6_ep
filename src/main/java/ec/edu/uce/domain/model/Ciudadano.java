package ec.edu.uce.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudadano")
public class Ciudadano {

    @Id
    @Column(name = "ciud_id")   
    @SequenceGenerator(name = "ciudadano_seq", sequenceName = "ciudadano_seq", allocationSize = 1)
    @GeneratedValue(generator = "ciudadano_seq") 
    private Integer id;

    @Column(name = "ciud_cedula")
    private String cedula;

    
    @Column(name = "ciud_nombre")
    private String nombre;

    @Column(name = "ciud_apellido")
    private String apellido;

    @Column(name = "ciud_fecha_nacimiento") 
    private LocalDate fechaNacimiento;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
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
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Ciudadano [id=" + id + ", cedula=" + cedula +
                ", nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + "]"; 
    }




}
