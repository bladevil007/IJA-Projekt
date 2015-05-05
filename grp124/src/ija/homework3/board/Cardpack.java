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
 *
 * @author Noro
 */
public class Cardpack implements java.io.Serializable {
    public  ArrayList<Card> pack=new ArrayList<>();
    public  ArrayList<Card> packonboard=new ArrayList<>();

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
   
   public Card Givemecard()
   {
        if(pack.size()>0)
            return pack.remove(0);
    return null;
   } 
   
   
}