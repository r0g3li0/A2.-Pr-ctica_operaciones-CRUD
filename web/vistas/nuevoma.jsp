<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="vistas/stylu.css">
        <title>NUEVO_MAESTRO</title>
    </head>
    <body>
        <div> <br><br><br><br><br><br>
           <h3>INGRESAR NOMBRE DE MAESTRO</h3>
           <form action="SMaestro" method="POST"><br>
            <table>
                <thead>
                    <tr>
                        <th>IDENTIFICADOR</th>
                        <th>NOMBRE</th>
                        <th>PATERNO</th>
                        <th>MATERNO</th>
                        <th colspan="2">ACCIONES</th>
                    </tr>
                </thead><br><br>
                <tbody>
                    <tr>
                        <td><input type="text"   name="tfId"       value="" /></td>
                        <td><input type="text"   name="tfNombre"   value="" /></td>
                        <td><input type="text"   name="tfPaterno"  value="" /></td>
                        <td><input type="text"   name="tfMaterno"  value="" /></td>
                        <td><input type="submit" name="accion"     value="Agregar"/></td> 
                        <td><a href="SMaestro"><button>REGRESAR</button></a> </td>
                    </tr>
                </tbody>
            </table>
        </form>  
    </div>
       
    </body>
</html>
