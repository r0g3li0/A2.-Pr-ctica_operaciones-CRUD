<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="vistas/stylu.css">
        <title>MATERIAS</title>
    </head>
    <body>
        <div> <br><br><br><br><br><br>
           <h3>INGRESAR NUEVA MATERIA</h3>
           <form action="SMateria" method="POST"><br>
            <table>
                <thead>
                    <tr>
                        <th>CLAVE_MATERIA</th>
                        <th>NOMBRE</th>
                        <th>CUATRIMESTRE</th>
                        <th colspan="2">ACCIONES</th>
                    </tr>
                </thead><br><br>
                <tbody>
                    <tr>
                        <td><input type="text"   name="tfClavemat"     value=""/></td>
                        <td><input type="text"   name="tfNombre"       value=""/></td>
                        <td><input type="text"   name="tfCuatrimestre" value=""/></td>
                        <td><input type="submit" name="accion"         value="Agregar"/></td> 
                        <td><a href="SMateria"><button>REGRESAR</button></a> </td>
                    </tr>
                </tbody>
            </table>
        </form>  
    </div>
       
    </body>
</html>