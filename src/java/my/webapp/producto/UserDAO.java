/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.webapp.login;

import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import my.webapp.database.Database;

/**
 *
 * @author lucia
 */
public class UserDAO {
    public boolean validar(User user) throws SQLException {
        String sql = "SELECT 1 FROM usuarios WHERE usuario = ? AND password = ?";
        try (java.sql.Connection conn = new Database().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getPassword());
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        }
    }

}

