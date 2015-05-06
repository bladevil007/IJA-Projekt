package ija.homework3.game;
import ija.homework3.board.Card;
import java.util.ArrayList;
import ija.homework3.board.MazeBoard;
import ija.homework3.board.MazeCard;
import ija.homework3.board.MazeField;
import java.util.Collections;
/**
 * Class implements object Game which includes game board and players.
 * @author Norbert Durcansky (xdurca01)<br>
 *         Jan Jusko (xjusko00)
 */
public class Game implements java.io.Serializable {

   /**
    * List of players from which we take each turn one player.
    * This player becomes the leader.
    */ 
   public  ArrayList<Gamer> group=new ArrayList<>(); 
   /**
    * free stones for init position
    */
   private ArrayList<MazeCard> stones=new ArrayList<>(); 
   /**
    * The {@link MazeBoard} instance representing game board.
    */
   public MazeBoard board; //create board 
   /**
    * The {@link Gamer} instance representing one player, who is the leader.
    */
   public Gamer leader;
   /**
    * Last saved card.
    */   
   private boolean undo=false;
   /**
    * Points to win.
    */
   public int win;
   /**
    * Static method create() creates game interface and initialize basic operations for the objects 
    * 
    * @param players is a number of players we want to create 
    * @param cards is a number of cards we want to create 
    * @param boardsize specifies size of the board.
    * @param names is a string array of names for the current game 
    * @return the {@link Game} instance Game.
    */
   public static Game create(int players,int cards,int boardsize,ArrayList<String>names)
   {
       int count=boardsize*boardsize-cards-players;
       if(count<0)
           cards=12;
       /** create the instance */
       Game game=new Game();
       /** create board for specific size */
       game.board=MazeBoard.createMazeBoard(boardsize);
       /**setup new game and create cards*/
       game.board.newGame(cards);
       
       /** creating players*/
       for (int i=0;i<players;i++)
       {
           Gamer hrac=new Gamer();
           hrac.id=i;
           game.group.add(hrac);
       }
       /**default position for the players,find all free positions*/
       for(MazeField pom :game.board.board)
       {  
         if((pom.col==1 && pom.row==1)||(pom.col==game.board.sizeofgame && pom.row==1) || (pom.col==game.board.sizeofgame && pom.row==game.board.sizeofgame) || (pom.col==1 && pom.row==game.board.sizeofgame))  
         {
             game.stones.add(pom.getCard());
         }     
       }
       /**choose one free position and place players*/
       int countx =game.stones.size();
       for(int i=0;i<countx;i++)
       {
           if(i==players)
               break;
           Collections.shuffle(game.stones);
           game.initpos(game.stones.remove(0));
       }
       /** setup winning score*/
       game.win=cards/game.group.size();   
       /** setup names for the players */
       Avatar.names.add("blue");
       Avatar.names.add("red");
       Avatar.names.add("green");
       Avatar.names.add("purple");
       for(int i=0;i<names.size();i++)
       {
           Gamer player;
           player=game.group.get(i);
           player.Setname(names.get(i));
           
       }
       Avatar.names.removeAll(Avatar.names);
       /** return created game*/
   return game;
   }
   
   /**
    * Method will setup the leader of the game.
    */
   public  void Gamerturn()
   {    
       /** the new leader */
        leader=group.get(0);
   }
   /**
    * add the leader to the the of the group and setup the new leader
    */
   public void  Endturn()
   {
    leader.undo.clear(); 
    
    /** remove leader*/
    Gamer hrac=group.remove(0);
    board.cannot="";
    /** setup new*/
    group.add(hrac);
    leader=group.get(0);
    /** return the new leader */
   }

   /**
    * Initialize the default position of the players 
    * @param p is a position for the players.
    */
    public void initpos(MazeCard p)
    {
       Gamer hrac=group.remove(0);
       group.add(hrac);
       p.stay.add(hrac);
       hrac.position=p;   
    }
   /**
    * Player pulls card from the cardpack
    * if the object on the card is same as the object on the player's field then score is incremented 
    */ 
   public void pullcard()
   {
     /**set up the  leader*/
     Gamerturn(); 
     /** pull the card  max one */
     if(!"".equals(leader.karta.types) && undo==false)
         return;      
     leader.karta=board.balicek.Givemecard();
     /** find my position */
     for(int i = 1; i <= board.sizeofgame; i++){
          for (int j = 1; j <= board.sizeofgame; j++) {
              MazeField a = board.get(i,j);
              MazeCard b =a.getCard();  
 
              if(b==leader.position)
              {
                    /** if object on my position is same then increment the score*/
                    if(leader.position.Card.equals(leader.karta.types))
                    {
                        if(undo==false)
                        {
                            leader.undo.add(leader.karta.types);
                            leader.undo.add("pullx");
                        }
                        //increment score
                        leader.score+=1;
                        //leader's card 
                        leader.karta.types="";
                        // null card on the field
                        leader.position.Card="p";
                    }
                    else if(undo==false)
                        leader.undo.add("pull");
              }
          }}
    /**calling score check */
   }
   
   /**
    * Method implements player's move to the right position.
    * If it is not possible than do nothing!
    */
   public void goright()
   {
        /** setup the new leader*/
        Gamerturn();
    if(leader.undo.size()>0 && undo==false && (leader.undo.get(leader.undo.size()-1)=="left" || leader.undo.get(leader.undo.size()-1)=="leftx"))
        return;
        for(int i = 1; i <= board.sizeofgame; i++)
        {
              for (int j = 1; j <= board.sizeofgame; j++) 
              {
                  MazeField a = board.get(i,j);
                  MazeCard b =a.getCard();  
                  if(b==leader.position)
                  {
                     if(j!=board.sizeofgame)
                     {
                        MazeField where = board.get(i,j+1); 
                        MazeCard move =where.getCard();
                        /** checks if the player can go to this position */
                         if( move.canGo(MazeCard.CANGO.LEFT) &&  b.canGo(MazeCard.CANGO.RIGHT))       
                         {   
                             move.stay.add(leader);
                             b.stay.remove(leader); 
                             leader.position=move;
                             board.cannot="";

                             /** if object on my position is same then increment the score*/
                             if(leader.position.Card.equals(leader.karta.types))
                             {
                                 if(undo==false)
                                 {
                                     leader.undo.add(leader.position.Card);
                                     leader.undo.add("rightx");
                                 }
                                 leader.score+=1;
                                 leader.karta.types="";
                                 leader.position.Card="p";
                             }
                             else if(undo==false)
                                 leader.undo.add("right");
                             return;
                         }
                     }
                  }  
              }
        }  
   }
    
   /**
    * Method implements player's move to the left position.
    * If it is not possible than do nothing!
    */
   public void goleft()
   {  
    Gamerturn();
    
if(leader.undo.size()>0  && undo==false && (leader.undo.get(leader.undo.size()-1)=="right" || leader.undo.get(leader.undo.size()-1)=="rightx"))
    return;


    for(int i = 1; i <= board.sizeofgame; i++){
          for (int j = 1; j <= board.sizeofgame; j++) {
              MazeField a = board.get(i,j);
              MazeCard b =a.getCard();  
              if(b==leader.position)
              {
		
                 if(j!=1)
                 {
                    MazeField where = board.get(i,j-1); 
                    MazeCard move =where.getCard();

                     if( move.canGo(MazeCard.CANGO.RIGHT)&&  b.canGo(MazeCard.CANGO.LEFT))       
                     {   
                         move.stay.add(leader);
                         b.stay.remove(leader); 
                         leader.position=move;
                         board.cannot="";
                         if(leader.position.Card.equals(leader.karta.types))
                         {
                             if(undo==false)
                             {
                                leader.undo.add(leader.position.Card);
                                leader.undo.add("leftx");
                             }
                             leader.score+=1;
                             leader.karta.types="";
                             leader.position.Card="p";
                         }
                         else if(undo==false)
                             leader.undo.add("left");
                         return;
                     }
                 }
              }  
          }
      }  
   }
    /**
    * Method implements player's move to the up position.
    * If it is not possible than do nothing!
    */
   public void goup()
   {  
    Gamerturn();
    if(leader.undo.size()>0  && undo==false && (leader.undo.get(leader.undo.size()-1)=="down" || leader.undo.get(leader.undo.size()-1)=="downx"))
        return;
    for(int i = 1; i <= board.sizeofgame; i++){
          for (int j = 1; j <= board.sizeofgame; j++) {
              MazeField a = board.get(i,j);
              MazeCard b =a.getCard();  
              if(b==leader.position)
              {
                 if(i!=1)
                 {
                    MazeField where = board.get(i-1,j); 
                    MazeCard move =where.getCard();
                     if( move.canGo(MazeCard.CANGO.DOWN)&& b.canGo(MazeCard.CANGO.UP))       
                     {   
                         move.stay.add(leader);
                         b.stay.remove(leader);
                         leader.position=move;
                         board.cannot="";
                         if(leader.position.Card.equals(leader.karta.types))
                         {
                             if(undo==false)
                             {
                                 leader.undo.add(leader.position.Card);
                                 leader.undo.add("upx");
                             }
                             leader.score+=1;
                             leader.karta.types="";
                             leader.position.Card="p";
                         }
                         else if(undo==false)
                             leader.undo.add("up");
                         return;
                     }
                 }
              }  
          }
      }  
   }  
   
    /**
    * Method implements player's move to the down position.
    * If it is not possible than do nothing!
    */
   public void godown()
   {  
    Gamerturn();
    if(leader.undo.size()>0 && undo==false && (leader.undo.get(leader.undo.size()-1)=="up" || leader.undo.get(leader.undo.size()-1)=="upx"))
        return;
    for(int i = 1; i <= board.sizeofgame; i++){
          for (int j = 1; j <= board.sizeofgame; j++) {
              MazeField a = board.get(i,j);
              MazeCard b =a.getCard();  
              if(b==leader.position)
              {
                 if(i!=board.sizeofgame)
                 {
                    MazeField where = board.get(i+1,j); 
                    MazeCard move =where.getCard();
                     if( move.canGo(MazeCard.CANGO.UP)&&  b.canGo(MazeCard.CANGO.DOWN))       
                     {   
                         move.stay.add(leader);
                         b.stay.remove(leader);
                         leader.position=move; 
                         board.cannot="";
                         if(leader.position.Card.equals(leader.karta.types))
                         {
                             if(undo==false)
                             {
                                 leader.undo.add(leader.position.Card);
                                 leader.undo.add("downx");
                             }
                             leader.score+=1;
                             leader.karta.types="";
                             leader.position.Card="p";
                         }
                         else if(undo==false)
                             leader.undo.add("down");
                         return;
                     }
                 }
              }  
          }
      }  
   }
   public void undo()
   {
       MazeField kde;
       Card karta=new Card();
       /**
        * When shift was performed , we shift back
        */
       if(leader.undo.isEmpty())
           return;  
       String lastaction=leader.undo.remove(leader.undo.size()-1);
       String card;
       if(lastaction.startsWith("xx"))
       {
           String kam=lastaction.substring(2);
           String[] numbers=kam.split(":");
           int row=Integer.parseInt(numbers[0]);
           int  col=Integer.parseInt(numbers[1]);
           kde=board.get(row, col);
           board.shift(kde, leader.undo, true);
           return;
       }
       
       undo=true;
       switch(lastaction)
       {
           case "down":
             goup();
             break;
           case "up":
              godown();
              break;
           case "left":
              goright();
              break;
           case "right":
               goleft();
               break;
           case "rightx":
               card=leader.undo.remove(leader.undo.size()-1);
               leader.position.Card=card;
               goleft();
               leader.score--;
               leader.karta.types=card; 
               break;
           case "leftx":
               card=leader.undo.remove(leader.undo.size()-1);
               leader.position.Card=card;
               goright();
               leader.score--;
               leader.karta.types=card; 
               break;
           case "upx":
               card=leader.undo.remove(leader.undo.size()-1);
               leader.position.Card=card;
               godown();
               leader.score--;
               leader.karta.types=card; 
               break;
           case "downx":
               card=leader.undo.remove(leader.undo.size()-1);
               leader.position.Card=card;
               goup();
               leader.score--;
               leader.karta.types=card; 
               break;
           case "pullx":
               card=leader.undo.remove(leader.undo.size()-1);
               karta.types=card;
               board.balicek.pack.add(0,karta);
               leader.score--;
               leader.position.Card=card; 
               leader.karta.types=""; 
               break;
           case "pull":
               karta.types=leader.karta.types;
               board.balicek.pack.add(0,karta);
               leader.karta.types="";  
               break;
           case "shift":
               board.special.turnLeft();
               break;
       }
       undo=false;
   }  
}

