/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.homework3.game;

import ija.homework3.board.Card;
import ija.homework3.board.MazeCard;
import java.util.ArrayList;

/**
 * Class implements object Gamer.
 * @author Norbert Durcansky,Jan Jusko
 * 
 */
public class Gamer implements java.io.Serializable {
    /**
     * The {@link MazeCard} instance representing player's position 
     */
    public MazeCard position;
    /**
     * The {@link Avatar} instance representing player's avatar 
     */
    public Avatar avatar;
    /**
     * player's id
     */
    public int id;
    /**
     * player's card
     */
    public Card karta;
    /**
     * player's score
     */
    public int score;
    /**
     * Name of the player
     */
    public String name;
    /**
     * Saving all player's actions 
     */
    public ArrayList<String> undo=new ArrayList<>();
    /**
     * Set the name and create avatar for the player 
     * @param name represents name of the player
     */
    public void Setname(String name)
    {
        karta=new Card();
        karta.types="";
        avatar= new Avatar();
        avatar.create();
        this.name=name;
    } 
}
