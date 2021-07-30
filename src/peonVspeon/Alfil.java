/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peonVspeon;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.*;


public class Alfil extends Ficha{
   
  
  public Ficha clone(){
  return new Alfil(tipo,getX(),getY(),icon,(Rey)rey.clone(),ajedrez);
  } 
    
    public Alfil(int tipo, int x, int y, String icon, Rey rey,AjedrezApp ajedrez) {
        super(tipo, x, y, icon,rey,ajedrez); }
 
public boolean puede(int posx,int posy){
 
 if(Math.abs(getX()-posx)==Math.abs(getY()-posy)) {
    Component []z=tablero.getComponents();
                   ArrayList todas=new ArrayList();
                   for(int u=0;u<z.length;u++)
                   {Ficha g=((Ficha)z[u]);
      
                    if (g.icon!=""&&g!=this){
                               
                                if (Math.abs(getX()-g.getX())==Math.abs(getY()-g.getY()))
                                  { if (((getY()<g.getY()&&g.getY()<posy)
                                                        ||
                                      (posy<g.getY()&&g.getY()<getY()))                                          
                                                         &&
                                      
                                      ((getX()<g.getX()&&g.getX()<posx)
                                                        ||
                                      (posx<g.getX()&&g.getX()<getX())))                           
                                      return false;
                                  }
                    
                              }
                            
                   }  
                       
          
   return true; 
   
   }
  return false;    

}
}
