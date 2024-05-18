package mainselection;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

import MainGame.Main.GameFrame;
import MainGame.Main.WriteLocation;
import characterselection.*;
import Classes.*;
public class MainSelection extends JPanel implements Runnable, ActionListener{

    public boolean SwitchMainPanels = true;
    public boolean Load = false;
    public JPanel pnlSubClasses = new JPanel();
    public JPanel pnlLoadChar = new JPanel();
    int checker;

    // Objects of Other Classess
    MainSelectionVars vars = new MainSelectionVars(); // gains access to the variables in the otherclass in the package
    characterselection.MainMenu menu = new MainMenu();// gains access to the main menu panel
    GameFrame game = new GameFrame(); // gains access to jersey code
    MainClass main = new MainClass(); // gains access to jersey code
    WriteLocation write = new WriteLocation();
    


///////////////////////////////////////////////////////////////////
// Constructer, when called sets up the mainClass and subCLass panels
    public MainSelection(){

        MainClassPanelSetup();

        SubClassesPanelSetup();

        LoadCharPanelSetup();
        
    }
    // Runs the delta timer below this method
    public void RunStart() {
		vars.thread = new Thread(this);
        //start method makes the run() method start
		vars.thread.start();
		
	}

///////////////////////////////////////////////////////////////////
// delta timer (Source: RyiSnow)
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
// moves from the mainmenu panel and the mainClass panel
 private void SwitchMainPanels(){

    // Moves the main menu and mainclass panel to the left 
       if(vars.returnMenu == false && Load == false){
            if(vars.panelMoveSelect > 0 && vars.returnMenu == false){
                vars.panelMoveSelect -= vars.panelMoveSpeed;
                vars.panelMoveMainMenu -= vars.panelMoveSpeed;
                characterselection.MainMenu.mainMenuPanel.setLocation(vars.panelMoveMainMenu,0);
                this.setLocation(vars.panelMoveSelect,0);
            }
            else{
                SwitchMainPanels = false;
            }
       }
       else if(Load == true && vars.returnMenu == false){

        if(vars.loadPanelMove < 0 && vars.returnMenu == false){
            vars.loadPanelMove += vars.panelMoveSpeed;
            vars.panelMoveMainMenu += vars.panelMoveSpeed;
            characterselection.MainMenu.mainMenuPanel.setLocation(vars.panelMoveMainMenu,0);
            pnlLoadChar.setLocation(vars.loadPanelMove,0);
        }
        else{
            SwitchMainPanels = false;
            Load = false;
        }

       }

       else if(Load == true && vars.returnMenu == true){
         if(vars.loadPanelMove > -950 && vars.returnMenu == true){
            vars.loadPanelMove -= vars.panelMoveSpeed;
            vars.panelMoveMainMenu -= vars.panelMoveSpeed;
            characterselection.MainMenu.mainMenuPanel.setLocation(vars.panelMoveMainMenu,0);
            pnlLoadChar.setLocation(vars.loadPanelMove,0);
        }
        else{
            SwitchMainPanels = false;
            Load = false;
            vars.returnMenu = false;
        }
       }

       // does the opposite of the if statement above
       else{
            if(vars.returnMenu == true && vars.panelMoveSelect < 950){
                vars.panelMoveSelect += vars.panelMoveSpeed;
                vars.panelMoveMainMenu += vars.panelMoveSpeed;
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
// this method moves the mainClass and the subClass Panels sideways which creates the transitions
 private void SwitchSubPanels(){

    // Moves the subpanels to the left
    if(vars.panelMoveSubClasses > 0 && vars.backPanel == false){
        vars.panelMoveMainClasses -= vars.panelMoveSpeed;
        vars.panelMoveSubClasses -= vars.panelMoveSpeed;
        this.setLocation(vars.panelMoveMainClasses, 0);
        pnlSubClasses.setLocation(vars.panelMoveSubClasses, 0);
    }
    // opposite of the one at the top
    else if(vars.panelMoveSubClasses < 950 && vars.backPanel == true){
        vars.panelMoveMainClasses += vars.panelMoveSpeed;
        vars.panelMoveSubClasses += vars.panelMoveSpeed;
        this.setLocation(vars.panelMoveMainClasses, 0);
        pnlSubClasses.setLocation(vars.panelMoveSubClasses, 0);
    }
    else{
        vars.SwitchSubPanels = false;
    }


 }

///////////////////////////////////////////////////////////////////
// this class is responsible for the action that happens when you click which button
@Override
 public void actionPerformed(ActionEvent e) {
            for( int i = 0; i<4; i++){
            if(e.getSource() == vars.btnMainClass[i]){
                    MakeSoundClick();
                    vars.MainClassPick = i;          
                    vars.SwitchSubPanels = true;      
                    vars.backPanel = false;
                    SetupClassStats();         
               } 
         }

         for( int i = 0; i<4; i++){
            if(e.getSource() == vars.btnLoadChar[i]){ 
                    vars.loadPick = i;
                    MakeSoundClick();

               } 
         }

         if(e.getSource() == vars.btnPlayLoadedChar){
            MakeSoundClick();
            int i = vars.loadPick;
            if(vars.loadPick == 0){
            } else if (vars.loadPick == 1){
                vars.loadPick+=1;
            }else if (vars.loadPick == 2){
                vars.loadPick+=2;
            }else if (vars.loadPick == 3){
                vars.loadPick+=3;
            }
            main.mainFrame.dispose();
            
            try {
                CountSaves();
                CharacterLoad();
                game.showGame(vars.loadArray[vars.loadPick], vars.loadArray[vars.loadPick+1], i, 2);
            } catch (IOException | LineUnavailableException e1) {
            }
            
         }

         // button that returns you to the main menu panel from the mainclass panel
         if(e.getSource() == vars.btnBacktoMenu){
            MakeSoundClick();
            vars.returnMenu = true;
            SwitchMainPanels = true;
         }
         
         // button that returns you to the main menu panel from the loadCharacter panel
         if(e.getSource() == vars.btnBacktoMenu2){
            MakeSoundClick();
            vars.returnMenu = true;
            SwitchMainPanels = true;
            Load = true;
         }

          // deletes saved character
         if(e.getSource() == vars.btnDeleteSave){
            MakeSoundClick();
            try {
                DeleteSaves(vars.loadPick);
                write.DeleteLocation(vars.loadPick);
            } catch (IOException | LineUnavailableException e1) {
                System.out.println("error");
            }
         }

         // button that starts the game 
         if(e.getSource() == vars.btnStartGame){

            try {
                CharacterCreate();
                CharacterLoad();
            } catch (IOException | LineUnavailableException e1) {
                e1.printStackTrace();
            }
           main.mainFrame.dispose();
           

           try {
            game.showGame(vars.MainClassPick, vars.SubClassPick, vars.numberOfSaves);
            CountSaves();
        } catch (IOException e1) {
        } // Passing MainClassPick and SubClassPick to jersey's Code
         
         }

         // button that returns you to the mainclass panel from the subclass panel
         if (e.getSource() == vars.btnBacktoMainClass){
            MakeSoundClick();
            vars.SubClassPick = 0;
            vars.SwitchSubPanels = true;
            vars.backPanel = true;
         }

         for(int j = 0; j<2 ; j++){
        
        // Switches subclasses 
            if(e.getSource() == vars.btnSwitchSub[j]){
                vars.SubClassPick = j;
                SetupClassStats();

            }  
      }
   }
///////////////////////////////////////////////////////////////////
// makes sound when you click buttons
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
// makes sound when you hover over SOME buttons
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
// set ups the main class panel, buttons, icons, etc
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
        vars.btnMainClass[i].setBackground(new Color(128,128,128));
        
        this.add(vars.btnMainClass[i]);
        vars.buttonMoveClasses += 200;
    }
    vars.btnMainClass[0].setIcon(vars.human);
    vars.btnMainClass[1].setIcon(vars.elf);
    vars.btnMainClass[2].setIcon(vars.demon);
    vars.btnMainClass[3].setIcon(vars.dwarf);

    vars.btnBacktoMenu.setBounds(10,10,30,30);
    vars.btnBacktoMenu.setIcon(vars.returnButton);
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
// set ups the load character panel, buttons, icons, etc
   void LoadCharPanelSetup(){
    pnlLoadChar.setSize(950,550);
    pnlLoadChar.setLocation(-950,0);
    pnlLoadChar.setBackground(new Color(0,0,0,100));
    pnlLoadChar.setLayout(null);

    vars.buttonMoveClasses = 109;
    for(int i = 0; i<4; i++){

        vars.btnLoadChar[i] = new JButton();
        vars.btnLoadChar[i].addActionListener(this);
        vars.btnLoadChar[i].setSize(120,170);
        vars.btnLoadChar[i].setLocation(vars.buttonMoveClasses,175);
        vars.btnLoadChar[i].setFocusable(false);
        
        pnlLoadChar.add(vars.btnLoadChar[i]);
        vars.buttonMoveClasses += 200;
        
    }
    vars.btnBacktoMenu2.setBounds(10,10,30,30);
    vars.btnBacktoMenu2.setIcon(vars.returnButton);
    vars.btnBacktoMenu2.addActionListener(this);

    vars.btnDeleteSave.setBounds(30, 400, 160,80);
    vars.btnDeleteSave.setBackground(Color.red);
    vars.btnDeleteSave.setIcon(vars.DeleteButton);
    vars.btnDeleteSave.addActionListener(this);

    vars.btnPlayLoadedChar.setBounds(750, 400, 160,80);
    vars.btnPlayLoadedChar.setBackground(Color.GREEN);
    vars.btnPlayLoadedChar.setIcon(vars.ContinueButton);
    vars.btnPlayLoadedChar.addActionListener(this);

    pnlLoadChar.add(vars.btnBacktoMenu2);
    pnlLoadChar.add(vars.btnDeleteSave);
    pnlLoadChar.add(vars.btnPlayLoadedChar);
    
    try {
        CharacterLoad();
    } catch (IOException e1) {
        System.out.println("BE HUMBLE");
    } catch (LineUnavailableException e1) {
        System.out.println("SIT DOWN");
    }


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
// setups the subpanel class components, smaller panels, buttons, etc
   void SubClassesPanelSetup(){

    pnlSubClasses.setBackground(new Color(255,255,255,0));
    pnlSubClasses.setSize(950,550);
    pnlSubClasses.setLocation(950,0);
    pnlSubClasses.setLayout(null);

    vars.btnBacktoMainClass.addActionListener(this);
    vars.btnBacktoMainClass.setBounds(10,10,30,30);
    vars.btnBacktoMainClass.setIcon(vars.returnButton);
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
       vars.btnSwitchSub[i].setSize(40,40);
       pnlSubClasses.add(vars.btnSwitchSub[i]);
       
    }
    vars.btnSwitchSub[0].setIcon(vars.switchSubsButtonL);
    vars.btnSwitchSub[1].setIcon(vars.switchSubsButtonR);
    vars.btnSwitchSub[0].setLocation(200,250);
    vars.btnSwitchSub[1].setLocation(685,250);

    vars.btnStartGame.setBounds(875,450, 40,40);
    vars.btnStartGame.setIcon(vars.playButton);
    vars.btnStartGame.addActionListener(this);
    pnlSubClasses.add(vars.btnStartGame);

    vars.pnlSmalls[2] = new JPanel();
    vars.pnlSmalls[2].setBackground(new Color(128,128,128,255));
    vars.pnlSmalls[2].setSize(320,150);
    vars.pnlSmalls[2].setLocation(307,320);    
    vars.pnlSmalls[2].setLayout(new BorderLayout());

    vars.pnlSmalls[1].setLayout(new BorderLayout());
    vars.pnlSmalls[0].add(vars.img, BorderLayout.CENTER);

    vars.pnlSmalls[1].add(vars.borderStats, BorderLayout.CENTER);
    vars.pnlSmalls[2].add(vars.borderLore, BorderLayout.CENTER);
    pnlSubClasses.add(vars.pnlSmalls[2]);
}

///////////////////////////////////////////////////////////////////
// Sets the stats to show in the subclass panel
  public void SetupClassStats(){
    MiddleMan mid = new MiddleMan(vars.MainClassPick,vars.SubClassPick); // gaisn access to the stats methods from Classes Package
    
    // sets the values of the character stats to be displayed in the subclasspanel;
    vars.subClassImg = mid.getImg3();
    vars.subBorderVertMain = mid.getImg4();
    vars.subBorderHorzMain = mid.getImg5();
    vars.HP = mid.getHP();
    vars.MP = mid.getMP();
    vars.Lore = mid.getLore();
    vars.Strength = mid.getStrength();
    vars.MagicControl = mid.getMagicControl();
    vars.Speed = mid.getSpeed();
    vars.Luck = mid.getLuck();
    vars.Agility = mid.getAgility();
    vars.Stamina = mid.getStamina();
    vars.Charisma = mid.getCharisma();
    vars.img.setIcon(vars.subClassImg);
    vars.borderStats.setIcon(vars.subBorderVertMain);
    vars.borderLore.setIcon(vars.subBorderHorzMain);

   }

   public void CharacterLoad() throws IOException, LineUnavailableException{

    BufferedReader loadCharacter = new BufferedReader(new FileReader("character-selection/src/res/MainGameResources/LoadClass/Saves.txt"));

    vars.counter = 0;
    vars.j = 0;
    vars.p = 0;
    while((vars.saveCount = loadCharacter.readLine()) != null){
        
        for(int x = 0; x < 2; x++){
            String[] saveFile = vars. saveCount.split(" ");
            
            vars.loadArray[vars.j] = Integer.parseInt(saveFile[x]); 
            vars.j++;
            
            }      
            LoadIcons();  
        }

    }  

    
    public void CharacterCreate() throws IOException, LineUnavailableException{

       vars.numberOfSaves = 0;
        vars.CharacterDelete.setLength(0);
        vars.CharacterSaves.setLength(0);
        File saves = new File("character-selection/src/res/MainGameResources/LoadClass/Saves.txt");
        Scanner sc = new Scanner(saves);

        while(sc.hasNextLine()){
           vars.numberOfSaves++;
        vars.CharacterSaves = vars.CharacterSaves.append(sc.nextLine()+"\n");
            }
            CheckCharacterLimits(vars.numberOfSaves);


            BufferedWriter SaveCharacter = new BufferedWriter(new FileWriter("character-selection/src/res/MainGameResources/LoadClass/Saves.txt"));
            SaveCharacter.write(vars.CharacterSaves.toString()+vars.MainClassPick+" "+vars.SubClassPick);
            SaveCharacter.close();
            vars.IconCount+= 1;
        }  

    public void DeleteSaves(int deleteChar) throws IOException, LineUnavailableException{

        int c = 0;
        vars.deleteCounter = 0;
        vars.CharacterDelete.setLength(0);

        if(deleteChar == 0){
        } else if (deleteChar == 1){
            deleteChar+=1;
        }else if (deleteChar == 2){
            deleteChar+=2;
        }else if (deleteChar == 3){
            deleteChar+=3;
        }
        
        File saves = new File("character-selection/src/res/MainGameResources/LoadClass/Saves.txt");
        Scanner sc = new Scanner(saves);

        while(sc.hasNextLine()){
        vars.CharacterSaves = vars.CharacterSaves.append(sc.nextLine()+"\n");
        vars.deleteCounter++;
        }
        
        vars.IconCount = vars.deleteCounter - 1;

        for(int i = deleteChar; i < vars.deleteCounter+2; i ++){
            vars.loadArray[i] =  vars.loadArray[i+2];
        }

        for (int j = 0; j < vars.deleteCounter-1; j++){
            vars.CharacterDelete = vars.CharacterDelete.append(vars.loadArray[j+c].toString()+" "+ vars.loadArray[j+1+c].toString()+"\n");
            c++;
        }
                 BufferedWriter SaveCharacter = new BufferedWriter(new FileWriter("character-selection/src/res/MainGameResources/LoadClass/Saves.txt"));
                   SaveCharacter.write(vars.CharacterDelete.toString());
                   SaveCharacter.close();

                   vars.p = 0;
                   vars.counter = 0;
                   for (int p = 0; p < vars.deleteCounter-1; p++){
                    
                    LoadIcons();
                    vars.btnLoadChar[vars.IconCount].setIcon(null);
                    }
                    if(vars.IconCount == 0){
                        vars.btnLoadChar[0].setIcon(null);
                    }
                    vars.IconCount-= 1;
                    CountSaves();              
    }  

    public void CountSaves() throws FileNotFoundException{
        
        vars.checkcounts = 0;

        File saves = new File("character-selection/src/res/MainGameResources/LoadClass/Saves.txt");
        Scanner sc = new Scanner(saves);
        
        while(sc.hasNextLine()){
           vars.checkcounts++;
        vars.CharacterSaves = vars.CharacterSaves.append(sc.nextLine()+"\n");
            }
            System.out.println(vars.checkcounts);
            CheckCharacterLimits(vars.checkcounts);
    }

    public void LoadIcons(){
        MiddleMan mid = new MiddleMan(vars.loadArray[vars.p], vars.loadArray[vars.p+1]);
        vars.btnLoadChar[vars.counter].setIcon(mid.getImg3());
        vars.p+=2;
        vars.counter++;
        System.out.println(vars.counter + "WAAAAAAAAAAAAAAY");
    }

    public void CheckCharacterLimits(int a){

        System.out.println(a);
        for(int i = a; i < vars.btnLoadChar.length; i++){
            vars.btnLoadChar[i].setVisible(false);
        }

        for(int j = 0; j<a; j++){
            if(j < 4){
            vars.btnLoadChar[j].setVisible(true);
          }
        }

        if(a == 0){
            vars.btnDeleteSave.setVisible(false);
            vars.btnPlayLoadedChar.setVisible(false);
        }
        else{
            vars.btnDeleteSave.setVisible(true);
            vars.btnPlayLoadedChar.setVisible(true);
        }

        if(a == 4){
            vars.btnStartGame.setVisible(false);
        }
        else{
            vars.btnStartGame.setVisible(true);
        }
    }
}	

