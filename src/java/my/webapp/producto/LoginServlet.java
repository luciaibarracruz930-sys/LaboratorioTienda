/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package my.webapp.login;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;


public class LoginServlet extends HttpServlet {
 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       String usuario = request.getParameter("usuario");

        String password = request.getParameter("password");

        User user = new User();

        user.setUsuario(usuario);

        user.setPassword(password);

        UserDAO dao = new UserDAO();

        try {
            if (dao.validar(user)) {
                
                HttpSession sesion = request.getSession();
                
                sesion.setAttribute("usuario", usuario);
                
                response.sendRedirect("ProductoServlet");
                
            } else {
                
                response.sendRedirect("login.jsp?error=1");
                
            }
        } catch (SQLException ex) {
            System.getLogger(LoginServlet.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    }
    
    

}
