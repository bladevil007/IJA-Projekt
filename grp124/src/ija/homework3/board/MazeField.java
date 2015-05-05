/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.homework3.board;

import ija.homework3.game.Gamer;
import java.util.ArrayList;

/**
 * Method represents one field on our game board.
 * Class instance stores the card that is set on it and its own position.
 * @author Norbert Durcansky (xdurca01)<br>
 *         Jan Jusko (xjusko00)
 */
public class MazeField  implements java.io.Serializable {
    /**
     * Card that is on field.
     */
    public MazeCard kamen;
    public int row;
    public int col;
    /**
     * Get row of field.
     * @return row
     */ 
    public int row(){
    return row;
    }
    /**
     * Get col of field.
     * @return col
     */
    public int col(){
    return col;
    }
    /**
     * Return card that is currently set on the field.
     * @return MazeCard
     */
    public MazeCard getCard()
    {  
    return this.kamen; 
    }
    /**
     * Set card given by parameter to the field.
     * @param c MazeCard to be set on field.
     */
    public void putCard(MazeCard c)
    {
      this.kamen=c;
    } 
}
