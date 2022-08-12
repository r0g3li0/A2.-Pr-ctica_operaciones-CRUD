<%@page import="dao.DAOMateria"%>
<%@page import="servlets.SMateria"%>
<%@page import="beans.Materia"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="vistas/stylu.css">
    <title>EDITAR MATERIAS</title>
</head>
    
    <body>
              <% 
                    DAOMateria dao    = new DAOMateria();
                    Materia materia   = new Materia();
                    String clavemat   = request.getAttribute("clavemat").toString();
                    materia = dao.buscar(clavemat);
              %>
              <div><br><br><br><br><br><br>
            <h3>EDITAR MATERIAS</h3>
            <form action="SMateria" method="POST">
            <table>
                <thead>
                    <tr>
                        <th>CLAVE_MATERIA</th>
                        <th>NOMBRE</th>
                        <th>CUATRIMESTRE</th>
                        <th colspan="2">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                            <input type="hidden" name="tfClavematOld" value="<%=materia.getClavemat()%>">
                        
                        <td><input type="text"   name="tfClavemat"   value="<%=materia.getClavemat()%>"></td>
                        <td><input type="text"   name="tfNombre"     value="<%=materia.getNombre()%>"></td>
                        <td><input type="text"   name="tfCuatrimestre" value="<%=materia.getCuatrimestre()%>"></td>
                        <td><input type="submit" name="accion"        value="ACTUALIZAR"/></td>  
                        <td><a href="SMateria"><button>REGRESAR</button></a></td>
                    </tr>
                </tbody>
            </table>
        </form>  
    </div>
       
</body>
</html>
