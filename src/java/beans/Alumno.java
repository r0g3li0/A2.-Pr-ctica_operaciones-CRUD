package beans;

import java.text.DecimalFormat;

public class Alumno
{
    private String matricula;
    private String nombre;
    private String paterno;
    private String materno;
    private String genero;
    
    public Alumno() 
    {
        matricula = " ";
        nombre = " ";
        paterno = " ";
        materno = " "; 
        genero = " ";
    }
    public Alumno(String matricula, String nombre, String paterno, String materno, String genero) 
    {
        this.matricula = matricula;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.genero = genero;
     }
    
    public String getMatricula()
    {
        return matricula;
    }
    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getPaterno()
    {
        return paterno;
    }
    public void setPaterno(String paterno)
    {
        this.paterno = paterno;
    }
     public String getMaterno()
    {
        return materno;
    }
    public void setMaterno(String materno)
    {
        this.materno = materno;
    }
     public String getGenero()
    {
        return genero;
    }
    public void setGenero(String genero)
    {
        this.genero = genero;
    } 
}