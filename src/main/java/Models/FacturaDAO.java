package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
public void insertarFactura(Factura factura) throws SQLException {
    Connection con = ConexionDB.getConexion();

    String sql = "INSERT INTO factura (id,cantidad, total, cliente_dni) VALUES (?,?, ?, ?)";
    PreparedStatement ps = con.prepareStatement(sql);
   ps.setInt(1, factura.getId());
    ps.setInt(2, factura.getCantidad()); // cantidad total de calzados
    ps.setDouble(3, factura.getTotal()); // total a pagar
    ps.setString(4, factura.getCliente().getDNI_CUIL()); // DNI del cliente

    ps.executeUpdate();

    ps.close();
    con.close();
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
