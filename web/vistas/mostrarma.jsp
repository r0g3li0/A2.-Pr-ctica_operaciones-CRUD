<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOMaestro"%>
<%@page import="beans.Maestro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="vistas/stylu.css">
        <title>MOSTRAR MAESTROS</title>
        
    </head>
    <body>
        <h3>REGISTRO DE LOS MAESTROS</h3>
        <div>
            <table>
            <tr>
                <th><a href="SMaestro?accion=nuevoma"><button>Nuevo Maestro</button></a></th>
            <th></th>
            <th><a href="index.html"><button>REGRESAR</button></a></th>
            </tr>
            </table>
        </div><br>
        
        <div>
        <table border="0">
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
                    <%
                    DAOMaestro daoMaestro = new DAOMaestro();
                    ArrayList<Maestro> lista = daoMaestro.mostrarma();
                    for(int i=0; i<lista.size(); i++)
                    {
                     Maestro maestro=new Maestro();
                     maestro = lista.get(i);
                    %>
                    <tr>
                        <td><%=maestro.getId()%></td>
                        <td><%=maestro.getNombre()%></td>
                        <td><%=maestro.getPaterno()%></td>
                        <td><%=maestro.getMaterno()%></td>
                        <td><a href="SMaestro?accion=editarma&id=<%=maestro.getId()%>"><button>EDITAR</button></a></td>
                        <td><a href="SMaestro?accion=eliminar&id=<%=maestro.getId()%>"><button>ELIMINAR</button></a></td>
                        
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
