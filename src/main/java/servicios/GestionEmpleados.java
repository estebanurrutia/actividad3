package servicios;

import modelo.Empleado;
import modelo.EmpleadoPermanente;
import modelo.EmpleadoTemporal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class GestionEmpleados {
    private List<Empleado> empleados;
    
    public GestionEmpleados() {
        empleados = new ArrayList<>();
    }
    
    // Métodos CRUD para empleados
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }
    
    public boolean eliminarEmpleado(String id) {
        return empleados.removeIf(e -> e.getId().equals(id));
    }
    
    public Empleado buscarEmpleado(String id) {
        return empleados.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(empleados);
    }
    
    public List<EmpleadoPermanente> listarEmpleadosPermanentes() {
        List<EmpleadoPermanente> permanentes = new ArrayList<>();
        for (Empleado e : empleados) {
            if (e instanceof EmpleadoPermanente) {
                permanentes.add((EmpleadoPermanente) e);
            }
        }
        return permanentes;
    }
    
    public List<EmpleadoTemporal> listarEmpleadosTemporales() {
        List<EmpleadoTemporal> temporales = new ArrayList<>();
        for (Empleado e : empleados) {
            if (e instanceof EmpleadoTemporal) {
                temporales.add((EmpleadoTemporal) e);
            }
        }
        return temporales;
    }
    
    public void actualizarEmpleado(Empleado empleadoActualizado) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getId().equals(empleadoActualizado.getId())) {
                empleados.set(i, empleadoActualizado);
                break;
            }
        }
    }
}
