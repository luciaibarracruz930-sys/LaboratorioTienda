
package my.webapp.producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import my.webapp.database.Database;

/**
 *
 * @author lucia
 */
public class ProductoDao {
     
   public boolean registrar(Producto producto) throws SQLException {
        String sql = "INSERT INTO productos (Name, Precio, Stock) VALUES (?, ?, ?)";
        try (Connection conn = new Database().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            return ps.executeUpdate() > 0;
        }
    }
    public List<Producto> listar() throws SQLException {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT ID AS id, Name AS nombre, Precio AS precio, Stock AS stock FROM productos ORDER BY ID";
        try (Connection conn = new Database().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
        }
        return lista;
    }
    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = new Database().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }

}
        
        
   
