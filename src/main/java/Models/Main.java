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
    Calzado c = new Calzado();
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

    CalzadoDAO dao = new CalzadoDAO();
    dao.insertar(c);
    List<Calzado> calzados = dao.obtenerTodos();
    for (Calzado d : calzados) {
        System.out.println("Código: " + d.getCodigo() +
                           ", Descripción: " + d.getDescripcion() +
                           ", Marca: " + d.getMarca() +
                           ", Precio Venta: " + d.getPrecioVenta() +
                           ", Sucursal ID: " + d.getSucursal().getId());
    }
     System.out.println("\n\n");
        System.out.println("LISTADO CON POCO STOCK\n");
    List<Calzado> calza2 = dao.listarCalzadoConStockBajo();
    for (Calzado e : calza2) {
        System.out.println("Código: " + e.getCodigo() +
                           ", Marca: " + e.getMarca() );                   
    }

        
    
    }
}