/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package my.webapp.producto;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lucia
 */
public class ProductoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

   
     

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession sesion = request.getSession(false);

        if (sesion == null || sesion.getAttribute("usuario") == null) {

            response.sendRedirect("login.jsp");

            return;

        }

        ProductoDao dao = new ProductoDao();

        List<Producto> lista;
        try { lista = dao.listar(); }
        catch (SQLException ex) { throw new ServletException("No se pudieron listar los productos", ex); }

        request.setAttribute("productos", lista);

        request.getRequestDispatcher("productos.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       HttpSession sesion = request.getSession(false);

        if (sesion == null || sesion.getAttribute("usuario") == null) {

            response.sendRedirect("login.jsp");

            return;

        }

        String accion = request.getParameter("accion");

        ProductoDao dao = new ProductoDao();

        if (null == accion) {
            
            response.sendRedirect("ProductoServlet");
            
        } else switch (accion) {
            case "registrar" -> {
                String nombre = request.getParameter("nombre");
                String precioTexto = request.getParameter("precio");
                String stockTexto = request.getParameter("stock");
                try {
                    
                    double precio = Double.parseDouble(precioTexto);
                    
                    int stock = Integer.parseInt(stockTexto);
                    
                    if (nombre == null || nombre.trim().isEmpty()
                            
                            || precio < 0 || stock < 0) {
                        
                        response.sendRedirect("producto-form.jsp?error=1");
                        
                        return;
                        
                    }
                    
                    Producto producto = new Producto();
                    
                    producto.setNombre(nombre);
                    
                    producto.setPrecio(precio);
                    
                    producto.setStock(stock);
                    
                    if (dao.registrar(producto)) {
                        
                        response.sendRedirect("ProductoServlet?mensaje=registrado");
                        
                    } else {
                        
                        response.sendRedirect("producto-form.jsp?error=1");
                        
                    }
                    
                } catch (NumberFormatException | SQLException ex) {
                    
                    response.sendRedirect("producto-form.jsp?error=1");
                    
                }
           }
            case "eliminar" -> {
                String idTexto = request.getParameter("id");
                try {
                    
                    int id = Integer.parseInt(idTexto);
                    
                    if (id > 0 && dao.eliminar(id)) {
                        
                        response.sendRedirect("ProductoServlet?mensaje=eliminado");
                        
                    } else {
                        
                        response.sendRedirect("ProductoServlet?error=1");
                        
                    }
                    
                } catch (NumberFormatException | SQLException ex) {
                    
                    response.sendRedirect("ProductoServlet?error=1");
                    
                }
           }
            default -> response.sendRedirect("ProductoServlet");
        }

    }


}
    



