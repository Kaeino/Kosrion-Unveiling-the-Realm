package mainselection;

import java.awt.*;

//import java.awt.*;
import javax.swing.*;
 class MainSelectionVars {
    
 JButton[] btnMainClass = new JButton[4];
 JButton[] btnLoadChar = new JButton[4];
 JButton[] btnSwitchSub = new JButton[2];
 JPanel[] pnlSmalls = new JPanel[3];
 JButton btnDeleteSave = new JButton();
 JButton btnPlayLoadedChar = new JButton();
 JButton btnBacktoMainClass = new JButton();
 JButton btnBacktoMenu = new JButton();
 JButton btnBacktoMenu2 = new JButton();
 JButton btnStartGame = new JButton();
 JLabel stats = new JLabel();
 JLabel lore = new JLabel();

ImageIcon human = new ImageIcon("character-selection/src/res/sprites/Human.gif");
ImageIcon elf = new ImageIcon("character-selection/src/res/sprites/Elf.gif");
ImageIcon demon = new ImageIcon("character-selection/src/res/sprites/Demon.gif");
ImageIcon dwarf = new ImageIcon("character-selection/src/res/sprites/Dwarf.gif");

ImageIcon subBorderVertMain = new ImageIcon("character-selection/src/res/buttons/StatBorder.png");
ImageIcon subBorderHorzMain = new ImageIcon("character-selection/src/res/buttons/LoreBorder.png");

ImageIcon subClassImg;
JLabel img = new JLabel(subClassImg);

ImageIcon subBorderVert;
ImageIcon subBorderHorz;

ImageIcon returnButton = new ImageIcon("character-selection/src/res/buttons/back-button.png");
ImageIcon switchSubsButtonL = new ImageIcon("character-selection/src/res/buttons/preview-left.png");
ImageIcon switchSubsButtonR = new ImageIcon("character-selection/src/res/buttons/preview-right.png");
ImageIcon playButton = new ImageIcon("character-selection/src/res/buttons/play-button.png");
ImageIcon ContinueButton = new ImageIcon("character-selection/src/res/buttons/continue.png");
ImageIcon DeleteButton = new ImageIcon("character-selection/src/res/buttons/delete.png");

JLabel borderStats = new JLabel(subBorderVertMain);
JLabel borderLore = new JLabel(subBorderHorzMain);

 Thread thread;

 // boolean for checking
 boolean SwitchSubPanels;
 boolean backPanel;
 boolean returnMenu;

 // int variables 
 int buttonMoveClasses = 109;
 int panelMoveSelect = 950;
 int panelMoveMainMenu = 0;
 int panelMoveMainClasses = 0;
 int panelMoveSubClasses = 950;
 int panelSmallsGap = 307;
 int panelMoveSpeed = 50;
 int loadPanelMove = -950;
 int MainClassPick;
 int SubClassPick;
 int numberOfSaves;

    // CharacterStats
     int HP;
     int MP;
     String Lore;
     int Strength;
     int Intelligence;
     int MagicControl;
     int Speed;
     int Luck;
     int Agility;
     int Charisma;
     int Stamina;

     int j;
     int p;
     String saveCount;
     int checkcounts;
     
     Integer[] loadArray = new Integer[8];
     ImageIcon loadIcon;
     int counter = 0;
     int deleteCounter;
     int loadPick;
     int IconCount = 3;

     StringBuilder CharacterSaves = new StringBuilder();
     StringBuilder CharacterDelete = new StringBuilder();
 
 }
