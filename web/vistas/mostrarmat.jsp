<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOMateria"%>
<%@page import="beans.Materia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="vistas/stylu.css">
        <title>MOSTRAR MATERIAS</title>
        
    </head>
    <body>
        <h3>REGISTRO DE MATERIAS</h3>
        <div>
            <table>
            <tr>
            <th><a href="SMateria?accion=nuevomat"><button>Nueva Materia</button></a></th>
            <th></th>
            <th><a href="index.html"><button>REGRESAR</button></a></th>
            </tr>
            </table>
        </div><br>
        
        <div>
        <table border="0">
                <thead>
                    <tr>
                        <th>CLAVE_MATERIAS</th>
                        <th>NOMBRE</th>
                        <th>CUATRIMESTRE</th>
                        <th colspan="2">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    DAOMateria daoMateria = new DAOMateria();
                    ArrayList<Materia> lista = daoMateria.mostrarmat();
                    for(int i=0; i<lista.size(); i++)
                    {
                     Materia materia=new Materia();
                     materia = lista.get(i);
                    %>
                    <tr>
                        <td><%=materia.getClavemat()%></td>
                        <td><%=materia.getNombre()%></td>
                        <td><%=materia.getCuatrimestre()%></td>
                        <td><a href="SMateria?accion=editarmat&clavemat=<%=materia.getClavemat()%>"><button>EDITAR</button></a></td>
                        <td><a href="SMateria?accion=eliminar&clavemat=<%=materia.getClavemat()%>"><button>ELIMINAR</button></a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
                
        </div>
    </body>
</html>
