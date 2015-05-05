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
public class MazeField  implements java.io.Serializable {
    public MazeCard kamen;
    public int row;
    public int col;
 
    public int row(){
    return row;
    }
    public int col(){
    return col;
    }
    
    public MazeCard getCard()
    {  
    return this.kamen; 
    }
    
    public void putCard(MazeCard c)
    {
      this.kamen=c;
    } 
}
