package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
public int insertarFacturaYRetornarID(Factura factura) throws SQLException {
    String sql = "INSERT INTO factura (cantidad, total, cliente_dni) VALUES (?, ?, ?)";
    try (Connection conn = ConexionDB.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setInt(1, factura.getId());
        stmt.setInt(1, factura.getCantidad());
        stmt.setDouble(2, factura.getTotal());
        stmt.setString(3, factura.getCliente().getDNI_CUIL());

        stmt.executeUpdate();

        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("No se generó ID para la factura.");
            }
        }
    }
}


public List<Factura> obtenerTodos() {
    List<Factura> lista = new ArrayList<>();

    String sql = "SELECT id,cantidad, total, cliente_dni FROM factura";

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
    Factura f = null; 
    String sql = "SELECT id, cantidad, total, cliente_id FROM factura WHERE id = ?";
    
    try (Connection conn = ConexionDB.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        
        stmt.setInt(1, facturaId);
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                f = new Factura(); 
                f.setId(rs.getInt("id"));
                f.setCantidad(rs.getInt("cantidad"));
                f.setTotal(rs.getDouble("total")); 
                Cliente cliente = new Cliente();
                cliente.setDNI_CUIL(rs.getString("dni_cuil")); 
                f.setCliente(cliente);              
            }
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return f; 
}

}
