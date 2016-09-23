<%-- 
    Document   : ListarTransportes
    Created on : 22-sep-2016, 14:10:36
    Author     : sarai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
            <table>
            <thead>
                <tr>
                    <th>Id Bus</th>             
                    <th>fabricante</th>
                    <th>descripcion</th>
                    <th>modelo</th>
                    <th>placa</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach var="transporte" items="${transportes}">

                    <tr>
                        <td>${transporte.idBus}</td>
                       <td>${transporte.fabricante}</td> 
                        <td>${transporte.descripcion}</td>                  
                        <td>${transporte.modelo}</td>
                        <td>${transporte.placa}</td>
                        <td><a href="TransporteController?action=cambiar&idBus=${transporte.idBus}">Cambiar</a></td> 
                        <td><a href="TransporteController?action=borrar&idBus=${transporte.idBus}">Borrar</a></td> 
                    </tr>

                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="TransporteController?action=agregar">Añadir un transporte</a>
        </p>

    </body>
</html>
