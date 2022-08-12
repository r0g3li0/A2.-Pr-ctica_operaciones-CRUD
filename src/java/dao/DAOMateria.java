package dao;

import beans.Materia;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOMateria 
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Materia materia;        
            
    public ArrayList mostrarmat()
    {
        ArrayList<Materia> listaMaterias = new ArrayList<>();
        String sql = "SELECT * FROM materias";
            
        try 
        {
         
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                materia=new Materia();
                materia.setClavemat(rs.getString("Clavemat"));
                materia.setNombre(rs.getString("Nombre"));
                materia.setCuatrimestre(rs.getString("Cuatrimestre"));
                
                listaMaterias.add(materia);
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaMaterias;
    }
    
    public boolean agregar(Materia materia)
    {
        String sql = "INSERT INTO materias VALUES('" + materia.getClavemat()+"','" +
                materia.getNombre()    + "'," +
                materia.getCuatrimestre() + ")";
                
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
            Logger.getLogger(DAOMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
    public Materia buscar(String clavemat)
    {
        String sql = "SELECT * FROM materias WHERE Clavemat='"+clavemat+"'";
         try 
        {
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                materia=new Materia();
                materia.setClavemat(rs.getString("Clavemat"));
                materia.setNombre(rs.getString("Nombre"));
                materia.setCuatrimestre(rs.getString("Cuatrimestre"));
                
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOMateria.class.getName()).log(Level.SEVERE, null, ex);
        }

        return materia;
    }
   
    
    public boolean actualizar(Materia materia,String old)
    {
    String sql = "UPDATE materias SET "+
                 "Clavemat = '" + materia.getClavemat() + "', " +
                 "Nombre   = '" + materia.getNombre()   + "', " +
                 "Cuatrimestre = " + materia.getCuatrimestre() + 
                 " WHERE Clavemat = '" + old + "'";
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
            Logger.getLogger(DAOMateria.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
   

    public boolean eliminar(String clavemat)
    {
       String sql = "DELETE FROM materias WHERE Clavemat ='" + clavemat + "'";   
                 
       
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
            Logger.getLogger(DAOMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
}