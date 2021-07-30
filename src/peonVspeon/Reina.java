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
 * @argenis
 */
public class Reina extends Ficha{
    
    
      @Override
  public Ficha clone(){
  return new Reina(tipo,getX(),getY(),icon,(Rey)rey.clone(),ajedrez);
  } 
    public Reina(int tipo, int x, int y, String icon, Rey rey,AjedrezApp ajedrez) {
        super(tipo, x, y, icon, rey,ajedrez);
    }
 

public boolean puede(int posx,int posy){
  
 if (((Math.abs(getX()-posx)==0)||(Math.abs(getY()-posy)==0))
          ||
        (Math.abs(getX()-posx)==Math.abs(getY()-posy))  
      )
   {if((getX()==posx)||(getY()==posy)) {
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
     
    }
 
if (Math.abs(getX()-posx)==Math.abs(getY()-posy)) {
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
                       
   }
  return true;
    }
  
return false;
}

 }
