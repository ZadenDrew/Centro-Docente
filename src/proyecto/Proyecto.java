/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto;
import proyecto.personas.Alumno;
import proyecto.docencia.Asignaturas;
import proyecto.personas.Persona;
import proyecto.personas.Profesor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedHashMap;
import java.util.LinkedList;
/**
 *
 * @author andrea
 */
public class Proyecto{
    static Integer idpersona=1;
 static LinkedHashMap<Integer,Persona>lhmpersona=new LinkedHashMap<>();
// static List<Map.Entry<Integer,Persona>>infoids=new ArrayList<>(lhmpersona.entrySet());
 static LinkedHashMap<Integer,Asignaturas>lhmasignatura=new LinkedHashMap<>();   
 static LinkedList<Persona>lkpersona=new LinkedList<>();  
 static LinkedList<Asignaturas>lkasignatura=new LinkedList<>();
 /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {		
         
             String datos;
               datos = leerFile("ejecucion.txt");
               String [] data=datos.split("\\s+");
               String orden=data[0];
               switch(orden){
               case "InsertaPersona":
                   Proyecto.InsertaPersona(data);
             Proyecto.FicheroPersonas();
                   break;
               case "AsignaCoordinador":
                   break;
               case "AsignaCargaDocente":
                   break;
                   case"Matricula":
                       break;
                       case"Evaluar":
                           break;
                           case"FicheroAsignatura":
                               break;
                               case"FicheroPersonas":
                                   break;
                          
           }         
    }
    /**
     *
     * @param data
     */
    public static void InsertaPersona (String [] data){        
        PrintWriter avisos =null; 
        try {
            avisos = new PrintWriter(new FileOutputStream("avisos.txt"));
            String perfil=data[1];
            String[]nom=data[2].split("\"");
            String nombre =nom[0];
            String apellidos =nom[1];
            String[] fecha1 =data[3].split("/");
            String StringDia1 = fecha1[0];
            String  StringMes1 =fecha1[1];
            String StringAnho1 =fecha1[2];
            int dia1 = Integer.parseInt(StringDia1);
            int mes1 = Integer.parseInt(StringMes1);
            int anho1 = Integer.parseInt(StringAnho1);
            LocalDate nacimiento = LocalDate.of(anho1,mes1,dia1);
            //COMPROBAR SI LA FECHA DE NACIMIENTO ES CORRECTA
            if ( ((nacimiento.getDayOfMonth())!=(dia1)) && ((nacimiento.getMonthValue())!=(mes1))
                    && ((nacimiento.getYear())!=(anho1)) ){
                avisos.println("IP -- Fecha incorrecta");
            }
            if (nacimiento.getYear()<1950 ||
                    ((nacimiento.getYear()>2020) && (nacimiento.getMonthValue()>1) && (nacimiento.getDayOfMonth()<1))){
                avisos.println("IP -- Fecha incorrecta");
            }
            if(perfil.equals("alumno")||(perfil.toUpperCase()).equals("ALUMNO")){
                String[] fecha2 =data[4].split("/");
                String StringDia2=fecha2[0];
                String StringMes2 =fecha2[1];
                String StringAnho2 =fecha2[2];
                String StringNotaMedia =data[5];
                float notaMedia=Float.parseFloat(StringNotaMedia);
                String as =data[6];
                int dia2 = Integer.parseInt(StringDia2);
                int mes2 = Integer.parseInt(StringMes2);
                int anho2 = Integer.parseInt(StringAnho2);
                LocalDate fechaIngreso = LocalDate.of(anho2, mes2, dia2);
                //COMPROBAR SI LA FECHA DE INGRESO ES CORRECTA
                if ( ((fechaIngreso.getDayOfMonth())!=(dia2)) && ((fechaIngreso.getMonthValue())!=(mes2))
                        && ((fechaIngreso.getYear())!=(anho2)) ){
                    avisos.println("IP -- Fecha incorrecta");
                }
                if (fechaIngreso.getYear()<1950 ||
                        ((fechaIngreso.getYear()>2020) && (fechaIngreso.getMonthValue()>1) && (fechaIngreso.getDayOfMonth()<1))){
                    avisos.println("IP -- Fecha incorrecta");
                }
                
                //COMPROBAR SI LAS FECHAS SON INCORRECTAS ENTRE SÍ
                if ( ((Period.between(nacimiento, fechaIngreso)).getYears())<15 ||
                        ((Period.between(nacimiento, fechaIngreso)).getYears())>65){
                    avisos.println("IP -- Fecha de ingreso incorrecta");
                }
                
                //COMPROBAR SI LA NOTA MEDIA ES CORRECTA
                if (notaMedia<0 || notaMedia>10){
                    avisos.println("IP -- Nota media incorrecta");
                }
                
                //AÑADIR EL NUEVO ALUMNO AL MAPA lhMpersonas
                Persona alumno = new Alumno(perfil,nombre,apellidos,nacimiento,fechaIngreso,notaMedia,as);
                lhmpersona.put(idpersona,alumno);
                idpersona++;
            }
            if(perfil.equals("profesor")||(perfil.toUpperCase()).equals("PROFESOR")){
                String categoria =data[3];
                String departamento =data[4];
                String shorasasignables =data[5];
                int horasasignables = Integer.parseInt(shorasasignables);
                //COMPROBAR SI LAS HORAS ASIGNABLES SON CORRECTAS
                if ( (horasasignables<0)  ||
                        (categoria.equals("titular") && horasasignables>20)||
                        ((categoria.toUpperCase()).equals("TITULAR") && horasasignables>20) ||
                        (categoria.equals("interino") && horasasignables>15)||
                        ((categoria.toUpperCase()).equals("INTERINO") && horasasignables>15) ){
                    avisos.println("IP -- Numero de horas incorrecto");
                }
                //AÑADIR EL NUEVO PROFESOR AL MAPA lhmpersonas
                Persona profesor = new Profesor(perfil,nombre,apellidos,nacimiento,categoria,departamento,horasasignables);
                lhmpersona.put(idpersona,profesor);
                idpersona++;
                
            }
            
            
            }catch (FileNotFoundException e) {
            	System.out.println("zzzzzzzzzzzzzzzzzzzFUNCION INSERTAR PERSONA");
            	System.exit(-1);
            }
            avisos.close();
        }
    /**
     *
     * @param fichero
     * @return 
     */
    public static String leerFile(String fichero){
 //LECTURA FICHERO DE TEXTO
        String texto=" ";
        String line;
        File fr =new File(fichero);   
        FileReader entrada =null;
          try {
              entrada = new FileReader(fr);
              BufferedReader lector =new BufferedReader(entrada);
                   
              while((line = lector.readLine())!= null){
                  texto += line +"\n";
                 System.out.println(texto);
              } 
         }catch(FileNotFoundException e){
       throw new RuntimeException("Archivo no encontrado");

                 }
    // System.err.println("Fichero inexistente:<fichero*>");
     //System.exit(-1);
        
     catch(IOException ex){
    throw new RuntimeException("Ocurrio un error de entrada/salida");
    // System.err.println("Fichero inexistente:<fichero>");
                 }
    finally{
              if(entrada !=null){
                  try{
                      entrada.close();
                       } catch (IOException e) {
                       }
          }
      }  
 return line;
    }
    public static void escribirTextoArchivo(String fichero, String texto) {
    FileWriter salida = null;
    try {
      salida = new FileWriter(fichero,true);
      BufferedWriter escritor = new BufferedWriter(salida);
      escritor.write(texto);
    } catch (IOException e) {
    } finally {
      if (salida != null) {
        try {
          salida.close();
        } catch (IOException e) {
         
        }
      }
    }
    }
    /**
     *
     * @param fichero
     * @param texto
     */
    public static void escribeFile(String fichero,String texto){
    //ESCRITURA FICHERO DE TEXTO
    File fw =new File(fichero); 
 try{
PrintWriter salida = new PrintWriter(new FileOutputStream(fw,true));
FileWriter escribe = new FileWriter(fw,true);
 }
catch(FileNotFoundException e2){
 System.err.println("Fichero inexistente:<fichero>");
 System.exit(-1);
}
 catch(IOException e){
	System.err.println("Error de escritura."); 
 }
    }

    private static void InsertaPersona(String datos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
public void Matricula (int alumno,int asignatura){
}
public void Evaluar (int asignatura,String fichero){
}
public void FicheroAsignatura (String asignaturas) {
}
public static void FicheroPersonas (){
    try{
        try (PrintWriter personas = new PrintWriter(new FileOutputStream("C:\\Users\\andrea\\Documents\\NetBeansProject\\src\\proyecto\\personas.txt",true))) {
            for(int w=0;w<lhmpersona.size();w++){
                personas.println(lhmpersona.get(w).toString());
                if (w!=lhmpersona.size()-1) {
                    personas.println("*");
                } else {
                }
            }
            personas.close();
	}
    }catch(IOException e){
		System.out.println("zzzzzzzzzzzzzzzzzzzFUNCION ESCRIBRI EN FICHERO"); 
	}
}
}
