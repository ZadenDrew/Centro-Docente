/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.personas;
import proyecto.personas.Persona;
import java.time.LocalDate;
/**
 *
 * @author andrea
 */
public class Alumno extends Persona {
    
 private LocalDate fechaIngreso;
 private float notaMediaExpediente;
 private String asignaturaSuperadas;
Alumno(){
}
Alumno (String perfil, String nombre, String apellidos,LocalDate nacimiento,LocalDate fechaIngreso, float notaMediaExpediente,String asignaturaSuperadas){
		super(perfil, nombre, apellidos, nacimiento);
		this.fechaIngreso=fechaIngreso;
		this.notaMediaExpediente=notaMediaExpediente;
                this.asignaturaSuperadas=asignaturaSuperadas;
	}
	
public LocalDate getFechaIngreso(){
return fechaIngreso;
}
public float getNotaMediaExp(){
return notaMediaExpediente;
}
public String getAsignaturaSuperada(){
return asignaturaSuperadas;
}
 @Override
  public String toString(){
    	return (super.toString()+fechaIngreso.getDayOfMonth()+"/"+fechaIngreso.getMonthValue()+"/"+fechaIngreso.getYear()
    			+"\r\n"+asignaturaSuperadas+"\n"+notaMediaExpediente);
    }
}