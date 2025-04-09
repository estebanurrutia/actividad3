package modelo;

import java.util.Date;

public abstract class Empleado {
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaContratacion;
    private Departamento departamento;
    
    public Empleado(String id, String nombre, String apellido, String email, Date fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaContratacion = fechaContratacion;
    }
    
    // Getters y setters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public Date getFechaContratacion() { return fechaContratacion; }
    public Departamento getDepartamento() { return departamento; }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    // Método abstracto para calcular salario
    public abstract double calcularSalario();
    
    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + id + ")";
    }
}
