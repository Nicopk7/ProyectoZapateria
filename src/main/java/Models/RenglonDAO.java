package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RenglonDAO {
     public void insertar(Renglon r) {
        String sql = "INSERT INTO renglon (id, cantidad, total, factura_id, calzado_codigo) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionDB.getConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, r.getId());
            stmt.setInt(2, r.getCantidad());
            stmt.setDouble(3, r.getTotal());
            stmt.setDouble(4, r.getFactura().getId());
            stmt.setInt(9, r.getCalzado().getCodigo()); 

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public List<Renglon> obtenerTodos() {
    List<Renglon> lista = new ArrayList<>();

    String sql = "SELECT id, cantidad, total, factura_id, calzado_codigo FROM renglon";

    try (Connection conn = ConexionDB.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Renglon r = new Renglon();

            r.setId(rs.getInt("id"));
            r.setCantidad(rs.getInt("cantidad"));
            r.setTotal(rs.getDouble("total"));

            Factura factura = new Factura();
            factura.setId(rs.getInt("factura_id"));
            r.setFactura(factura);
            
            Calzado calzado = new Calzado();
            calzado.setCodigo(rs.getInt("calzado_codigo"));
            r.setCalzado(calzado);

            lista.add(r);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}

}
