package ui;

import modelo.*;
import servicios.*;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class MainApp {
    private static GestionEmpleados gestionEmpleados = new GestionEmpleados();
    private static GestionDepartamentos gestionDepartamentos = new GestionDepartamentos();
    private static ReporteService reporteService = new ReporteService();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public static void main(String[] args) {
        System.out.println("Sistema de Gestión de Recursos Humanos - CompuWork");
        mostrarMenuPrincipal();
    }
    
    private static void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de Empleados");
            System.out.println("2. Gestión de Departamentos");
            System.out.println("3. Reportes de Desempeño");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    mostrarMenuEmpleados();
                    break;
                case 2:
                    mostrarMenuDepartamentos();
                    break;
                case 3:
                    mostrarMenuReportes();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    private static void mostrarMenuEmpleados() {
        while (true) {
            System.out.println("\n=== GESTIÓN DE EMPLEADOS ===");
            System.out.println("1. Agregar Empleado");
            System.out.println("2. Listar Empleados");
            System.out.println("3. Buscar Empleado");
            System.out.println("4. Actualizar Empleado");
            System.out.println("5. Eliminar Empleado");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    agregarEmpleado();
                    break;
                case 2:
                    listarEmpleados();
                    break;
                case 3:
                    buscarEmpleado();
                    break;
                case 4:
                    actualizarEmpleado();
                    break;
                case 5:
                    eliminarEmpleado();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
    
    private static void agregarEmpleado() {
        System.out.println("\n=== AGREGAR EMPLEADO ===");
        System.out.println("1. Empleado Permanente");
        System.out.println("2. Empleado Temporal");
        System.out.print("Seleccione el tipo de empleado: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Fecha de contratación (dd/MM/yyyy): ");
        Date fechaContratacion = leerFecha();
        
        if (tipo == 1) {
            System.out.print("Salario base: ");
            double salarioBase = scanner.nextDouble();
            
            System.out.print("Bonificación anual: ");
            double bonificacionAnual = scanner.nextDouble();
            
            EmpleadoPermanente empleado = new EmpleadoPermanente(
                id, nombre, apellido, email, fechaContratacion, 
                salarioBase, bonificacionAnual
            );
            gestionEmpleados.agregarEmpleado(empleado);
            System.out.println("Empleado permanente agregado con éxito.");
        } else if (tipo == 2) {
            System.out.print("Salario por hora: ");
            double salarioPorHora = scanner.nextDouble();
            
            System.out.print("Horas trabajadas: ");
            int horasTrabajadas = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Fecha fin de contrato (dd/MM/yyyy): ");
            Date fechaFinContrato = leerFecha();
            
            EmpleadoTemporal empleado = new EmpleadoTemporal(
                id, nombre, apellido, email, fechaContratacion,
                salarioPorHora, horasTrabajadas, fechaFinContrato
            );
            gestionEmpleados.agregarEmpleado(empleado);
            System.out.println("Empleado temporal agregado con éxito.");
        } else {
            System.out.println("Opción no válida.");
        }
    }
    
    private static void listarEmpleados() {
        System.out.println("\n=== LISTA DE EMPLEADOS ===");
        List<Empleado> empleados = gestionEmpleados.listarEmpleados();
        
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado e : empleados) {
                System.out.println(e);
                if (e.getDepartamento() != null) {
                    System.out.println("  Departamento: " + e.getDepartamento().getNombre());
                }
                System.out.println("  Salario: " + e.calcularSalario());
                System.out.println();
            }
        }
    }
    
    // Métodos similares para buscar, actualizar y eliminar empleados
    // Métodos para gestión de departamentos
    // Métodos para reportes de desempeño
    
    private static Date leerFecha() {
        while (true) {
            try {
                String fechaStr = scanner.nextLine();
                return dateFormat.parse(fechaStr);
            } catch (ParseException e) {
                System.out.print("Formato de fecha inválido (dd/MM/yyyy). Intente nuevamente: ");
            }
        }
    }
}
