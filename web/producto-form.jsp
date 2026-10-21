<%-- 
    Document   : producto-form
    Created on : Oct 21, 2026, 2:36:43 PM
    Author     : lucia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>hello </title>
    </head>

    <body>

        <form method="POST" action="ProductoServlet">

            <input type="hidden" name="accion" value="registrar">

            Nombre:<input type="text" name="nombre" /><br>

            Precio:<input type="number" name="precio" step="0.01" /><br>

            Stock:<input type="number" name="stock" /><br>

            <button type="submit">Save</button>

        </form>

    </body>

</html>

