/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peonVspeon;

import javax.swing.*;

/**
 *
 * @author abel
 */
public class Rey extends  Ficha{
    
     
  public Ficha  clone(){
 Rey r=new Rey(tipo,getX(),getY(),icon,null,ajedrez);
  r.rey=r;
  return r;
  } 
    public Rey(int tipo, int x, int y, String icon, Rey rey,AjedrezApp ajedrez) {
        super(tipo, x, y, icon,rey,ajedrez);}
 
public boolean puede(int posx,int posy){
  return ((Math.abs(getY()/95-posy/95)<2)&&(Math.abs(getX()/95-posx/95)<2));
 }

}
