package ija.homework3.ui;

import ija.homework3.Master;
import java.io.BufferedReader;
import ija.homework3.board.MazeCard;
import ija.homework3.board.MazeField;
import ija.homework3.game.Game;
import ija.homework3.game.Gamer;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ui{
    private boolean New=false;
    private   Master universe;
    /**
     * Constructor.
     * @param universe
     */
    public ui(Master universe ) {
        this.universe=universe;
    }
    
    /**
     * Starts a process of reading commands from standard input and their processing. 
     * It calls the method {@link #processString} to process and execute commands.
     */
    public void start() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean end = false;
        
        
        while (! end) {
            try {
                System.out.print("Prompt>");
                String str = in.readLine();
                end = processString(str);
            } catch (IOException ex) {
                Logger.getLogger(ui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Analyses the input string and executes the command.
     * If the command does not exist or the string is invalid, the method does nothing.
     * @param str Input string
     * @return Returns true if the command end was typed; otherwrise it returns false.
     */
    protected boolean processString(String str) {
        boolean end = false;
        switch(str) {
            case "q"  :   end = true;
                            break;
            case "n"   :
                New=true;
                //inicializacne pozicie 
                //hra.board.newGame(24);
                ArrayList<String> players=new ArrayList<>();
                players.add("Noro");
                players.add("asdas");

              universe.hra=Game.create(2,24,5,players);
              universe.hra.Gamerturn();
                break;
                      
            case "p":
                if(New==true){
                    for(int i = 1; i <=  universe.hra.board.sizeofgame; i++){
                        for (int j = 1; j <=  universe.hra.board.sizeofgame; j++) {
                            MazeField a =  universe.hra.board.get(i,j);
                            MazeCard b =a.getCard();
                            System.out.print(b.Card);  
                            System.out.print("  ");
                        }
                        System.out.print("\n");
                    }
                    System.out.println("Volna karta:"+( universe.hra.board.special).types+( universe.hra.board.special).Card+( universe.hra.board.special).cesta);
                   int idx = 0;                    
                }
                else
                {
                    System.err.print("Nejprve vytvor hru\n");    
                }
                break;
            default:
                int row;
                int col;
                MazeField kam;
                if(str.length()==3 && str.charAt(0)=='s'  && Character.isDigit(str.charAt(1))  && Character.isDigit(str.charAt(2)) && New)
                {
                    row=(int)str.charAt(1)-'0';
                    col=(int)str.charAt(2)-'0';
		      if(row<= universe.hra.board.sizeofgame && col <= universe.hra.board.sizeofgame)
			{
                                    kam= universe.hra.board.get(row,col);
                                    universe.hra.board.shift(kam,universe.hra.leader.undo,false);   //uloz do undo posledny tah    
			}
			else 
				System.err.print("Chybni prikaz\n");
                }
                else
                {
                   System.err.print("Chybni prikaz\n");
                }
                break;
 
            case "card":
                universe.hra.pullcard();
                System.out.print(universe.hra.leader.karta.types);
                break; 
              case "r":
                    universe.hra.goright();
                  break;
              case "l":
                  universe.hra.goleft();
                  break;
              case "d":
                 universe.hra.godown();
                    break;
               case "u":
                   universe.hra.goup();
                  break;
               case "next":
                   universe.hra.Endturn();
                   break;
               case "leader":
                  int idx=0;
                  for(Gamer o : universe.hra.group)
                  {
                    System.out.print(o.name+"  ");
                    System.out.println(o.avatar.color);
                  idx++;
                  }             
                  
                 System.out.print(universe.hra.leader.name);
                 System.out.println(universe.hra.leader.score);
                 // System.out.println(hra.win);
                 break;
                 case "undo":
                     universe.hra.undo();
                 break;
                     
                  case "save":
                    {
                        try {
                            universe.save("game.sav");
                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(ui.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                      
                  case "load":
                      New=true;
                      universe.load("game.sav");
                      break;     
                  case "shift":
                      universe.load("undo.sav");
                      System.out.println(universe.hra.board.special.cesta);
                      universe.hra.board.special.turnRight(null);
                      System.out.println(universe.hra.board.special.cesta);
                      break;
                  
       }
        return end;
    }
}
