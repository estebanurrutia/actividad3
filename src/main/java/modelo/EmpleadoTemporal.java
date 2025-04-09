package modelo;

import java.util.Date;

public class EmpleadoTemporal extends Empleado {
    private double salarioPorHora;
    private int horasTrabajadas;
    private Date fechaFinContrato;
    
    public EmpleadoTemporal(String id, String nombre, String apellido, 
                           String email, Date fechaContratacion, 
                           double salarioPorHora, int horasTrabajadas, 
                           Date fechaFinContrato) {
        super(id, nombre, apellido, email, fechaContratacion);
        this.salarioPorHora = salarioPorHora;
        this.horasTrabajadas = horasTrabajadas;
        this.fechaFinContrato = fechaFinContrato;
    }
    
    @Override
    public double calcularSalario() {
        return salarioPorHora * horasTrabajadas;
    }
    
    // Getters y setters adicionales
    public double getSalarioPorHora() { return salarioPorHora; }
    public void setSalarioPorHora(double salarioPorHora) { 
        this.salarioPorHora = salarioPorHora; 
    }
    
    public int getHorasTrabajadas() { return horasTrabajadas; }
    public void setHorasTrabajadas(int horasTrabajadas) { 
        this.horasTrabajadas = horasTrabajadas; 
    }
    
    public Date getFechaFinContrato() { return fechaFinContrato; }
    public void setFechaFinContrato(Date fechaFinContrato) { 
        this.fechaFinContrato = fechaFinContrato; 
    }
}
