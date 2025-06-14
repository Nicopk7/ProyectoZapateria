/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author elise
 */
public class Main {
    public static void main(String[] args){
    Calzado c = new Calzado();
    c.setCodigo(1010);
    c.setDescripcion("Zapatilla urbana");
    c.setMarca("Nike");
    c.setPrecioCosto(20000);
    c.setPrecioVenta(30000);
    c.setColor("Negro");
    c.setTalle(42);
    c.setCantStock(25);
    
    Sucursal s = new Sucursal();
        s.setId(1); // ID de sucursal existente en la base de datos
        c.setSucursal(s);

    CalzadoDAO dao = new CalzadoDAO();
    dao.insertar(c);
    
    }}