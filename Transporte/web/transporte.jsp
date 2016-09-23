<%-- 
    Document   : Transporte
    Created on : 22-sep-2016, 14:04:37
    Author     : sarai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        
        
         <body>
        <form action="TransporteController" method="post">
            <fieldset>
                
                <div>
                    <label>Id de Bus:</label>
                    <input type="text" name="idBus" value="${transporte.idBus}"
                           placeholder="idBus"
                           readonly="readonly"/>

                </div>
                <div>
                    <label>Fabricante:</label>
                    <input type="text" name="fabricante" value="${transporte.fabricante}"
                           placeholder="fabricante"/>
                </div>
                <div>
                    <label>Descripcion:</label>
                    <input type="text" name="descripcion" value="${transporte.descripcion}"
                           placeholder="descripcion"/>
                </div>
    
                            <div>
                    <label>Modelo:</label>
                    <input type="text" name="modelo" value="${transporte.modelo}"
                           placeholder="modelo"/>
                </div>
                          
                            <div>
                    <label>NPlaca:</label>
                    <input type="text" name="placa" value="${transporte.placa}"
                           placeholder="placa"/>
                </div>
                           
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
            </fieldset>

        </form>

        
        
    </body>
</html>
