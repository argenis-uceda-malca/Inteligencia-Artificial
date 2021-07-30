/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peonVspeon;

import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author abel
 */
public class NULA extends Ficha{
    
      @Override
  public Ficha clone(){
  return new NULA(tipo,getX(),getY(),icon,(Rey)rey.clone(),ajedrez);
  } 
    
    public NULA(int tipo, int x, int y, String icon, Rey rey,AjedrezApp ajedrez) {
        super(tipo, x, y, icon, rey,ajedrez);
    }

    
    public boolean puede(int posx, int posy) {return false;}

}