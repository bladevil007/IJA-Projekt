/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ija.homework3.board;

import ija.homework3.game.Gamer;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Represents a playing board which consists of playing fields MazeField.
 * @author Norbert Durcansky (xdurca01)<br>
 *         Jan Jusko (xjusko00)
 */
public class MazeBoard  implements java.io.Serializable {
  public  ArrayList<MazeField> board=new ArrayList<>();  //1d pole hracej plochy
  public int sizeofgame;
  public MazeCard special;
  public Cardpack balicek;
  public String cannot=""; // reverse shift is not allowed 
/**
   * This method calls the constructor of the class and creates a MazeBoard of size n as well as 
   * generates appropriate number of MazeFields to add them to the board.
   * @param n Size of board
   * @return MazeBoard
   */
   public static MazeBoard createMazeBoard(int n)
   {
       MazeBoard hra=new MazeBoard();
       int cols=1;
       int rows=1;
       
       for(int i=0;i<n*n;i++)
       {
             MazeField policko=new MazeField();   
             if(cols==n+1)
             {
                  rows++;
                  cols=1;
             }   
       policko.row=rows;
       policko.col=cols;
       cols++;
       hra.board.add(policko);//na presne policko
       }
       
   return hra;
   }
   /**
    * Method creates a new game by creating a new card pack and places all the cards on 
    * fields.
    * All has to be done according to rules of game, so lots of conditions inside.
    * Also generates one free card.
    * @param K Number of Cards to be created.
    */
    public void newGame(int K)
    {  
    balicek=new Cardpack();
    sizeofgame=(int)sqrt(board.size());
    balicek= Cardpack.create(K,sizeofgame);

    
     Random random=new Random();
     int randomNum = random.nextInt((2 - 0) + 1) + 0;
     int l=1;
     int k=1;
     int L=4,I=0,T=0;
     boolean shiftrand;
      switch(randomNum)
         {
             case 0:
             I++;
             special=MazeCard.create("I"); 
             break;
             case 1:
             L++;
             special=MazeCard.create("L"); 
             break;
             case 2:
             T++;
             special=MazeCard.create("T"); 
             break;
         }  
     for(int i=0;i<board.size();i++)
     {
        
        randomNum = random.nextInt((2 - 0) + 1) + 0;
        MazeCard kamen=new MazeCard();
           //System.out.println(randomNum);
        shiftrand=false;
        if((l==1 || l==sizeofgame)&&(k==1 || k==sizeofgame))
            randomNum=1;
        else if(l%2==1 && k%2==1)
            randomNum=2;
        else
            shiftrand=true;
        
        //pridat podla poctu ked je false 
        if(shiftrand==true)
            randomNum=max(L,I,T);
         switch(randomNum)
         {
             case 0:
             I++;
             kamen=MazeCard.create("I"); 
             break;
             case 1:
             if(shiftrand==true)
                L++;
             kamen=MazeCard.create("L"); 
             break;
             case 2:
             T++;
             kamen=MazeCard.create("T"); 
             break;
         }
        shiftinit(l,k,kamen); 
        if(shiftrand==true)
        {
            int times=random.nextInt((2 - 0) + 1) + 0;
            for(int j=0;j<=times;j++)
                kamen.turnRight(null);  
        }
        MazeField kde=get(l,k);
        kde.putCard(kamen);
        Collections.shuffle(balicek.packonboard);
        k++;       
        if(k==sizeofgame+1)
        {
            l++;
            k=1;
        }       
     }
     l=1;
     k=1;
     Card kart; 
      for (MazeField board1 : board) 
      {
          if(l==1 && k==1)
          {
              
              MazeField kde=get(1,1);
              kart=new Card();
              kart.types="p";
              kde.kamen.Card=kart.types;
              
              kde=get(1,sizeofgame);
              kart=new Card();
              kart.types="p";
              kde.kamen.Card=kart.types;
              
              kde=get(sizeofgame,1);
              kart=new Card();
              kart.types="p";
              kde.kamen.Card=kart.types;
              
              kde=get(sizeofgame,sizeofgame);
              kart=new Card();
              kart.types="p";
              kde.kamen.Card=kart.types;
          }
          if((l==1 && k==1) ||(l==sizeofgame && k==sizeofgame) || (l==1 && k==sizeofgame) || (l==sizeofgame && k==1))
          {}else
          {
              MazeField kde=get(l,k);
              kart=balicek.packonboard.remove(0);
              kde.kamen.Card=kart.types;
          }
          k++;
          if(k==sizeofgame+1)
          {
              l++;
              k=1;
          }
      }

    } 
    /**
     * Method does the initial rotation before initializing the game.
     * Rotate the card before game according to the rules.
     * @param l Number of rows
     * @param k Number of cols
     * @param kamen Card to be rotated
     */
    public void shiftinit(int l,int k,MazeCard kamen)
    {
      if(l==1 && k==1)
      {     
          kamen.turnRight(null);
          kamen.turnRight(null);
          return;
      } 
      if(l==sizeofgame && k==1)
      {     
          kamen.turnRight(null);
          return;
      }                  
       if(l==1 && k==sizeofgame)
      {     
          kamen.turnRight(null);
          kamen.turnRight(null);
          kamen.turnRight(null);
          return;
      }  
      if(l==sizeofgame && k==sizeofgame)   
          return;
       if(l%2==1 && k%2==1)
       {
           if(l==1)
           {
              kamen.turnRight(null);
              kamen.turnRight(null); 
              return;
           }
           if(k==1)
           {
              kamen.turnRight(null);
              return;
            }
           if(k==sizeofgame)
           {
              kamen.turnRight(null); 
              kamen.turnRight(null);
              kamen.turnRight(null); 
           }
       }
    } 
    /**
     * Simple getter of MazeField.
     * Return a field from board on specific position.
     * @param r Row
     * @param c Col
     * @return MazeField
     */
    public MazeField get(int r, int c )
    {
        if(r*c<=sizeofgame*sizeofgame)
            return board.get((sizeofgame*(r-1))+(c-1));  
    return null;
    }
    /**
     * Get current free card.
     * @return MazeCard
     */
    public MazeCard getFreeCard()
    {
    return special;
    }
    /**
     * Return specific integer according to maximum value of parameters.
     * Return 0,1,2 according to which one of the parameters is maximum.
     * @param L int
     * @param I int
     * @param T int
     * @return int
     */
    public int max(int L, int I, int T)
    {
        if(L<=I)
        {   
            if(L<=T)
                return 1;
            else
              return 2;
        }
        else
        { 
            if (I<=T)
                return 0;
            else return 2;
        }  
    }
    /**
     * Method responsible for Shifting the fields through the board.
     * Method takes the field and shifts it into the board on specific position.
     * There is need to do several assertions.
     * @param mf MazeField
     * @param undo String of past game steps
     * @param backtrack boolean value, if want to go back
     */
    public void shift(MazeField mf,ArrayList<String> undo,boolean backtrack)
    {
        
        if(undo.size()>0 && undo.get(undo.size()-1).startsWith("xx"))
            cannot=undo.get(undo.size()-1).substring(2); //save last turn 
        else 
            cannot="";
        
        if(cannot.equals(String.valueOf(mf.row)+":"+String.valueOf(mf.col)))
            return;
        
        int i;
        for(i=0;i<board.size();i++)
        {
        if(board.get(i)==mf)
            break;
        }
       int rowp=(i/sizeofgame)+1;
       int colp=i-((sizeofgame)*(rowp-1))+1;  
       
       if(rowp==1 && (colp%2)==0)
       {
       if(backtrack==false)    
            undo.add("xx"+String.valueOf(sizeofgame)+":"+String.valueOf(colp));
       MazeField novyspeacialx =get(rowp,colp);
       MazeField last=get(sizeofgame,colp);
       MazeCard lastx=last.getCard();
       for(int stlpec=sizeofgame-1;stlpec!=0;stlpec--)
       {

               MazeField kam1=get(stlpec,colp);
               MazeCard co1=kam1.getCard();
               MazeField kam2 =get(stlpec+1,colp);
               MazeCard co2=kam2.getCard();
               kam2.putCard(co1);   
       }
       special.stay=new ArrayList<Gamer>(lastx.stay);
       lastx.stay.clear();
       novyspeacialx.putCard(special);
       special=lastx;        
       }
       
         else if(rowp==sizeofgame && colp%2==0)
       {
        if(backtrack==false)
           undo.add("xx"+String.valueOf(1)+":"+String.valueOf(colp));  
       MazeField novyspeacialx =get(rowp,colp); //posledneho
       MazeField last=get(1,colp);
       MazeCard lastx=last.getCard(); 
       for(int stlpec=1;stlpec!=sizeofgame;stlpec++)
       {

               MazeField kam1=get(stlpec,colp);
               MazeCard co1=kam1.getCard();
               MazeField kam2 =get(stlpec+1,colp);
               MazeCard co2=kam2.getCard();
               kam1.putCard(co2);   
       }
       special.stay=new ArrayList<Gamer>(lastx.stay);
       lastx.stay.clear();
       novyspeacialx.putCard(special);
       special=lastx;  
       }
       else if(colp==1 && rowp%2==0)
       {
        if(backtrack==false)
           undo.add("xx"+String.valueOf(rowp)+":"+String.valueOf(sizeofgame));  
       MazeField novyspeacialx =get(rowp,colp);
       MazeField last=get(rowp,sizeofgame);
       MazeCard lastx=last.getCard();
       for(int stlpec=sizeofgame-1;stlpec!=0;stlpec--)
       {

               MazeField kam1=get(rowp,stlpec);
               MazeCard co1=kam1.getCard();
               MazeField kam2 =get(rowp,stlpec+1);
               MazeCard co2=kam2.getCard();
               kam2.putCard(co1);   
       }
       special.stay=new ArrayList<Gamer>(lastx.stay);
       lastx.stay.clear();
       novyspeacialx.putCard(special);
       special=lastx;        
       } 
       else if(colp==sizeofgame && rowp%2==0)
       {
       if(backtrack==false)
           undo.add("xx"+String.valueOf(rowp)+":"+String.valueOf(1));         
       MazeField novyspeacialx =get(rowp,colp); //posledneho
       MazeField last=get(rowp,1);
       MazeCard lastx=last.getCard(); 
       for(int stlpec=1;stlpec!=sizeofgame;stlpec++)
       {

               MazeField kam1=get(rowp,stlpec);
               MazeCard co1=kam1.getCard();
               MazeField kam2 =get(rowp,stlpec+1);
               MazeCard co2=kam2.getCard();
               kam1.putCard(co2);   
       }
       special.stay=new ArrayList<Gamer>(lastx.stay);
       lastx.stay.clear();
       novyspeacialx.putCard(special);
       special=lastx;       
       }
    }
    
}
