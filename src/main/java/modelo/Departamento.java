package modelo;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String codigo;
    private String nombre;
    private String descripcion;
    private List<Empleado> empleados;
    
    public Departamento(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.empleados = new ArrayList<>();
    }
    
    // Métodos para gestionar empleados
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        empleado.setDepartamento(this);
    }
    
    public void removerEmpleado(Empleado empleado) {
        empleados.remove(empleado);
        empleado.setDepartamento(null);
    }
    
    // Getters y setters
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public List<Empleado> getEmpleados() { return new ArrayList<>(empleados); }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    @Override
    public String toString() {
        return nombre + " (" + codigo + ")";
    }
}
