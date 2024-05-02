package mainselection;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
//import java.util.concurrent.Flow;

import MainGame.Main.GameFrame;
import characterselection.*;
import Classes.*;


public class MainSelection extends JPanel implements Runnable, ActionListener{

    public boolean SwitchMainPanels = true;
    MainSelectionVars vars = new MainSelectionVars();
    characterselection.MainMenu menu = new MainMenu();
    MainClass main = new MainClass();
    public JPanel pnlSubClasses = new JPanel();

    public MainSelection(){

        MainClassPanelSetup();

        SubClassesPanelSetup();
        
    }

    public void RunStart() {
		vars.thread = new Thread(this);
		vars.thread.start();
		
	}

///////////////////////////////////////////////////////////////////
    @Override
    public void run() {
		double drawInterval = 1000000000/60;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;        
        long timer = 0;
        
        while(vars.thread != null) {
			
			currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta >= 1) {
                if(SwitchMainPanels == true){
                    SwitchMainPanels();
                }
                if(vars.SwitchSubPanels == true){
                    SwitchSubPanels();
                }

	            	 delta--;
	            }
            if (timer >= 1000000000) {
                timer = 0;
            	}
	            
	        }
		}

///////////////////////////////////////////////////////////////////
 private void SwitchMainPanels(){

       if(vars.returnMenu == false){
            if(vars.panelMoveSelect > 0 && vars.returnMenu == false){
                vars.panelMoveSelect -= 50;
                vars.panelMoveMainMenu -= 50;
                characterselection.MainMenu.mainMenuPanel.setLocation(vars.panelMoveMainMenu,0);
                this.setLocation(vars.panelMoveSelect,0);
            }
            else{
                SwitchMainPanels = false;
                System.out.println(vars.panelMoveSelect + "damnnn");
            }
       }
       else{
            if(vars.returnMenu == true && vars.panelMoveSelect < 950){
                vars.panelMoveSelect += 50;
                vars.panelMoveMainMenu += 50;
                characterselection.MainMenu.mainMenuPanel.setLocation(vars.panelMoveMainMenu,0);
                this.setLocation(vars.panelMoveSelect,0);
            }
            else{
                vars.returnMenu = false;
                SwitchMainPanels = false;
            }
        }
   }
///////////////////////////////////////////////////////////////////
 private void SwitchSubPanels(){

    if(vars.panelMoveSubClasses > 0 && vars.backPanel == false){
        vars.panelMoveMainClasses -= 50;
        vars.panelMoveSubClasses -= 50;
        this.setLocation(vars.panelMoveMainClasses, 0);
        pnlSubClasses.setLocation(vars.panelMoveSubClasses, 0);
    }
    else if(vars.panelMoveSubClasses < 950 && vars.backPanel == true){
        vars.panelMoveMainClasses += 50;
        vars.panelMoveSubClasses += 50;
        this.setLocation(vars.panelMoveMainClasses, 0);
        pnlSubClasses.setLocation(vars.panelMoveSubClasses, 0);
    }
    else{
        vars.SwitchSubPanels = false;
    }


 }

///////////////////////////////////////////////////////////////////
@Override
 public void actionPerformed(ActionEvent e) {
            for( int i = 0; i<4; i++){
            if(e.getSource() == vars.btnMainClass[i]){
                    MakeSoundClick();
                    vars.MainClassPick = i;          
                    vars.SwitchSubPanels = true;      
                    vars.backPanel = false;
                    SwitchSubClass();             
               } 
         }

         if(e.getSource() == vars.btnBacktoMenu){
            MakeSoundClick();
            vars.returnMenu = true;
            SwitchMainPanels = true;
         }

         if(e.getSource() == vars.btnStartGame){
           main.mainFrame.dispose();
           GameFrame game = new GameFrame();
           game.showGame();
         }

         if (e.getSource() == vars.btnBacktoMainClass){
            MakeSoundClick();
            vars.SubClassPick = 0;
            vars.SwitchSubPanels = true;
            vars.backPanel = true;
         }

         for(int j = 0; j<2 ; j++){

            if(e.getSource() == vars.btnSwitchSub[j]){

                switch (j) {
                    case 0: vars.SubClassPick = 0; break;
                    case 1: vars.SubClassPick = 1; break;
                }
                SwitchSubClass();

            }  
      }
   }
///////////////////////////////////////////////////////////////////
void MakeSoundClick(){

    File file = new File("character-selection/src/res/Sounds/Retro UI Sounds/Accept/ui_accept_1.wav" );
    try {
       AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
       Clip clip = AudioSystem.getClip();
       clip.open(audioStream);
       clip.start();
   } catch (UnsupportedAudioFileException e1) {
       e1.printStackTrace();
   } catch (IOException e1) {
       e1.printStackTrace();
   } catch (LineUnavailableException e1) {
       e1.printStackTrace();
   }
}
///////////////////////////////////////////////////////////////////
   void MakeSoundHover(){
    
    File file = new File("character-selection/src/res/Sounds/Retro UI Sounds/Accept/ui_accept_4.wav" );
    try {
       AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
       Clip clip = AudioSystem.getClip();
       clip.open(audioStream);
       clip.start();
   } catch (UnsupportedAudioFileException e1) {
       e1.printStackTrace();
   } catch (IOException e1) {
       e1.printStackTrace();
   } catch (LineUnavailableException e1) {
       e1.printStackTrace();
   }
   }
///////////////////////////////////////////////////////////////////

void SwitchSubClass(){
    if(vars.MainClassPick == 0){
        if(vars.SubClassPick == 0){
            vars.subClassImg = new ImageIcon("character-selection/src/res/sprites/Rogue.gif");
            vars.img.setIcon(vars.subClassImg);
        }
        else{
            vars.subClassImg = new ImageIcon("character-selection/src/res/sprites/Hero.gif");
            vars.img.setIcon(vars.subClassImg);
        }
    }
    else if(vars.MainClassPick == 1){
        if(vars.SubClassPick == 0){
            vars.subClassImg = new ImageIcon("character-selection/src/res/sprites/HighElf.gif");
            vars.img.setIcon(vars.subClassImg);
        }
        else{
            vars.subClassImg = new ImageIcon("character-selection/src/res/sprites/DarkElf.gif");
            vars.img.setIcon(vars.subClassImg);
        }
    }
    else if(vars.MainClassPick == 2){
        if(vars.SubClassPick == 0){
            vars.subClassImg = new ImageIcon("character-selection/src/res/sprites/Youkai.gif");
            vars.img.setIcon(vars.subClassImg);
        }
        else{
            vars.subClassImg = new ImageIcon("character-selection/src/res/sprites/ArchDemon.gif");
            vars.img.setIcon(vars.subClassImg);
        }
    }
    else if(vars.MainClassPick == 3){
        if(vars.SubClassPick == 0){
            vars.subClassImg = new ImageIcon("character-selection/src/res/sprites/Warrior.gif");
            vars.img.setIcon(vars.subClassImg);
        }
        else{
            vars.subClassImg = new ImageIcon("character-selection/src/res/sprites/Weaponsmith.gif");
            vars.img.setIcon(vars.subClassImg);
        }
    }
        SetupClassDesc();
}

///////////////////////////////////////////////////////////////////
   void MainClassPanelSetup(){

    this.setSize(950,550);
    this.setLocation(950,0);
    this.setBackground(new Color(0,0,0,0));
    this.setLayout(null);

    for(int i = 0; i<4; i++){

        vars.btnMainClass[i] = new JButton();
        vars.btnMainClass[i].addActionListener(this);
        vars.btnMainClass[i].setSize(120,170);
        vars.btnMainClass[i].setLocation(vars.buttonMoveClasses,175);
        vars.btnMainClass[i].setFocusable(false);
        
        this.add(vars.btnMainClass[i]);
        vars.buttonMoveClasses += 200;
    }
    vars.btnMainClass[0].setIcon(vars.human);
    vars.btnMainClass[1].setIcon(vars.elf);
    vars.btnMainClass[2].setIcon(vars.demon);
    vars.btnMainClass[3].setIcon(vars.dwarf);

    vars.btnBacktoMenu.setBounds(10,10,20,20);
    vars.btnBacktoMenu.addActionListener(this);
    this.add(vars.btnBacktoMenu);


    // Added hover sounds damnn
    for (int i = 0; i < 4; i++) {
        vars.btnMainClass[i].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                MakeSoundHover();
             }
            });
        }
    }


///////////////////////////////////////////////////////////////////
   void SubClassesPanelSetup(){

    pnlSubClasses.setBackground(new Color(255,255,255,0));
    pnlSubClasses.setSize(950,550);
    pnlSubClasses.setLocation(950,0);
    pnlSubClasses.setLayout(null);

    vars.btnBacktoMainClass.addActionListener(this);
    vars.btnBacktoMainClass.setBounds(10,10,20,20);
    pnlSubClasses.add(vars.btnBacktoMainClass);

    for (int i = 0; i<2; i++){

        vars.pnlSmalls[i] = new JPanel(new BorderLayout());
        vars.pnlSmalls[i].setBackground(new Color(128,128,128,255));
        vars.pnlSmalls[i].setSize(150,200);
        vars.pnlSmalls[i].setLocation(vars.panelSmallsGap, 100);
        vars.panelSmallsGap +=170;

       pnlSubClasses.add(vars.pnlSmalls[i]);

       vars.btnSwitchSub[i] = new JButton();
       vars.btnSwitchSub[i].addActionListener(this);
       vars.btnSwitchSub[i].setSize(50,50);
       pnlSubClasses.add(vars.btnSwitchSub[i]);
       
    }
    vars.btnSwitchSub[0].setLocation(200,250);
    vars.btnSwitchSub[1].setLocation(685,250);

    vars.btnStartGame.setBounds(875,450, 40,40);
    vars.btnStartGame.addActionListener(this);
    pnlSubClasses.add(vars.btnStartGame);

    vars.pnlSmalls[2] = new JPanel();
    vars.pnlSmalls[2].setBackground(new Color(128,128,128,255));
    vars.pnlSmalls[2].setSize(320,150);
    vars.pnlSmalls[2].setLocation(307,320);    
    vars.pnlSmalls[2].setLayout(new FlowLayout());

    vars.pnlSmalls[1].setLayout(new FlowLayout());
    vars.pnlSmalls[0].add(vars.img, BorderLayout.CENTER);
    pnlSubClasses.add(vars.pnlSmalls[2]);
}

///////////////////////////////////////////////////////////////////
   void SetupClassDesc(){
    MiddleMan mid = new MiddleMan(vars.MainClassPick,vars.SubClassPick);

    vars.stats.setFont(new Font("Calibri",Font.BOLD, 30));
    vars.lore.setFont(new Font("Calibri",Font.BOLD, 30));
    vars.stats.setText("<html>Class Stats"+"<br>HP: "+mid.getHP() +"<br>MP: "+ mid.getMP()+"</html>");
    vars.lore.setText("<html>Class Lore:"+"<br>"+mid.getLore()+"</html>");

    vars.pnlSmalls[1].add(vars.stats);
    vars.pnlSmalls[2].add(vars.lore);

   }
}	

