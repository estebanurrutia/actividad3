package servicios;

import modelo.Departamento;
import modelo.EmpleadoPermanente;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class GestionDepartamentosTest {
    @Test
    public void testAgregarDepartamento() {
        GestionDepartamentos gestion = new GestionDepartamentos();
        Departamento depto = new Departamento("DEP01", "Ventas", "Departamento de ventas");
        
        gestion.agregarDepartamento(depto);
        Departamento encontrado = gestion.buscarDepartamento("DEP01");
        
        assertNotNull(encontrado);
        assertEquals("Ventas", encontrado.getNombre());
    }
    
    @Test
    public void testAsignarEmpleadoADepartamento() {
        GestionDepartamentos gestionDeptos = new GestionDepartamentos();
        GestionEmpleados gestionEmps = new GestionEmpleados();
        Date fecha = new Date();
        
        Departamento depto = new Departamento("DEP02", "TI", "Tecnologías de Información");
        gestionDeptos.agregarDepartamento(depto);
        
        EmpleadoPermanente emp = new EmpleadoPermanente(
            "EMP002", "Carlos", "Lopez", "carlos@example.com", 
            fecha, 3500, 600
        );
        gestionEmps.agregarEmpleado(emp);
        
        gestionDeptos.asignarEmpleadoADepartamento(emp, depto);
        
        assertEquals(depto, emp.getDepartamento());
        assertTrue(depto.getEmpleados().contains(emp));
    }
}
