package servlets;

import beans.Maestro;
import dao.DAOMaestro;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SMaestro extends HttpServlet 
{
    private String mostrarma;
    private String nuevoma;
    private String editarma;
    
    private String accion;
    private String acceso;
    
    private Maestro maestro;
    private DAOMaestro daoMaestro;
  

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        mostrarma = "/vistas/mostrarma.jsp";
        nuevoma = "/vistas/nuevoma.jsp";
        editarma = "/vistas/editarma.jsp";
        
        accion = request.getParameter("accion");
        
        if(accion != null && accion.equalsIgnoreCase("nuevoma"))
        {
            acceso = nuevoma;
        }
        
        else if(accion != null && accion.equalsIgnoreCase("agregar"))
        {
            maestro = new Maestro();
            maestro.setId(request.getParameter("tfId"));
            maestro.setNombre(request.getParameter("tfNombre"));
            maestro.setPaterno(request.getParameter("tfPaterno"));
            maestro.setMaterno(request.getParameter("tfMaterno"));
            
            
            daoMaestro = new DAOMaestro();
            daoMaestro.agregar(maestro);
            
            acceso = mostrarma;
        }
        
        
        
        else if(accion != null && accion.equalsIgnoreCase("editarma"))
        {
            
            request.setAttribute("id", request.getParameter("id"));
            acceso = editarma;
            
        }
        
        
        else if(accion != null && accion.equalsIgnoreCase("actualizar"))
        {
            
            maestro = new Maestro();
            String idOld = request.getParameter("tfIdOld");
            maestro.setId(request.getParameter("tfId"));
            maestro.setNombre(request.getParameter("tfNombre"));
            maestro.setPaterno(request.getParameter("tfPaterno"));
            maestro.setPaterno(request.getParameter("tfMaterno"));
            
            
            daoMaestro = new DAOMaestro();
            daoMaestro.actualizar(maestro, idOld);
            
            acceso = mostrarma;
            
        }
        
        else if(accion != null && accion.equalsIgnoreCase("eliminar"))
        {
            
            String id = request.getParameter("id");
            daoMaestro = new DAOMaestro();
            daoMaestro.eliminar(id);
            
            acceso = mostrarma;
            
        }
        else
        {
            acceso = mostrarma;
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

