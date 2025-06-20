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
//--------------------------------------------------------------------------------------
 /*   Calzado c = new Calzado();
    c.setCodigo(1042);
    c.setDescripcion("Deportivo Running ");
    c.setMarca("Nike");
    c.setPrecioCosto(30000);
    c.setPrecioVenta(50000);
    c.setColor("AZUL y VERDE");
    c.setTalle(40);
    c.setCantStock(1);
    Sucursal s = new Sucursal();
        s.setId(1); // ID de sucursal existente en la base de datos
        c.setSucursal(s);
 CalzadoDAO dao1 = new CalzadoDAO();
    dao1.insertar(c);
Calzado calzadoEncontrado = new Calzado();
calzadoEncontrado = dao1.buscarCalzado("1010"); // Código que quieres consultar

if (calzadoEncontrado != null) {
    System.out.println("Código: " + calzadoEncontrado.getCodigo() +
                       ", Descripción: " + calzadoEncontrado.getDescripcion() +
                       ", Marca: " + calzadoEncontrado.getMarca() +
                       ", Precio Costo: " + calzadoEncontrado.getPrecioCosto() +
                       ", Precio Venta: " + calzadoEncontrado.getPrecioVenta() +
                       ", Color: " + calzadoEncontrado.getColor() +
                       ", Talle: " + calzadoEncontrado.getTalle() +
                       ", Cantidad en Stock: " + calzadoEncontrado.getCantStock() +
                       ", Sucursal ID: " + calzadoEncontrado.getSucursal().getId()) ;
} else {
    System.out.println("Calzado no encontrado para el código: " + "1010");
}
*/
    
    //--------------------------------------------------------------------
    Empleado e = new Empleado();
    e.setLegajo(1);
    e.setNombre("Eliseo Vottero");
    e.setDni("44333444");
    e.setDomicilio("Peronista 126");
    e.setTelefono("2664444040");
    e.setAntiguedad(4);
    Sucursal q = new Sucursal();
        q.setId(1); // ID de sucursal existente en la base de datos
        e.setSucursal(q);
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
        //System.out.println("LISTADO CON POCO STOCK\n");
    /*List<Calzado> calza2 = dao.listarCalzadoConStockBajo();
    for (Calzado e : calza2) {
        System.out.println("Código: " + e.getCodigo() +
                           ", Marca: " + e.getMarca() );                   
    }*/
//------------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------

/*Cliente t = new Cliente();
t.setNombre("Carlos");
t.setDNI_CUIL("44300400");
t.setTelefono("123456789");
ClienteDAO daocliente = new ClienteDAO();
daocliente.insertar(t);


List<Cliente> clientes = daocliente.obtenerTodos(); // Obtienes la lista de clientes
for (Cliente p : clientes) {
    System.out.println("Nombre: " + p.getNombre() +
                       ", DNI/CUIL: " + p.getDNI_CUIL() +
                       ", Telefono: " + p.getTelefono());
*/
}
    }



