package servlets;

import beans.Materia;
import dao.DAOMateria;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SMateria extends HttpServlet 
{
    private String mostrarmat;
    private String nuevomat;
    private String editarmat;
    
    private String accion;
    private String acceso;
    
    private Materia materia;
    private DAOMateria daoMateria;
  

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        mostrarmat = "/vistas/mostrarmat.jsp";
        nuevomat = "/vistas/nuevomat.jsp";
        editarmat = "/vistas/editarmat.jsp";
        
        accion = request.getParameter("accion");
        
        if(accion != null && accion.equalsIgnoreCase("nuevomat"))
        {
            acceso = nuevomat;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            materia = new Materia();
            materia.setClavemat(request.getParameter("tfClavemat"));
            materia.setNombre(request.getParameter("tfNombre"));
            materia.setCuatrimestre(request.getParameter("tfCuatrimestre"));
            
            daoMateria = new DAOMateria();
            daoMateria.agregar(materia);
            
            acceso = mostrarmat;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("editarmat"))
        {
            request.setAttribute("clavemat", request.getParameter("clavemat"));
            acceso = editarmat;
        }
        
        
        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            
            materia = new Materia();
            String clavematOld = request.getParameter("tfClavematOld");
            materia.setClavemat(request.getParameter("tfClavemat"));
            materia.setNombre(request.getParameter("tfNombre"));
            materia.setCuatrimestre(request.getParameter("tfCuatrimestre"));
            
            
            daoMateria = new DAOMateria();
            daoMateria.actualizar(materia, clavematOld);
            
            acceso = mostrarmat;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            String clavemat = request.getParameter("clavemat");
            daoMateria = new DAOMateria();
            daoMateria.eliminar(clavemat);
            
            acceso = mostrarmat;
        }
        else
        {
            acceso = mostrarmat;
        }
        
        request.getRequestDispatcher(acceso).forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
