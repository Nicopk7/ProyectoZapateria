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
public Factura buscarFactura(int facturaId) {
    Factura f = null; // inicializar en null
    String sql = "SELECT id, cantidad, total, cliente_id FROM factura WHERE id = ?";
    
    try (Connection conn = ConexionDB.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        // Establecer el valor del parámetro (puede ser otro criterio si deseas)
        stmt.setInt(1, facturaId);
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                f = new Factura(); 
                f.setId(rs.getInt("id"));
                f.setCantidad(rs.getInt("cantidad"));
                f.setTotal(rs.getDouble("total")); 
                Cliente cliente = new Cliente();
                cliente.setDNI_CUIL(rs.getString("dni_cuil")); // usar el campo DNI
                f.setCliente(cliente);

                
                // Si tienes una clase Cliente, podrías cargarla también
                // f.setCliente(obtenerClientePorId(rs.getInt("cliente_id")));
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return f; // retornará null si no se encontró
}

}
