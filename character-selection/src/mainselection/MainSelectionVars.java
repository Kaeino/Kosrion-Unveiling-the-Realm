package mainselection;

import java.awt.*;
import javax.swing.*;
 class MainSelectionVars {
    
 JButton[] btnMainClass = new JButton[4];
 JButton[] btnSwitchSub = new JButton[2];
 JPanel[] pnlSmalls = new JPanel[3];

ImageIcon human = new ImageIcon("character-selection/src/res/sprites/Human.gif");
ImageIcon elf = new ImageIcon("character-selection/src/res/sprites/Elf.gif");
ImageIcon demon = new ImageIcon("character-selection/src/res/sprites/Demon.gif");
ImageIcon dwarf = new ImageIcon("character-selection/src/res/sprites/Dwarf.gif");
ImageIcon subClassImg;
JLabel img = new JLabel(subClassImg);

 Thread thread;

 boolean SwitchMainPanels = true;
 boolean SwitchSubPanels;

 int buttonMoveClasses = 109;
 int panelMoveSelect = 950;
 int panelMoveMainMenu = 0;
 int panelMoveMainClasses = 0;
 int panelMoveSubClasses = 950;
 int panelSmallsGap = 307;
 int MainClassPick;
 int SubClassPick;


}
