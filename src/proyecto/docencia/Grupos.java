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
public class Grupos {
    private int id;
    private int dia;
    private int hora;
    private char tipo;
    private int duracion;
   protected Grupos(){
    }
    public Grupos(int i,int d,int h,char t,int dur){
        this.id=i;
        this.dia=d;
        this.hora=h;
        this.tipo=t;
        this.duracion=dur;
    }
    public String ToString(){
    return (" "+id+dia+hora+tipo+duracion);
    }
}
