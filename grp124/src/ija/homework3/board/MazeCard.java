/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.homework3.board;

import ija.homework3.game.Gamer;
import java.util.ArrayList;

/**
 *
 * @author xdurca01
 */
public class MazeCard  implements java.io.Serializable {
    public static enum CANGO{
    LEFT,UP,RIGHT,DOWN
    }
    public  ArrayList<Gamer> stay=new ArrayList<>();
    public  char types;
    public String Card="p";
    
    public ArrayList<CANGO> cesta= new ArrayList<>();

    public static MazeCard create(String type)
    {
        MazeCard kamen=new MazeCard();
        switch(type)
        {
            //L cesta
            case "L":
                kamen.types='L';
                kamen.cesta.add(CANGO.LEFT);
                kamen.cesta.add(CANGO.UP);
                break;
            //rovna ceste
            case "I":
                kamen.types='I';
                kamen.cesta.add(CANGO.LEFT);
                kamen.cesta.add(CANGO.RIGHT);
                break;
             //T cesta 
            case "T":
                kamen.types='T';
                kamen.cesta.add(CANGO.UP);
                kamen.cesta.add(CANGO.RIGHT);
                kamen.cesta.add(CANGO.LEFT);
                break;
                default:
                throw new IllegalArgumentException( "Wrong string type");
        }
     return kamen;
    }
    
    
    public boolean canGo(MazeCard.CANGO dir)
    {
        for(int i=0;i<cesta.size();i++)
        {
            if(dir==cesta.get(i))
                return true;
        }
        return false;
    }
    
    public void turnRight(ArrayList<String> undo)
    {
    int i=0;
    boolean add=false;
    if(undo!=null)
        undo.add("shift");
    for(CANGO c: cesta)
    {
            switch(c)
            {
                case DOWN:
                    cesta.set(i, CANGO.LEFT);
                    break;
                case LEFT:
                    cesta.set(i, CANGO.UP);
                    break;
                case UP:
                    cesta.set(i, CANGO.RIGHT);
                    break;
                case RIGHT:
                    cesta.set(i, CANGO.DOWN);
                    break;
            }
        i++;    
    }    
    } 
     public void turnLeft()
    {
        int i=0;
        for(CANGO c: cesta)
        {
                switch(c)
                {
                    case DOWN:
                        cesta.set(i, CANGO.RIGHT);
                        break;
                    case LEFT:
                        cesta.set(i, CANGO.DOWN);
                        break;
                    case UP:
                        cesta.set(i, CANGO.LEFT);
                        break;
                    case RIGHT:
                        cesta.set(i, CANGO.UP);
                        break;
                }
            i++;    
        }    
    } 
  
}
