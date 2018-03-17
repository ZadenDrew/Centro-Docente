/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.docencia;

/**
 *
 * @author andrea
 */
public class Docencia {
     private int  idegrupo;
     private int ideasignatura;

    Docencia(){
    }
    Docencia(int ig,int ia){
        idegrupo=ig;
        ideasignatura=ia;
    }
   public void setIdeGrupo (int ig){
    idegrupo=ig;
   }
   public void setIdeAsignatura(int ia){
    ideasignatura=ia;
   }
   public int getIdeGrupo ( ){
    return idegrupo;
}
public int getIdeAsignatura ( ){
    return ideasignatura;
}
public void AsignaCargaDocente (int persona,int asignatura,char tipoGrupo,int grupo){
} 
public void OrdenarProfesoresPorCargaDocente (String salida){
}
public  void ObtenerCalendarioClases (int alumno,String salida){
}
public void AsignaGrupo (int alumno,int asignatura,char tipoGrupo,int grupo){
}


    @Override
     public String toString ( ){
return ("");
}
}  

