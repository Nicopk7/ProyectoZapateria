package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
     public void insertar(Cliente c) {
        String sql = "INSERT INTO cliente (nombre, dni_cuil, telefono) " +
                     "VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(2, c.getNombre());
            stmt.setString(3, c.getDNI_CUIL());
            stmt.setString(4, c.getTelefono());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


public List<Cliente> obtenerTodos() {
    List<Cliente> lista = new ArrayList<>();

    String sql = "SELECT nombre, dni_cuil, telefono FROM cliente";

    try (Connection conn = ConexionDB.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Cliente c = new Cliente();

            c.setNombre(rs.getString("nombre"));
            c.setDNI_CUIL(rs.getString("dni_cuil"));
            c.setTelefono(rs.getString("telefono"));

            lista.add(c);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

}
