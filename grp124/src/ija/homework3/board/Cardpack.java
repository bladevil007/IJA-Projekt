/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.homework3.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Represents pack of playing cards.
 * The pack is generated randomly.
 * @author Norbert Durcansky (xdurca01)<br>
 *         Jan Jusko (xjusko00)
 */
public class Cardpack implements java.io.Serializable {
    public  ArrayList<Card> pack=new ArrayList<>();
    public  ArrayList<Card> packonboard=new ArrayList<>();
/**
 * Constructor of the class, creates and fills a random
 * card pack with following parameters:
 * @param size Initial number of cards
 * @param limit Maximum number of cards
 * @return Cardpack (pack of cards)
 */
    public static   Cardpack create(int size,int limit)
    {
        Random random=new Random();
        int randomNum;    
        Cardpack balik=new Cardpack();   
        for(int i=0;i<size;i++)
        {   
            randomNum = random.nextInt((5 - 1) + 1) + 1;
            String type;
            switch(randomNum)
           {
               case 4:
                   type="star";
                   break;
               case 3:
                   type="circle";
                   break;
               case 1: 
                   type="square";
                   break;
               case 2:
                   type="triangle";
                   break;
               case 5:
                   type="plane";
                   break;
               default:
                   type="circle";
           } 
           Card karta;        
           karta= Card.create(type); 
           balik.pack.add(karta);
           balik.packonboard.add(karta);
        }
        
        while (size<(limit*limit)-4)
        {
            Card karta;        
            karta= Card.create("p"); 
            balik.packonboard.add(karta);
            size++;
        }
        Collections.shuffle(balik.pack);
        return balik;
   }
   /**
    * Method removes the front card from the card pack if there is any card left.
    * @return Nothing
    */
   public Card Givemecard()
   {
        if(pack.size()>0)
            return pack.remove(0);
    return null;
   } 
   
   
}