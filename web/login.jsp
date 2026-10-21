<%-- 
    Document   : login
    Created on : Oct 21, 2026, 2:43:10 PM
    Author     : lucia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>hello</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/css/bootstrap.min.css" rel="stylesheet">

    </head>

    <body>

        <%

            String error = request.getParameter("error");

        %>

        <br>

        <div class="container d-flex justify-content-center">

            <div class="card" style="width: 20rem">

                <div class="card-body">

                    <form method="POST" action="LoginServlet">

                        <div class="form-floating mb-3">

                            <label for="usuario">User</label>

                            <input name="usuario" type="text"

                                   class="form-control" id="usuario">

                        </div>

                        <div class="form-floating mb-3">

                            <label for="password">Password</label>

                            <input name="password" type="password"

                                   class="form-control" id="password">

                        </div>

                        <button class="btn btn-primary"

                                type="submit">Login</button>

                    </form>

                    <%

                        if (error != null) {

                    %>

                    <p><%=error%></p>

                    <%

                        }

                    %>

                </div>

            </div>

        </div>

    </body>

</html>
    
