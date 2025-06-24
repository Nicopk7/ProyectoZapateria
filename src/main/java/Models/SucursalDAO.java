package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SucursalDAO {
     public void insertar(Sucursal s) {
        String sql = "INSERT INTO calzado (id, nombre, domicilio, ciudad) " +
                     "VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, s.getId());
            stmt.setString(2, s.getNombre());
            stmt.setString(3, s.getDomicilio());
            stmt.setString(4, s.getCiudad());
       
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public List<Sucursal> obtenerTodos() {
    List<Sucursal> lista = new ArrayList<>();

    String sql = "SELECT id, nombre, domicilio, ciudad FROM sucursal";

    try (Connection conn = ConexionDB.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Sucursal s = new Sucursal();

            s.setId(rs.getInt("id"));
            s.setNombre(rs.getString("nombre"));
            s.setDomicilio(rs.getString("domicilio"));
            s.setCiudad(rs.getString("ciudad"));
            

            lista.add(s);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

}
