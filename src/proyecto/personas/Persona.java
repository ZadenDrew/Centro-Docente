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
 class Persona {
     private static int i=0;
     private int identificador;
     private String perfil;
     private String nombre;
     private String apellidos;
     private LocalDate nacimiento;
     
      protected Persona(){
  }
     protected Persona(String perfil,String nombre,String apellidos,LocalDate nacimiento){
     i++;
     identificador=i;  
     this.nombre=nombre;
     this.apellidos=apellidos;
     this.nacimiento= nacimiento;
     
   }
public  int getIde(){
    return identificador;
    }
public void setNombre(String n){
    nombre = n;
    }
public String getName(){
    return nombre;
    }
public String getApell(){
    return apellidos;
    }
public int getDia(){
   return nacimiento.getDayOfMonth();
   }
public int getMes(){
    return nacimiento.getMonthValue();
    }
public int getAño(){
    return nacimiento.getYear();
    }
 public String toString(){
    	return ("*"+identificador+perfil+"\r\n"+nombre+"\r\n"+apellidos+"\r\n"
    			+nacimiento.getDayOfMonth()+"/"+nacimiento.getMonthValue()+"/"+nacimiento.getYear()+"\r\n");
    }
}
