/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peonVspeon;

import javax.swing.*;

/**
 *
 * @argenis
 */
public class Caballo extends Ficha{
    
      @Override
  public Ficha clone(){
  return new Caballo(tipo,getX(),getY(),icon,(Rey)rey.clone(),ajedrez);
  } 
    
    
    public Caballo(int tipo, int x, int y, String icon, Rey rey,AjedrezApp ajedrez) {
        super(tipo, x, y, icon,rey,ajedrez);
    }

 
public boolean puede(int posx,int posy){
   return   ( (Math.abs(getX()/60-posx/60)==1&&Math.abs(getY()/60-posy/60)==2)||
            (Math.abs(getX()/60-posx/60)==2&&Math.abs(getY()/60-posy/60)==1)        
           );
  }

}
