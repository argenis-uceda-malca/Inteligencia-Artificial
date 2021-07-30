/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peonVspeon;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author abel
 */
public class Torre extends Ficha{


      @Override
  public Ficha clone(){
  return new Torre(tipo,getX(),getY(),icon,(Rey)rey.clone(),ajedrez);
  } 
    public Torre(int tipo, int x, int y, String icon, Rey rey,AjedrezApp ajedrez) {
        super(tipo, x, y, icon,rey,ajedrez);}
 
public boolean puede(int posx,int posy){
   if((getX()==posx)||(getY()==posy)) {
    Component []z=tablero.getComponents();
                   ArrayList todas=new ArrayList();
                   for(int u=0;u<z.length;u++)
                   {Ficha g=((Ficha)z[u]);
      
                    if (g.icon!=""&&g!=this){
                              { 
                                if (getX()==g.getX()){  
                                  if ((posy<g.getY()&&g.getY()<getY())
                                                        ||
                                      (getY()<g.getY()&&g.getY()<posy))                                          
                                       
                                      return false;
                                }    
                              }
                    
                              if (g.getY()==getY())
                                  { if ((posx<g.getX()&&g.getX()<getX())
                                                        ||
                                      (getX()<g.getX()&&g.getX()<posx))                                          
                                      
                                      return false;
                                      
                                  
                                  }
                    
                              }
                            
                   }  
     
   return true; 
   
   }
  return false;  
}


}
