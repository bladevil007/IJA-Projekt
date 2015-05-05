/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.homework3.board;

/**
 *
 * @author Noro
 */
public class Card implements java.io.Serializable {
    
    public String types;
    
    public static Card create(String type)
    {
        Card karta=new Card();
        karta.types=type;
        
        return karta;
    }   
}
