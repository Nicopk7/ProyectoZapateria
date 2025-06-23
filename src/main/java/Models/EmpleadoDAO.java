package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
     public void insertar(Empleado e) {
        String sql = "INSERT INTO empleado (dni, nombre, legajo, domicilio, telefono, antiguedad, sucursal_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, e.getLegajo());
            stmt.setString(2, e.getNombre());
            stmt.setString(3, e.getDni());
            stmt.setString(4, e.getDomicilio());
            stmt.setString(5, e.getTelefono());
            stmt.setInt(6, e.getAntiguedad());
            stmt.setInt(7, e.getSucursal().getId());
       
            stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

public List<Empleado> obtenerTodos() {
    List<Empleado> lista = new ArrayList<>();

    String sql = "SELECT dni, nombre, legajo, domicilio, telefono, antiguedad, sucursal_id FROM empleado";

    try (Connection conn = ConexionDB.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Empleado e = new Empleado();

            e.setDni(rs.getString("dni"));
            e.setNombre(rs.getString("nombre"));
            e.setLegajo(rs.getInt("legajo"));
            e.setDomicilio(rs.getString("domicilio"));
            e.setTelefono(rs.getString("telefono"));
            e.setAntiguedad(rs.getInt("antiguedad"));

            Sucursal sucursal = new Sucursal();
            sucursal.setId(rs.getInt("sucursal_id"));
            e.setSucursal(sucursal);

            lista.add(e);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

public Empleado buscarEmpleado(String x) {
    Empleado e = null; // Importante inicializar en null
    String sql = "SELECT * FROM empleado WHERE dni = ?";
    
    try (Connection conn = ConexionDB.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, x);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                e = new Empleado();
                e.setDni(rs.getString("dni"));
                e.setLegajo(rs.getInt("legajo"));
                e.setNombre(rs.getString("nombre"));
                e.setLegajo(rs.getInt("legajo"));
                e.setDomicilio(rs.getString("domicilio"));
                e.setTelefono(rs.getString("telefono"));
                e.setAntiguedad(rs.getInt("antiguedad"));

                Sucursal sucursal = new Sucursal();
                sucursal.setId(rs.getInt("sucursal_id"));
                e.setSucursal(sucursal);
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return e; // Retorna null si no encontró nada
}

}