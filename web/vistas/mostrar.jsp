<%@page import="java.util.ArrayList"%>
<%@page import="dao.DAOAlumno"%>
<%@page import="beans.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="vistas/stylu.css">
        <title>MOSTRAR alumnos</title>
        
    </head>
    <body>
        <h3>REGISTRO DE ALUMNOS</h3>
        <div>
            <table>
            <tr>
                <th><a href="SAlumno?accion=nuevo"><button>Nuevo Alumno</button></a></th>
            <th></th>
            <th><a href="index.html"><button>REGRESAR</button></a></th>
            </tr>
            </table>
        </div><br>
        
        <div>
        <table border="0">
                <thead>
                    <tr>
                        <th>MATRICULA</th>
                        <th>NOMBRE</th>
                        <th>PATERNO</th>
                        <th>MATERNO</th>
                        <th>GENERO</th> 
                        <th colspan="2">ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    DAOAlumno daoAlumno = new DAOAlumno();
                    ArrayList<Alumno> lista = daoAlumno.mostrar();
                    for(int i=0; i<lista.size(); i++)
                    {
                     Alumno alumno=new Alumno();
                     alumno = lista.get(i);
                    %>
                    <tr>
                        <td><%=alumno.getMatricula()%></td>
                        <td><%=alumno.getNombre()%></td>
                        <td><%=alumno.getPaterno()%></td>
                        <td><%=alumno.getMaterno()%></td>
                        <td><%=alumno.getGenero()%></td>
                        <td><a href="SAlumno?accion=editar&matricula=<%=alumno.getMatricula()%>"><button>EDITAR</button></a></td>
                        <td><a href="SAlumno?accion=eliminar&matricula=<%=alumno.getMatricula()%>"><button>ELIMINAR</button></a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
