/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.homework3.board;

/**
 * Represents one playing card, one card can hold one playing symbol.
 * @author Norbert Durcansky (xdurca01)<br>
 *         Jan Jusko (xjusko00)
 */
public class Card implements java.io.Serializable {
    
    public String types;    
    /**
     * Method calls the constructor of the Card class to create new card and assign a symbol to the card if needed.
     * @param type Symbol to be assigned to card.
     * @return Card
     */
    public static Card create(String type)
    {
        Card karta=new Card();
        karta.types=type;
        
        return karta;
    }   
}
