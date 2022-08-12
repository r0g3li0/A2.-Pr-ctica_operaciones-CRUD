package beans;

import java.text.DecimalFormat;

public class Materia
{
    private String clavemat;
    private String nombre;
    private String cuatrimestre;
       
    public Materia() 
    {
        clavemat = " ";
        nombre = " ";
        cuatrimestre = " ";
        
    }
    public Materia(String clavemat, String nombre, String cuatrimestre) 
    {
        this.clavemat = clavemat;
        this.nombre = nombre;
        this.cuatrimestre = cuatrimestre;
       
    }
    
    public String getClavemat()
    {
        return clavemat;
    }
    public void setClavemat(String clavemat)
    {
        this.clavemat = clavemat;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getCuatrimestre()
    {
        return cuatrimestre;
    }
    public void setCuatrimestre(String cuatrimestre)
    {
        this.cuatrimestre = cuatrimestre;
    }
 
}