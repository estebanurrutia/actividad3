package modelo;

import java.util.Date;

public class EmpleadoPermanente extends Empleado {
    private double salarioBase;
    private double bonificacionAnual;
    private int anosServicio;
    
    public EmpleadoPermanente(String id, String nombre, String apellido, 
                             String email, Date fechaContratacion, 
                             double salarioBase, double bonificacionAnual) {
        super(id, nombre, apellido, email, fechaContratacion);
        this.salarioBase = salarioBase;
        this.bonificacionAnual = bonificacionAnual;
    }
    
    @Override
    public double calcularSalario() {
        return salarioBase + (bonificacionAnual * anosServicio);
    }
    
    // Getters y setters adicionales
    public double getSalarioBase() { return salarioBase; }
    public void setSalarioBase(double salarioBase) { this.salarioBase = salarioBase; }
    
    public double getBonificacionAnual() { return bonificacionAnual; }
    public void setBonificacionAnual(double bonificacionAnual) { 
        this.bonificacionAnual = bonificacionAnual; 
    }
    
    public int getAnosServicio() { return anosServicio; }
    public void setAnosServicio(int anosServicio) { 
        this.anosServicio = anosServicio; 
    }
}
