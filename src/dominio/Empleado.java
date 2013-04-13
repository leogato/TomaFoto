package dominio;
// Generated 10-mar-2013 18:44:40 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {


     private Integer idEmpleado;
     private Empresa empresa;
     private int legajo;
     private String nombre;
     private String clave;
     private Set<Asistencia> asistencias = new TreeSet<Asistencia>(new OrdenarAsistenciaPorId());

    public Empleado() {
    }

    public Empleado( int legajo, String nombre, String clave) {
        
        this.legajo = legajo;
        this.nombre = nombre;
        this.clave = clave;
    }

	
    
   
    public Integer getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public int getLegajo() {
        return this.legajo;
    }
    
    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public Set<Asistencia> getAsistencias() {
        return this.asistencias;
    }
    
    public void setAsistencias(Set<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }




}


