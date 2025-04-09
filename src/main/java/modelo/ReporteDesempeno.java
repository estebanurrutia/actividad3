package modelo;

import java.util.Date;

public class ReporteDesempeno {
    private Empleado empleado;
    private Date fechaEvaluacion;
    private double productividad;
    private double calidadTrabajo;
    private double trabajoEquipo;
    private String comentarios;
    
    public ReporteDesempeno(Empleado empleado, Date fechaEvaluacion, 
                           double productividad, double calidadTrabajo, 
                           double trabajoEquipo, String comentarios) {
        this.empleado = empleado;
        this.fechaEvaluacion = fechaEvaluacion;
        this.productividad = productividad;
        this.calidadTrabajo = calidadTrabajo;
        this.trabajoEquipo = trabajoEquipo;
        this.comentarios = comentarios;
    }
    
    public double calcularPromedio() {
        return (productividad + calidadTrabajo + trabajoEquipo) / 3;
    }
    
    // Getters
    public Empleado getEmpleado() { return empleado; }
    public Date getFechaEvaluacion() { return fechaEvaluacion; }
    public double getProductividad() { return productividad; }
    public double getCalidadTrabajo() { return calidadTrabajo; }
    public double getTrabajoEquipo() { return trabajoEquipo; }
    public String getComentarios() { return comentarios; }
    
    @Override
    public String toString() {
        return "Reporte de " + empleado.getNombre() + " - Puntuación: " + calcularPromedio();
    }
}
