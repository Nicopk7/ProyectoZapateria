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

public List<String> listarCalzadoConStockBajo() {
        List<String> calzados = new ArrayList<>();
        String sql = "SELECT descripcion FROM calzado WHERE CantStock < 5";

        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String descripcion = rs.getString("descripcion");
                calzados.add(descripcion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return calzados;
    }
}