package mainselection;

import java.awt.*;
import javax.swing.*;
public class MainSelectionVars {
    
public JButton[] btnMainClass = new JButton[4];

public JPanel[] pnlSmalls = new JPanel[3];

ImageIcon human = new ImageIcon("character-selection/src/res/sprites/Human.gif");
ImageIcon elf = new ImageIcon("character-selection/src/res/sprites/Elf.gif");
ImageIcon demon = new ImageIcon("character-selection/src/res/sprites/Demon.gif");
ImageIcon dwarf = new ImageIcon("character-selection/src/res/sprites/Dwarf.gif");

public Thread thread;

public boolean SwitchMainPanels = true;
public boolean SwitchSubPanels;

public int buttonMoveClasses = 109;
public int panelMoveSelect = 950;
public int panelMoveMainMenu = 0;
public int panelMoveMainClasses = 0;
public int panelMoveSubClasses = 950;
public int panelSmallsGap = 307;


}
