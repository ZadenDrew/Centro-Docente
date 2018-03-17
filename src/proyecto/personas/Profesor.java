/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.personas;
import java.time.LocalDate;
/**
 *
 * @author andrea
 */
public class Profesor extends Persona{
    private String departamento;
    private String categoriaLaboral;
    private int horasAsignables;
    
    Profesor(){
    }
    public Profesor (String perfil,String nombre,String apellidos,LocalDate nacimiento,String categoriaLaboral,String departamento,int horasAsignables){
        super(perfil,nombre,apellidos,nacimiento);   
        this.categoriaLaboral=categoriaLaboral;
        this.departamento=departamento;
        this.horasAsignables=horasAsignables;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
    return (super.toString()+"\r\n"+departamento+"\r\n"+categoriaLaboral+"\r\n"+horasAsignables+"*");
    }
}
