<%-- 
    Document   : productos
    Created on : Oct 21, 2026, 2:39:43 PM
    Author     : lucia
--%>

<%@page import="java.util.List"%>
<%@page import="my.webapp.producto.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>

        <%

            List<Producto> productos = (List<Producto>) request.getAttribute("productos");

        %>

        <a href="producto-form.jsp">Add new</a>

        

        <%for(Producto producto : productos){%>

            <%=producto.getNombre()%> Price: <%=producto.getPrecio()%>

            <p>Stock: <%=producto.getStock()%></p>

            <form method="POST" action="ProductoServlet"

                  onsubmit="return confirm('¿Desea eliminar este producto?');">

                <input type="hidden" name="accion" value="eliminar">

                <input type="hidden" name="id" value="<%=producto.getId()%>">

                <button type="submit">Delete</button>

            </form>

            <hr>

        <% } %>

        

        <a href="LogoutServlet">Cerrar sesión</a>

    </body>

</html>

