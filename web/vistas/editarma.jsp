<%@page import="dao.DAOMaestro"%>
<%@page import="servlets.SMaestro"%>
<%@page import="beans.Maestro"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="vistas/stylu.css">
    <title>MODIFICAR DATOS</title>
</head>
    
    <body>
              <% 
                    DAOMaestro dao    = new DAOMaestro();
                    Maestro maestro   = new Maestro();
                    String id = request.getAttribute("id").toString();
                    maestro           = dao.buscar(id);
              %>
              
              <div><br><br><br><br><br><br>
            <h3>EDITAR MAESTROS</h3>
            <form action="SMaestro" method="POST">
            <table>
                <thead>
                    <tr>
                       
                        <th>IDENTIFICADOR</th>
                        <th>NOMBRE</th>
                        <th>PATERNO</th>
                        <th>MATERNO</th>
                        <th colspan="2">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                            
                         <input type="hidden"    name="tfIdOld"       value="<%=maestro.getId()%>">
                        <td><input type="text"   name="tfId"          value="<%=maestro.getId()%>"></td>
                        <td><input type="text"   name="tfNombre"      value="<%=maestro.getNombre()%>">   </td>
                        <td><input type="text"   name="tfPaterno"     value="<%=maestro.getPaterno()%>"></td>
                        <td><input type="text"   name="tfMaterno"     value="<%=maestro.getMaterno()%>"></td>
                        <td><input type="submit" name="accion"        value="ACTUALIZAR"/></td>  
                        <td><a href="SMaestro"><button>REGRESAR</button>                                                                   </a></td>
                    </tr>
                </tbody>
            </table>
        </form>  
    </div>
       
</body>
</html>
