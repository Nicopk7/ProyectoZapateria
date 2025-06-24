package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
     public void insertar(Cliente c) {
        String sql = "INSERT INTO cliente (dni_cuil, nombre, telefono) " +
                     "VALUES (?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getDNI_CUIL());
            stmt.setString(2, c.getNombre());
            stmt.setString(3, c.getTelefono());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


public List<Cliente> obtenerTodos() {
    List<Cliente> lista = new ArrayList<>();

    String sql = "SELECT dni_cuil, nombre, telefono FROM cliente";

    try (Connection conn = ConexionDB.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Cliente c = new Cliente();
            c.setDNI_CUIL(rs.getString("dni_cuil"));
            c.setNombre(rs.getString("nombre")); 
            c.setTelefono(rs.getString("telefono"));
            lista.add(c);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}
public Cliente buscarCliente(String x) {
    Cliente c = null; // inicializar en null
    String sql = "SELECT dni_cuil, nombre, telefono FROM cliente WHERE dni_cuil = ?";
    
    try (Connection conn = ConexionDB.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, x);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                c = new Cliente();
                c.setDNI_CUIL(rs.getString("dni_cuil"));
                c.setNombre(rs.getString("nombre"));
                c.setTelefono(rs.getString("telefono"));
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return c; 
}

}
