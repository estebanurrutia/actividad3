package servicios;

import modelo.Departamento;
import modelo.Empleado;
import java.util.List;
import java.util.ArrayList;

public class GestionDepartamentos {
    private List<Departamento> departamentos;
    
    public GestionDepartamentos() {
        departamentos = new ArrayList<>();
    }
    
    // Métodos CRUD para departamentos
    public void agregarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }
    
    public boolean eliminarDepartamento(String codigo) {
        return departamentos.removeIf(d -> d.getCodigo().equals(codigo));
    }
    
    public Departamento buscarDepartamento(String codigo) {
        return departamentos.stream()
                .filter(d -> d.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }
    
    public List<Departamento> listarDepartamentos() {
        return new ArrayList<>(departamentos);
    }
    
    public void asignarEmpleadoADepartamento(Empleado empleado, Departamento departamento) {
        // Primero quitamos al empleado de cualquier departamento actual
        Departamento departamentoActual = empleado.getDepartamento();
        if (departamentoActual != null) {
            departamentoActual.removerEmpleado(empleado);
        }
        
        // Asignamos al nuevo departamento
        departamento.agregarEmpleado(empleado);
    }
}
