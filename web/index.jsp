<%-- 
    Document   : index
    Created on : 21/06/2020, 02:00:52 PM
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
        
        <h1>Inicio Del Juego</h1>
        <h2>AHORCADO</h2>
        
        <form name="form_juego" action="acceso.jsp" method="POST">
            
            Participante:
            <input type="text" name="nombre" required>
            Num. Intentos:
            <input type="number" name="nintento" required>
            <br>
            
            <br>
            <input class="btn btn-success" type="submit" value="Continuar">
            
        </form>
        
    </center>
    </body>
</html>
