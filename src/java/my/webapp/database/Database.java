/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.webapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucia
 */
public class Database {
    private static final String URL =
            "jdbc:mysql://localhost:3306/tienda";

    private static final String USER = "root";
    private static final String PASSWORD = "Admin$1234";

    public Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException(
                    "No se encontró el driver JDBC de MySQL",
                    ex
            );
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void Close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
