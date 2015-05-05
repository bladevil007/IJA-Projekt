
package ija.homework3.Gui;
import ija.homework3.Master;
import ija.homework3.board.MazeCard;
import ija.homework3.board.MazeField;
import ija.homework3.game.Game;
import ija.homework3.game.Gamer;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Font;

/**
 * Class implements graphical unit interface for the {@link Game}
 * @author Norbert Durcansky (xdurca01)<br>
 *         Jan Jusko (xjusko00)
 */
public class Gui extends javax.swing.JFrame {
    /**
    * ArrayList of labels,each label represents one field on the board
    */
    private ArrayList<JLabel> labels=new ArrayList<>();
    /**
    * ArrayList contains names of players
    */
    private ArrayList<String> names=new ArrayList<>();
    /**
    * Additional ArrayList for the left panel , which shows names of the players
    */
    private ArrayList<JLabel> labelnames=new ArrayList<>();
    /**
    * Save position of the free card
    */
    private int cardpos;
    /**
    * The {@link Master} instance representing game universe 
    */
    public Master universe=Master.create();
    /**
    * number of players
    */
    public int  players;
    /**
    * Trigger to enable the game 
    */
    private boolean play=false;
    /**
    * number of cards
    */
    public int  cards;
    /**
    * size of the board
    */
    public int  boardsize;
    /**
    * name of the file where the game will be saved to 
    */
    public String saveas;
    /**
    *  The {@link JScrollPane} instance rimplementing  vertical,horizontal scroll bar 
    */
    JScrollPane pane;
    /**
     * Creates new form Gui
     */
    public Gui() {
        /** init components */
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);
        this.setSize(1000,1000);
        this.setMinimumSize(new Dimension(1050, 700));  
        /** add panels to the frame*/    
        this.add(panel1);
        this.add(panel2);
        /** set win dialog window size */
        youWin.setSize(500, 200);
        youWin.setLocation(this.getWidth()/2-200, this.getHeight()/2);
        pane = new JScrollPane(getContentPane(),

        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        this.setContentPane(pane);
        pane.setPreferredSize(new Dimension(900, 900));     
        
    }
    /**
     * This method is called from within the constructor to initialize the form. 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        Ptextfield = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Ntextfield = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Ctextfield = new javax.swing.JTextField();
        start = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        filechooser = new javax.swing.JFileChooser();
        namesDialog = new javax.swing.JDialog();
        player1 = new javax.swing.JTextField();
        player2 = new javax.swing.JTextField();
        player3 = new javax.swing.JTextField();
        player4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        playersOK = new javax.swing.JButton();
        playersCLEAR = new javax.swing.JButton();
        playersEXIT = new javax.swing.JButton();
        savegame_dialog = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        savegamename = new javax.swing.JTextField();
        save_button = new javax.swing.JButton();
        youWin = new javax.swing.JDialog();
        Won = new javax.swing.JLabel();
        youWinEnd = new javax.swing.JButton();
        youWinReturn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        panel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        leaderlabel = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        label_card = new javax.swing.JLabel();
        Card = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Next = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newGame = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        saveGame = new javax.swing.JMenuItem();
        exitGame = new javax.swing.JMenuItem();
        UndoMenu = new javax.swing.JMenu();
        Undo = new javax.swing.JMenuItem();

        jLabel1.setText("Number of Players:");

        jLabel2.setText("Size of board:");

        Ntextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NtextfieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Number of cards:");

        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Ptextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(Ntextfield)
                    .addComponent(Ctextfield))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addGap(0, 103, Short.MAX_VALUE)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Ptextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Ntextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Ctextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear)
                    .addComponent(exit)
                    .addComponent(start))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jLabel5.setText("Choose names:");

        playersOK.setText("OK");
        playersOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playersOKActionPerformed(evt);
            }
        });

        playersCLEAR.setText("Clear");
        playersCLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playersCLEARActionPerformed(evt);
            }
        });

        playersEXIT.setText("Exit");
        playersEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playersEXITActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout namesDialogLayout = new javax.swing.GroupLayout(namesDialog.getContentPane());
        namesDialog.getContentPane().setLayout(namesDialogLayout);
        namesDialogLayout.setHorizontalGroup(
            namesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namesDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addGroup(namesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(namesDialogLayout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(playersOK, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playersCLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playersEXIT, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        namesDialogLayout.setVerticalGroup(
            namesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namesDialogLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(namesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(player3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(player4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(namesDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playersOK)
                    .addComponent(playersCLEAR)
                    .addComponent(playersEXIT))
                .addGap(47, 47, 47))
        );

        jLabel8.setText("Save as:");

        save_button.setText("Save");
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout savegame_dialogLayout = new javax.swing.GroupLayout(savegame_dialog.getContentPane());
        savegame_dialog.getContentPane().setLayout(savegame_dialogLayout);
        savegame_dialogLayout.setHorizontalGroup(
            savegame_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savegame_dialogLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(savegamename, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(save_button, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        savegame_dialogLayout.setVerticalGroup(
            savegame_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(savegame_dialogLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(savegame_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(savegamename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save_button))
                .addGap(51, 51, 51))
        );

        Won.setText("You won!");

        youWinEnd.setText("End game");
        youWinEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youWinEndActionPerformed(evt);
            }
        });

        youWinReturn.setText("Return");
        youWinReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youWinReturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout youWinLayout = new javax.swing.GroupLayout(youWin.getContentPane());
        youWin.getContentPane().setLayout(youWinLayout);
        youWinLayout.setHorizontalGroup(
            youWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, youWinLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(youWinReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(youWinEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, youWinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Won)
                .addGap(188, 188, 188))
        );
        youWinLayout.setVerticalGroup(
            youWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(youWinLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(Won)
                .addGap(48, 48, 48)
                .addGroup(youWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(youWinEnd)
                    .addComponent(youWinReturn))
                .addGap(36, 36, 36))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(200, 149, 97));

        jLabel4.setText("Players:");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 674, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 611, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        jButton1.setText("UP");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("DOWN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("LEFT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("RIGHT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Leader:");

        jButton5.setText("Rotate free card");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setText("Current card:");

        Card.setText("Card");
        Card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardActionPerformed(evt);
            }
        });

        jLabel9.setText("Score:");

        Next.setText("Next");
        Next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextActionPerformed(evt);
            }
        });

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Col");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Row");

        jButton6.setText("Insert");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        newGame.setText("New game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        jMenu1.add(newGame);

        jMenuItem1.setText("Load game");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        saveGame.setText("Save game");
        saveGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveGameActionPerformed(evt);
            }
        });
        jMenu1.add(saveGame);

        exitGame.setText("Exit");
        exitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitGameActionPerformed(evt);
            }
        });
        jMenu1.add(exitGame);

        jMenuBar1.add(jMenu1);

        UndoMenu.setText("Edit");

        Undo.setText("Undo");
        Undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoActionPerformed(evt);
            }
        });
        UndoMenu.add(Undo);

        jMenuBar1.add(UndoMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(107, 107, 107)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(leaderlabel)
                        .addGap(100, 100, 100)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(label_card)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(Card, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Next, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)))
                                .addContainerGap())))))
            .addGroup(layout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(leaderlabel)
                        .addComponent(jLabel7)
                        .addComponent(jButton1)
                        .addComponent(jLabel4)
                        .addComponent(label_card)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton3)
                                    .addComponent(jButton4))
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Card)
                                    .addComponent(Next))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                    .addComponent(jTextField1))
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addGap(185, 185, 185)
                                .addComponent(jLabel13)
                                .addGap(107, 107, 107)
                                .addComponent(jLabel14)
                                .addGap(86, 86, 86)
                                .addComponent(jLabel15)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel16))
                            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed
    /**
    * Function implements exit button
    */
    private void exitGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitGameActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitGameActionPerformed

    /**
    * Function implements new game button action
    */
    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        jDialog1.setSize(380, 280);
        jDialog1.setVisible(true);
        
    }//GEN-LAST:event_newGameActionPerformed

    private void NtextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NtextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NtextfieldActionPerformed
    /**
    * Function implements clear action 
    */
    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        Ntextfield.setText("");
        Ptextfield.setText("");
        Ctextfield.setText("");
        
    }//GEN-LAST:event_clearActionPerformed
    /**
    * Function implements exit action
    */
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        Ntextfield.setText("");
        Ptextfield.setText("");
        Ctextfield.setText("");
        jDialog1.setVisible(false);
    }//GEN-LAST:event_exitActionPerformed
    /**
    * Function  implements startup operations , assigning values, exception catcher, etc..
    */
    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
        // store values into the variables  
        try{
                boardsize = Integer.parseInt(Ntextfield.getText())+2;
                players = Integer.parseInt(Ptextfield.getText());
                cards = Integer.parseInt(Ctextfield.getText());
            }
        catch(Exception e)
            {
                return;
            }
        if(boardsize-2 > 11 || boardsize-2 < 5 || (boardsize-2)%2==0){
            return;
        }
        
        if(players > 4 || players < 2){
            return;
        }
        
        if(cards != 12 && cards != 24){
            return;
        }
        // "close" the window
        jLabel4.setText("Players: "+Integer.toString(players));
        Ntextfield.setText("");
        Ptextfield.setText("");
        Ctextfield.setText("");
        jDialog1.setVisible(false);
        namesDialog.setSize(380, 280);
        
        if(players == 2){
            player3.setVisible(false);
            player4.setVisible(false);
        }
        else if(players == 3){

            player3.setVisible(true);
            player4.setVisible(false);
        }
        else
        {
            player3.setVisible(true);   
            player4.setVisible(true);
        }
        namesDialog.setVisible(true);     
    }//GEN-LAST:event_startActionPerformed
    /**
    * Function implements loading game from the file 
    */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        FileFilter filter = new FileNameExtensionFilter("sav File","sav");
        filechooser.setFileFilter(filter);
        filechooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int returnVal = filechooser.showOpenDialog(this);
        File file=filechooser.getSelectedFile();
        if(file!=null)
             universe.load(file.getAbsolutePath());
        else
            return;       
        play=true; 
        refreshboard();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    /**
    * New game was created , assign values to variables 
    */
    private void playersOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playersOKActionPerformed
        // TODO add your handling code here:
        names.removeAll(names);
        
        if("".equals(player1.getText()) && player1.isVisible()){
            return;
        }
        if("".equals(player2.getText()) && player2.isVisible()){
            return;
        }
        if("".equals(player3.getText()) && player3.isVisible()){
            return;
        }
        if("".equals(player4.getText()) && player4.isVisible()){
            return;
        }
        
        names.add(player1.getText());
        names.add(player2.getText());
        if(players == 3)
        {
            names.add(player3.getText());
        }
        if(players == 4){
            names.add(player3.getText());
            names.add(player4.getText());
        }
        //clear
        player1.setText("");
        player2.setText("");
        player3.setText("");
        player4.setText("");
        namesDialog.setVisible(false);
    try {
        createboard();
    } catch (IOException ex) {
        Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
    }    
    }//GEN-LAST:event_playersOKActionPerformed
    /**
    * Function clears fields
    */
    private void playersCLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playersCLEARActionPerformed
        // TODO add your handling code here:
        player1.setText("");
        player2.setText("");
        player3.setText("");
        player4.setText("");
    }//GEN-LAST:event_playersCLEARActionPerformed
    /**
    * Function clears fields and closes dialog window
    */
    private void playersEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playersEXITActionPerformed
        // TODO add your handling code here:
        player1.setText("");
        player2.setText("");
        player3.setText("");
        player4.setText("");
        namesDialog.setVisible(false);
    }//GEN-LAST:event_playersEXITActionPerformed
    /**
    * Function implements saving game to file 
    */
    private void saveGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveGameActionPerformed
        // TODO add your handling code here:
        savegame_dialog.setSize(500, 140);
        savegame_dialog.setVisible(true);
    }//GEN-LAST:event_saveGameActionPerformed
    /**
    * Function implements saving game to file, set the file filter
    */
    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
    try {
        // TODO add your handling code here:
        universe.save("examples/"+savegamename.getText()+".sav");
        } catch (IOException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        savegamename.setText("");
        savegame_dialog.setVisible(false);
    }//GEN-LAST:event_save_buttonActionPerformed
    /**
    * Function implements right move 
    */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(play==false)
            return;
        if( universe.hra.leader.karta.types=="")
            return;
        universe.hra.goright();       
        refreshboard();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
    * Function implements left move 
    */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(play==false)
            return;       
        if(universe.hra.leader.karta.types=="")
            return;
        universe.hra.goleft();
        refreshboard();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
    * Function implements up move 
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(play==false)
            return;

        if(universe.hra.leader.karta.types=="")
            return;
        universe.hra.goup();
        refreshboard();
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
    * Function implements down move 
    */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(play==false)
            return;
        if(universe.hra.leader.karta.types=="")
            return;   
        universe.hra.godown();
        refreshboard();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * Function implements pull card action
    */
    private void CardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardActionPerformed
        // TODO add your handling code here:
        if(play==false)
            return;
        if(universe.hra.leader.karta.types!="")
            return;
        universe.hra.pullcard(); 
        refreshboard();
        
    }//GEN-LAST:event_CardActionPerformed

    /**
    * Function implements undo action
    */
    private void UndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoActionPerformed
        if(play==false)
            return;
        universe.hra.undo();
        refreshboard();
    }//GEN-LAST:event_UndoActionPerformed

    /**
    * Function implements rotate action of the free card
    */
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if(play==false)
            return;
        if(universe.hra.leader.karta.types=="")
            return;
        if(universe.hra.leader.undo.size()>0)
        {
           String und=universe.hra.leader.undo.get(universe.hra.leader.undo.size()-1);
           if(und.equals("pull")==false && und.equals("shift")==false)
               return;    
        }
        universe.hra.board.special.turnRight(universe.hra.leader.undo);
        refreshboard();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
    * Function implements End of the turn 
    */
    private void NextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextActionPerformed
        // TODO add your handling code here:
        if(play==false)
            return;
        universe.hra.Endturn();
        initfields();
        refreshboard();
    }//GEN-LAST:event_NextActionPerformed

    /**
    * Function implements shift of the row  or col 
    */
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here: 
        if(play==false)
            return;
        if(universe.hra.leader.karta.types=="")
            return;
        /** rules of the game */
        if(universe.hra.leader.undo.size()>0)
        {
            String und=universe.hra.leader.undo.get(universe.hra.leader.undo.size()-1);
           if(((und.equals("pull")==false && und.equals("shift")==false ) || und.startsWith("xx")) 
                   ||und.startsWith("down") || und.startsWith("up") || und.startsWith("left") || und.startsWith("right") )
               return;    
        }

        int col=Integer.valueOf(jTextField2.getText());
        int row=Integer.valueOf(jTextField1.getText());

        if(col<1 || col>universe.hra.board.sizeofgame || row<1 || row>universe.hra.board.sizeofgame)
            return;

        MazeField policko=universe.hra.board.get(row, col);
        int pom=universe.hra.leader.undo.size();
        universe.hra.board.shift(policko,universe.hra.leader.undo,false); 
        String[] where;
        /** set up new position for the free card */
        if(universe.hra.leader.undo.size()>pom)
        {
            initfields();
            where=(universe.hra.leader.undo.get(universe.hra.leader.undo.size()-1).substring(2)).split(":");
            row=Integer.valueOf(where[0]);
            col=Integer.valueOf(where[1]);           
            if(row==universe.hra.board.sizeofgame)
            { 
                cardpos=col+boardsize*(boardsize-1);
                refreshboard();
            }
            if(row==1)
            {
                cardpos=col;
                refreshboard();
            }
            if(col==1)
            {
                cardpos=(boardsize*(row));
                       
                refreshboard();
            }
            if(col==universe.hra.board.sizeofgame)
            {
                cardpos=(boardsize*(row))+(boardsize-1);
                refreshboard();
            }
        }
  
    }//GEN-LAST:event_jButton6ActionPerformed
    /**
    * Someone won the game  
    */
    private void youWinEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_youWinEndActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_youWinEndActionPerformed

    /**
    * Someone won the game  
    */
    private void youWinReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_youWinReturnActionPerformed
        // TODO add your handling code here:
        initfields();
        youWin.setVisible(false);
        panel1.setVisible(false);
        panel2.setVisible(false);
        
    }//GEN-LAST:event_youWinReturnActionPerformed

    /**
     * Static main function of the gui 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
 java.awt.EventQueue.invokeLater(new Runnable() {
           @Override
            public void run() {
                new Gui();     
            }
            
        }
        );   
    }  
    /**
    * Function implements creating new board 
    */
    private void createboard() throws IOException{
    /** enable game mode*/
    play=true;
    panel1.removeAll();
    labels.removeAll(labels);
    label_card.setText("");
    jProgressBar1.setValue(0);
    panel2.removeAll();
    labelnames.removeAll(labelnames);
    /** create game */
    universe.hra=Game.create(this.players,this.cards,this.boardsize-2,this.names);
    universe.hra.Gamerturn();
    cardpos=boardsize*(boardsize-1);
    /** set the default size of the panel */
    int size=700/boardsize;
    int pom=0; 
    int pom1=1;
    int x=0;
    int y=1;
      for(int i=0;i<boardsize*boardsize;i++)
        { 
          if(pom==boardsize)
          {
              pom=0;
              pom1++;
              x++;
              y=1;
          }
          pom++;  
        JLabel label=new JLabel();
        if(i>boardsize-1 && i<(boardsize-1)*boardsize && (i%boardsize!=0) && i!=boardsize*pom1-1)    
        { 
            
             //give me FIELD
             MazeField a =  universe.hra.board.get(x,y);
             //give me Card
             MazeCard b =a.getCard();             
            String file=String.valueOf(b.types); 
   
            //fields
            ImageIcon myIcon2=new ImageIcon("lib/objects/"+getfile(b)+".jpg");
            Image img = myIcon2.getImage();
            Image background = img.getScaledInstance(size,size,  java.awt.Image.SCALE_SMOOTH);   
            ImageIcon newIcon = new ImageIcon(background); 
            

            
            //cards
            ImageIcon myIcon3=new ImageIcon("lib/objects/"+b.Card+".png");
            img = myIcon3.getImage();
            Image card = img.getScaledInstance(size,size,  java.awt.Image.SCALE_SMOOTH);   
            ImageIcon newIcon1 = new ImageIcon(card); 
            Gamer player=null;
            if(b.stay.size()>0)
                player=b.stay.get(0);
            
            Image playerpos=null;

            if(player!=null)
            {
                file=player.avatar.color;
                ImageIcon myIcon4=new ImageIcon("lib/objects/"+file+".png");
                img = myIcon4.getImage();
                playerpos = img.getScaledInstance(size,size,  java.awt.Image.SCALE_SMOOTH);   
                ImageIcon newIcon2 = new ImageIcon(playerpos); 
            }
            

            /** buffering images */
            /** creating one image from the MazeCard, Card and the players*/
            
            BufferedImage bigIcon;
            
            bigIcon = new BufferedImage(background.getWidth(null), background.getHeight(null),
            BufferedImage.TYPE_INT_RGB);
            
            BufferedImage finalIcon = new BufferedImage( bigIcon.getWidth(), bigIcon.getHeight(),BufferedImage.TYPE_INT_ARGB);
            
            Graphics2D g = (Graphics2D) finalIcon.getGraphics();
            
            g.drawImage(background,0,0,null); // start at (0, 0)
            g.drawImage(card, 0, 0, null); // start at (10, 10)
            if(player!=null)
               g.drawImage(playerpos,0,0,null); // start at (0, 0) 
            g.dispose();
            
            
            label.setIcon(new ImageIcon(finalIcon));

           y++;
        }else
            if(i!=0 && i<boardsize-1)
            {
                int pomx=i;
                label=new JLabel(String.valueOf(pomx));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setForeground(Color.WHITE);
            }
            else
            {
                int pomx=i/boardsize;
                if(pomx!=0 && pomx!=boardsize-1 && i%boardsize==0)
                {
                    label=new JLabel(String.valueOf(pomx));
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    label.setForeground(Color.WHITE);
                }
                if(i==boardsize*(boardsize-1))
                {
                    label=new JLabel();
                    ImageIcon myIcon3x=new ImageIcon("lib/objects/"+getfile(universe.hra.board.special)+".jpg");
                    Image imgx = myIcon3x.getImage();
                    Image cardx = imgx.getScaledInstance(size,size,  java.awt.Image.SCALE_SMOOTH);   
                    label.setIcon(new ImageIcon(cardx));
                    
                }
                
            }

        labels.add(label);
        }
      
        panel1.setSize(size*boardsize, size*boardsize);
        panel1.setLayout(new GridLayout(boardsize,boardsize));

        for(int i=0;i<boardsize*boardsize;i++)
        {
            panel1.add(labels.get(i));
        }
        panel1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel2.setLayout(new GridLayout(4,1));
        panel2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        for(int i=0; i<players; i++)
        {
          JLabel hrac = new JLabel();
          hrac.setText(universe.hra.group.get(i).name+" ("+universe.hra.group.get(i).avatar.color+")");
          labelnames.add(hrac);
        }
        //panel2.
        for(int i=0; i<players; i++)
        {
           panel2.add(labelnames.get(i));
        }

        leaderlabel.setForeground(getcolor(universe.hra.leader.avatar.color));
        leaderlabel.setText(universe.hra.leader.name);
        Font f= leaderlabel.getFont();
        leaderlabel.setFont(f.deriveFont(f.getStyle() | Font.BOLD));

        jLabel10.setText(String.valueOf(universe.hra.leader.score));
        double score=((double)universe.hra.leader.score/(double)universe.hra.win)*100;
        jProgressBar1.setValue((int)score);
        /** set the score */
        panel1.setVisible(true);
        panel2.setVisible(true);
        panel1.setBackground(new Color(53, 56, 64));

        panel1.revalidate();
        panel1.repaint();
        panel2.revalidate();
        panel2.repaint();
        this.repaint();  
   }
   
   /**
   * Function implements refreshing of the game
   */
   private void refreshboard()
   {
       panel1.removeAll();
       labels.removeAll(labels);
       panel2.removeAll();
       labelnames.removeAll(labelnames);
       boardsize=universe.hra.board.sizeofgame+2;
       players=universe.hra.group.size();

       int size=700/boardsize;
       int pom=0; 
       int pom1=1;
       int x=0;
       int y=1;
       labels.removeAll(labels);
       
       for(int i=0;i<boardsize*boardsize;i++)
        {
            //take label from arraylist 
            JLabel refresh=new JLabel();
            if(pom==boardsize)
            {
                pom=0;
                pom1++;
                x++;
                y=1;
            }
            pom++; 
            //refreshing board
            if(i>boardsize-1 && i<(boardsize-1)*boardsize && (i%boardsize!=0) && i!=boardsize*pom1-1)    
            { 
                //give me FIELD
                MazeField a =  universe.hra.board.get(x,y);
                //give me Card
                MazeCard b =a.getCard();

               String file=String.valueOf(b.types); 

               //fields
               ImageIcon myIcon2=new ImageIcon("lib/objects/"+getfile(b)+".jpg");
               Image img = myIcon2.getImage();
               Image background = img.getScaledInstance(size,size,  java.awt.Image.SCALE_SMOOTH);   
               ImageIcon newIcon = new ImageIcon(background); 

               //cards
               ImageIcon myIcon3=new ImageIcon("lib/objects/"+b.Card+".png");
               img = myIcon3.getImage();
               Image card = img.getScaledInstance(size,size,  java.awt.Image.SCALE_SMOOTH);   
               ImageIcon newIcon1 = new ImageIcon(card);
            
               
            BufferedImage bigIcon;
            
            
            bigIcon = new BufferedImage(background.getWidth(null), background.getHeight(null),
            BufferedImage.TYPE_INT_RGB);
            
            BufferedImage finalIcon = new BufferedImage( bigIcon.getWidth(), bigIcon.getHeight(),BufferedImage.TYPE_INT_ARGB);
            
            Graphics2D g = (Graphics2D) finalIcon.getGraphics();
            //start drawing 
            g.drawImage(background,0,0,null); // start at (0, 0)
            g.drawImage(card, 0, 0, null); // start at (10, 10)  
            Gamer player;
            /** draw all players */
            for (Gamer stay : b.stay) {
                    player = stay;
                    file=player.avatar.color;
                    ImageIcon myIcon4=new ImageIcon("lib/objects/"+file+".png");
                    img = myIcon4.getImage();
                    Image playerpos = img.getScaledInstance(size,size,  java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newIcon2 = new ImageIcon(playerpos);
                    g.drawImage(playerpos, 0, 0, null);
                }
            y++;
            refresh.setIcon(new ImageIcon(finalIcon));
            g.dispose();
            }
            else
                {
                    int pomx=i/boardsize;
                    if(i==cardpos)
                    {
                        refresh=new JLabel();
                        ImageIcon myIcon3x=new ImageIcon("lib/objects/"+getfile(universe.hra.board.special)+".jpg");
                        Image imgx = myIcon3x.getImage();
                        Image cardx = imgx.getScaledInstance(size,size,  java.awt.Image.SCALE_SMOOTH); 
                        ImageIcon newIcon = new ImageIcon(cardx); 
                        
                        
                         ImageIcon myIcon3=new ImageIcon("lib/objects/"+universe.hra.board.special.Card+".png");
                         Image img = myIcon3.getImage();
                         Image card = img.getScaledInstance(size,size,  java.awt.Image.SCALE_SMOOTH);   
                         ImageIcon newIcon1 = new ImageIcon(card);
            
               
                         BufferedImage bigIcon;
            
            
                        bigIcon = new BufferedImage(cardx.getWidth(null), cardx.getHeight(null),
                        BufferedImage.TYPE_INT_RGB);

                        BufferedImage finalIcon = new BufferedImage( bigIcon.getWidth(), bigIcon.getHeight(),BufferedImage.TYPE_INT_ARGB);

                        Graphics2D g = (Graphics2D) finalIcon.getGraphics();
                        //start drawing 
                        g.drawImage(cardx,0,0,null); // start at (0, 0)
                        g.drawImage(card,0,0,null); // start at (0, 0)
                        g.dispose();
                      refresh.setIcon(new ImageIcon(finalIcon));      
                    }
                    else
                        if(i!=0 && i<boardsize-1)
                        {
                            pomx=i;
                            refresh=new JLabel(String.valueOf(pomx));
                            refresh.setHorizontalAlignment(SwingConstants.CENTER);
                            refresh.setForeground(Color.WHITE);
                        }
                    else
                        if(pomx!=0 && pomx!=boardsize-1 && i%boardsize==0)
                        {
                            refresh=new JLabel(String.valueOf(pomx));
                            refresh.setHorizontalAlignment(SwingConstants.CENTER);
                            refresh.setForeground(Color.WHITE);
                        }
                }
            labels.add(refresh);
        }
       
        panel1.setSize(size*boardsize, size*boardsize);
        panel1.setLayout(new GridLayout(boardsize,boardsize));

        for(int i=0;i<boardsize*boardsize;i++)
        {
            panel1.add(labels.get(i));
        }
        
        panel1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel2.setLayout(new GridLayout(4,1));
        panel2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        for(int i=0; i<players; i++)
        {
             JLabel hrac = new JLabel();
             hrac.setText(universe.hra.group.get(i).name+" ("+universe.hra.group.get(i).avatar.color+")");
             labelnames.add(hrac);
        }
        for(int i=0; i<players; i++)
        {
            panel2.add(labelnames.get(i));
        }
        // window.add(panel);
        leaderlabel.setForeground(getcolor(universe.hra.leader.avatar.color));
        leaderlabel.setText(universe.hra.leader.name);
        Font f= leaderlabel.getFont();
        leaderlabel.setFont(f.deriveFont(f.getStyle() | Font.BOLD));

        label_card.setText(universe.hra.leader.karta.types);
        jLabel10.setText(String.valueOf(universe.hra.leader.score));
        double score=((double)universe.hra.leader.score/(double)universe.hra.win)*100;
        jProgressBar1.setValue((int)score);
        if(score == 100){
            play=false;
            Won.setHorizontalAlignment(SwingConstants.CENTER);
            Won.setText("The Winner is "+universe.hra.leader.name+" !!");
            youWin.setVisible(true);
        }
        panel1.setBackground(new Color(53, 56, 64));
        panel1.revalidate();
        panel1.repaint();
        panel2.revalidate();
        panel2.repaint();
        this.repaint(); 
   }
    /**
    * Private Function to resolve file for the {@link MazeField} 
    */
    private String getfile(MazeCard card)
    {
      String file="T";
   
      switch(card.types)
      {
          
          case 'I':
              if(card.cesta.contains(MazeCard.CANGO.UP))
                  file="I";
              else file="Id";
              break;
          case 'L':
              if(card.cesta.contains(MazeCard.CANGO.UP))
                  if(card.cesta.contains(MazeCard.CANGO.LEFT))
                      file="L";
                  else file="Ld";
              else 
                  if(card.cesta.contains(MazeCard.CANGO.LEFT))
                      file="Ldd";
                  else file="Lddd";
              break;
          case 'T':
              if(card.cesta.contains(MazeCard.CANGO.LEFT) && (card.cesta.contains(MazeCard.CANGO.RIGHT)) &&(card.cesta.contains(MazeCard.CANGO.UP)))
                  file="T";
              else if(card.cesta.contains(MazeCard.CANGO.DOWN) && (card.cesta.contains(MazeCard.CANGO.RIGHT)) &&(card.cesta.contains(MazeCard.CANGO.UP)))
                  file="Td";
              else if(card.cesta.contains(MazeCard.CANGO.LEFT) && (card.cesta.contains(MazeCard.CANGO.RIGHT)) &&(card.cesta.contains(MazeCard.CANGO.DOWN)))
                  file="Tdd";
              else if(card.cesta.contains(MazeCard.CANGO.LEFT) && (card.cesta.contains(MazeCard.CANGO.DOWN)) &&(card.cesta.contains(MazeCard.CANGO.UP)))
                  file="Tddd";
              break;   
      }  
    return file;
    }

    /**
    * Private Function to resolve color of the player's name 
    */
    private Color getcolor(String color)
    {
      switch(color)
      {
          case "red":
              return new Color(160,8,8);
          case "purple":
              return new Color(98,41,125);
          case "green":
              return new Color(19,110,12);
          case "blue":
              return new Color(21,15,132);
      }
    return Color.yellow;
    }
    /**
    * clear all fields in the frame 
    */
    private void initfields()
    {
          leaderlabel.setText("");
          label_card.setText("");
          jLabel10.setText("");
          jTextField1.setText("");
          jTextField2.setText("");
          jProgressBar1.setValue(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Card;
    private javax.swing.JTextField Ctextfield;
    private javax.swing.JButton Next;
    private javax.swing.JTextField Ntextfield;
    private javax.swing.JTextField Ptextfield;
    private javax.swing.JMenuItem Undo;
    private javax.swing.JMenu UndoMenu;
    private javax.swing.JLabel Won;
    private javax.swing.JButton clear;
    private javax.swing.JButton exit;
    private javax.swing.JMenuItem exitGame;
    private javax.swing.JFileChooser filechooser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel label_card;
    private javax.swing.JLabel leaderlabel;
    private javax.swing.JDialog namesDialog;
    private javax.swing.JMenuItem newGame;
    private java.awt.Panel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JTextField player1;
    private javax.swing.JTextField player2;
    private javax.swing.JTextField player3;
    private javax.swing.JTextField player4;
    private javax.swing.JButton playersCLEAR;
    private javax.swing.JButton playersEXIT;
    private javax.swing.JButton playersOK;
    private javax.swing.JMenuItem saveGame;
    private javax.swing.JButton save_button;
    private javax.swing.JDialog savegame_dialog;
    private javax.swing.JTextField savegamename;
    private javax.swing.JButton start;
    private javax.swing.JDialog youWin;
    private javax.swing.JButton youWinEnd;
    private javax.swing.JButton youWinReturn;
}

    
