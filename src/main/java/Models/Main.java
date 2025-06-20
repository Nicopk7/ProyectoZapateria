/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import Models.Interfaces.PantallaPrincipal;
import java.util.List;

/**
 *
 * @author elise
 */
public class Main {
    public static void main(String[] args){
    /*Calzado c = new Calzado();
    c.setCodigo(1042);
    c.setDescripcion("Deportivo Running ");
    c.setMarca("Nike");
    c.setPrecioCosto(30000);
    c.setPrecioVenta(50000);
    c.setColor("AZUL y VERDE");
    c.setTalle(40);
    c.setCantStock(1);
    */
    
    Empleado e = new Empleado();
    e.setLegajo(3);
    e.setNombre("Carlitos");
    e.setDni("44300400");
    e.setDomicilio("Viva milei");
    e.setTelefono("12345678910");
    e.setAntiguedad(3);
    
    Sucursal s = new Sucursal();
        s.setId(1); // ID de sucursal existente en la base de datos
        e.setSucursal(s);
        

    EmpleadoDAO dao = new EmpleadoDAO();
    dao.insertar(e);
    List<Empleado> empleados = dao.obtenerTodos();
    for (Empleado d : empleados) {
        System.out.println("Legajo: " + d.getLegajo() +
                           ", Nombre: " + d.getNombre() +
                           ", DNI: " + d.getDni() +
                           ", Domicilio: " + d.getDomicilio() +
                           "Telefono:" + d.getTelefono() +
                           "Antiguedad:" + d.getAntiguedad() +
                           ", Sucursal ID: " + d.getSucursal().getId()) ;
    }
     System.out.println("\n\n");
        System.out.println("LISTADO CON POCO STOCK\n");
    /*List<Calzado> calza2 = dao.listarCalzadoConStockBajo();
    for (Calzado e : calza2) {
        System.out.println("Código: " + e.getCodigo() +
                           ", Marca: " + e.getMarca() );                   
    }*/

    System.out.println("\n\n");
    System.out.println("Encontrado?");
    String dni_abuscar = "44300400";
    Empleado encontrado = new Empleado();
    encontrado = dao.buscarEmpleado(dni_abuscar);
    System.out.println("Legajo: " + encontrado.getLegajo() +
                           ", Nombre: " + encontrado.getNombre() +
                           ", DNI: " + encontrado.getDni() +
                           ", Domicilio: " + encontrado.getDomicilio() +
                           "Telefono:" + encontrado.getTelefono() +
                           "Antiguedad:" + encontrado.getAntiguedad() +
                           ", Sucursal ID: " + encontrado.getSucursal().getId()) ;
    
    }
}