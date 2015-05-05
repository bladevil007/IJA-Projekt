/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.homework3;

import ija.homework3.game.Game;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Represents one game.
 * Norbert Durcansky (xdurca01)<br>
 *         Jan Jusko (xjusko00)
 */
public class Master {
   public Game hra;
   
    /**
     * Create new game.
     * @return new game (Master)
     */
    public static Master create()
    {
        Master universe=new Master();
        
        return universe;
    }
   
    /**
     * Method saves all the progress on current game to the file.
     * creates .sav file
     * @param file save current game to this file
     * @throws IOException
     * @see IOException
     * @throws ClassNotFoundException 
     * @see ClassNotFoundException
     */
  public void save(String file) throws IOException, ClassNotFoundException  { 
      
      try
      {
          try (FileOutputStream fileOut = new FileOutputStream(file); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
              out.writeObject(hra);
          }
      }catch(IOException i)
      {
      }   
  }  
  /**
   * Method loads all the progress from specific game from the file.
   * @param file load game from this file
   */
  public void load(String file){
  
  try
      {
      try (FileInputStream fileIn = new FileInputStream(file); ObjectInputStream in = new ObjectInputStream(fileIn)) {
          hra = (Game) in.readObject();
      }
         
      }catch(IOException i)
      {
      }catch(ClassNotFoundException c)
      {
         System.out.println("Game class not found");
      }
  }
  }
 

