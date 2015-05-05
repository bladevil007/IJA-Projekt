package ija.homework3.game;

import java.util.ArrayList;
import java.util.Random;

/**
 *Class implements object Avatar,
 * each player has his own avatar
 * @author Norbert Durcansky,Jan Jusko
 */
public class Avatar implements java.io.Serializable {
 /**
  * each player has different color
  */
 public String color;
 /**
  * array of colors
  */
 static public ArrayList<String> names=new ArrayList<>();
    public void  create()
    {
        /**
         * asign color to player's avatar
         */
        Random random=new Random();
        int randomNum = random.nextInt(((names.size()-1) - 0) + 1) + 0;
        color=names.remove(randomNum);        
    }
  
}
