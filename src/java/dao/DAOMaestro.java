package dao;

import beans.Maestro;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOMaestro 
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Maestro maestro;        
            
    public ArrayList mostrarma()
    {
        ArrayList<Maestro> listaMaestros = new ArrayList<>();
        String sql = "SELECT * FROM maestros";
            
        try 
        {
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                maestro=new Maestro();
                maestro.setId(rs.getString("Id"));
                maestro.setNombre(rs.getString("Nombre"));
                maestro.setPaterno(rs.getString("Paterno"));
                maestro.setMaterno(rs.getString("Materno"));
                
                listaMaestros.add(maestro);
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOMaestro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaMaestros;
    }
    
    public boolean agregar(Maestro maestro)
    {
    
      String sql = "INSERT INTO maestros VALUES('" + maestro.getId()+"','" +
                maestro.getNombre()  + "','" +
                maestro.getPaterno() + "','" +
                maestro.getMaterno() + "')";
    
        try 
        {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        
            ps.close();
            con.close();
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOMaestro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
    public Maestro buscar(String id)
    {
        String sql = "SELECT * FROM maestros WHERE Id='" + id + "'";
        
        
         try 
        {
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                maestro=new Maestro();
                
                maestro.setId(rs.getString("Id"));
                maestro.setNombre(rs.getString("Nombre"));
                maestro.setPaterno(rs.getString("Paterno"));
                maestro.setMaterno(rs.getString("Materno"));
                
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOMaestro.class.getName()).log(Level.SEVERE, null, ex);
        }

        return maestro;
    }
   
    public boolean actualizar(Maestro maestro,String old)
    {
      String sql = "UPDATE maestros SET "+
                 "Id = '" + maestro.getId() + "', " +
                 "Nombre   = '" + maestro.getNombre()   + "', " +
                 "Paterno   = '" + maestro.getPaterno()   + "', " +
                 "Materno = " + maestro.getMaterno() + 
                 " WHERE Id = '" + old + "'";
     
     
         try 
        {
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
           
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOMaestro.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
   

    public boolean eliminar(String id)
    {
       String sql = "DELETE FROM maestros WHERE Id ='" + id + "'";   

       try 
        {
            con = ConexionMySQL.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        
            ps.close();
            con.close();
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOMaestro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }

}