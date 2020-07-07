<%-- 
    Document   : acceso
    Created on : 21/06/2020, 02:09:55 PM
    Author     : luisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        
        <h1>ACCEDER</h1>
        <h2>Bienvenido <%= request.getParameter("nombre")%></h2>
        
        <%
            session = request.getSession();
            session.setAttribute("maxint", request.getParameter("nintento"));
        %>
        <br>
        
        <h3>
            ¿Te Gustaria Jugar?
            <a href="index.jsp">NO</a>
            <a href="Ahorcado">SI</a>
        </h3>
        
        
    </center>
    </body>
</html>
