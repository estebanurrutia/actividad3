package servicios;

import modelo.EmpleadoPermanente;
import modelo.EmpleadoTemporal;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class GestionEmpleadosTest {
    @Test
    public void testAgregarYBuscarEmpleado() {
        GestionEmpleados gestion = new GestionEmpleados();
        Date fecha = new Date();
        
        EmpleadoPermanente emp = new EmpleadoPermanente(
            "EMP001", "Juan", "Perez", "juan@example.com", 
            fecha, 3000, 500
        );
        
        gestion.agregarEmpleado(emp);
        Empleado encontrado = gestion.buscarEmpleado("EMP001");
        
        assertNotNull(encontrado);
        assertEquals("Juan", encontrado.getNombre());
        assertEquals("Perez", encontrado.getApellido());
    }
    
    @Test
    public void testEliminarEmpleado() {
        GestionEmpleados gestion = new GestionEmpleados();
        Date fecha = new Date();
        
        EmpleadoTemporal emp = new EmpleadoTemporal(
            "TEMP001", "Maria", "Gomez", "maria@example.com", 
            fecha, 15.5, 160, new Date()
        );
        
        gestion.agregarEmpleado(emp);
        boolean eliminado = gestion.eliminarEmpleado("TEMP001");
        
        assertTrue(eliminado);
        assertNull(gestion.buscarEmpleado("TEMP001"));
    }
}
