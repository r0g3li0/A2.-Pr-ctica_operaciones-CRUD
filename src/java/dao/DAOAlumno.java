package dao;

import beans.Alumno;
import conexion.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOAlumno 
{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Alumno alumno;        
            
    public ArrayList mostrar()
    {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";
            
        try 
        {
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                alumno=new Alumno();
                alumno.setMatricula(rs.getString("Matricula"));
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setPaterno(rs.getString("Paterno"));
                alumno.setMaterno(rs.getString("Materno"));
                alumno.setGenero(rs.getString("Genero"));
                listaAlumnos.add(alumno);
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaAlumnos;
    }
    
    public boolean agregar(Alumno alumno)
    {
        String sql = "INSERT INTO alumnos VALUES('"+alumno.getMatricula()+"','"+
                alumno.getNombre()+"','"+
                alumno.getPaterno()+"','"+
                alumno.getMaterno()+"','"+
                alumno.getGenero()+"')";
        
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
            Logger.getLogger(DAOAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
    
    public Alumno buscar (String matricula)
    {
        String sql = "SELECT * FROM alumnos WHERE Matricula='"+matricula+"'";
         try 
        {
            con = ConexionMySQL.getConnection(); 
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(); 
            while(rs.next())
            {
                alumno=new Alumno();
                alumno.setMatricula(rs.getString("Matricula"));
                alumno.setNombre(rs.getString("Nombre"));
                alumno.setPaterno(rs.getString("Paterno"));
                alumno.setMaterno(rs.getString("Materno"));
                alumno.setGenero(rs.getString("Genero"));
            
    
            }
            rs.close();
            ps.close();
            con.close();
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

        return alumno;
    }
   
    
    public boolean actualizar(Alumno alumno,String old)
    {
 
    String sql = "UPDATE alumnos SET "+
                 "Matricula = '" + alumno.getMatricula() + "', " +
                 "Nombre    = '" + alumno.getNombre()    + "', " +
                 "Paterno   = '" + alumno.getPaterno()   + "', " +
                 "Materno   = '" + alumno.getMaterno()   + ", " +
                 "Genero    =  " + alumno.getGenero()    +
                 " WHERE Matricula = '" + old + "'";
    
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
            Logger.getLogger(DAOAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
   

    public boolean eliminar(String matricula)
    {
       String sql = "DELETE FROM alumnos WHERE Matricula ='" + matricula + "'";   
       
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
            Logger.getLogger(DAOAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
}