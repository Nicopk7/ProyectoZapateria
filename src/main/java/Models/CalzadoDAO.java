/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CalzadoDAO {
     public void insertar(Calzado c) {
        String sql = "INSERT INTO calzado (codigo, descripcion, marca, precio_costo, precio_venta, color, talle, cant_stock, sucursal_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, c.getCodigo());
            stmt.setString(2, c.getDescripcion());
            stmt.setString(3, c.getMarca());
            stmt.setDouble(4, c.getPrecioCosto());
            stmt.setDouble(5, c.getPrecioVenta());
            stmt.setString(6, c.getColor());
            stmt.setInt(7, c.getTalle());
            stmt.setInt(8, c.getCantStock());
            stmt.setInt(9, c.getSucursal().getId()); // Sucursal debe tener método getId()

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public List<Calzado> listarCalzadoConStockBajo() {
        List<Calzado> calzados = new ArrayList<>();
        String sql = "SELECT codigo,marca FROM calzado WHERE cant_stock < 5";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Calzado d=new Calzado();

                d.setCodigo(rs.getInt("codigo"));
                d.setMarca(rs.getString("marca"));
                calzados.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return calzados;
    }
public List<Calzado> obtenerTodos() {
    List<Calzado> lista = new ArrayList<>();

    String sql = "SELECT codigo, descripcion, marca, precio_costo, precio_venta, color, talle, cant_stock, sucursal_id FROM calzado";

    try (Connection conn = ConexionDB.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Calzado c = new Calzado();

            c.setCodigo(rs.getInt("codigo"));
            c.setDescripcion(rs.getString("descripcion"));
            c.setMarca(rs.getString("marca"));
            c.setPrecioCosto(rs.getDouble("precio_costo"));
            c.setPrecioVenta(rs.getDouble("precio_venta"));
            c.setColor(rs.getString("color"));
            c.setTalle(rs.getInt("talle"));
            c.setCantStock(rs.getInt("cant_stock"));

            // Crear la sucursal y setear su ID
            Sucursal sucursal = new Sucursal();
            sucursal.setId(rs.getInt("sucursal_id"));
            c.setSucursal(sucursal);

            lista.add(c);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}
}