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
public class Asignaturas {
    private Integer ide;
    private String nombre;
    private String siglas;
    private String prerequisitos;
    private int duracionteoria;
    private int duracionpractica;
    private String grupoteoria;
    private String grupopractica;
    Asignaturas(){
    }
    public Asignaturas(Integer i,String n,String s,String p,int dt,int dp,String gt,String gp){
        this.ide=i;
        this.nombre=n;
        this.siglas=s;
        this.prerequisitos=p;
        this.duracionteoria=dt;
        this.duracionpractica=dp;
        this.grupoteoria=gt;
        this.grupopractica=gp;
    }
    public int getIde(){
    return ide;
    }
    public String getNombre(){
    return nombre;
    }
    public String getPre(){
    return prerequisitos;
    }
    public int getDuracionT(){
    return duracionteoria;
    }
    public int getDuracionP(){
    return duracionpractica;
    }
    public String ToString(){
    return (+ide+"%n"+nombre+"%n"+siglas+"%n"+prerequisitos+"%n"+duracionteoria+"%n"+duracionpractica+"%n"+grupoteoria+"%n"+grupopractica+"*");
    }
}
