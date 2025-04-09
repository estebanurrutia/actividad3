package servicios;

import modelo.ReporteDesempeno;
import modelo.Empleado;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ReporteService {
    private List<ReporteDesempeno> reportes;
    
    public ReporteService() {
        reportes = new ArrayList<>();
    }
    
    public void generarReporte(Empleado empleado, Date fechaEvaluacion,
                             double productividad, double calidadTrabajo,
                             double trabajoEquipo, String comentarios) {
        ReporteDesempeno reporte = new ReporteDesempeno(
            empleado, fechaEvaluacion, productividad, 
            calidadTrabajo, trabajoEquipo, comentarios
        );
        reportes.add(reporte);
    }
    
    public List<ReporteDesempeno> obtenerReportesPorEmpleado(Empleado empleado) {
        List<ReporteDesempeno> resultado = new ArrayList<>();
        for (ReporteDesempeno r : reportes) {
            if (r.getEmpleado().equals(empleado)) {
                resultado.add(r);
            }
        }
        return resultado;
    }
    
    public double calcularPromedioDepartamento(String codigoDepartamento) {
        double suma = 0;
        int contador = 0;
        
        for (ReporteDesempeno r : reportes) {
            if (r.getEmpleado().getDepartamento() != null && 
                r.getEmpleado().getDepartamento().getCodigo().equals(codigoDepartamento)) {
                suma += r.calcularPromedio();
                contador++;
            }
        }
        
        return contador > 0 ? suma / contador : 0;
    }
}
