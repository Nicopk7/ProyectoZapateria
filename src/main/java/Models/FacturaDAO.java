package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
     public void insertar(Factura f) {
        String sql = "INSERT INTO factura (id, cantidad, total, cliente_id) " +
                     "VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, f.getId());
            stmt.setInt(2, f.getCantidad());
            stmt.setDouble(3, f.getTotal());
            stmt.setString(4, f.getCliente().getDNI_CUIL());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public List<Factura> obtenerTodos() {
    List<Factura> lista = new ArrayList<>();

    String sql = "SELECT cantidad, total, cliente_id FROM factura";

    try (Connection conn = ConexionDB.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Factura f = new Factura();

            f.setId(rs.getInt("id"));
            f.setCantidad(rs.getInt("cantidad"));
            f.setTotal(rs.getDouble("total"));

            Cliente c = new Cliente();
            c.setDNI_CUIL(rs.getString("dni_cuil"));
            f.setCliente(c);

            lista.add(f);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

}
