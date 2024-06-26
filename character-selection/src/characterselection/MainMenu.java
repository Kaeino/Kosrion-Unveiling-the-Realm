package characterselection;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

import mainselection.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainMenu {

    public static JPanel mainMenuPanel;
    public static MainSelection select = new MainSelection();
    static ImageIcon titleIcon = new ImageIcon("character-selection/src/res/buttons/Title.png");
    static JLabel title = new JLabel(titleIcon);

    // Damnn eto yung method para mapakita yung main menu namay background image, which is yung lone hero, maintframe + imagepath = main menu with image damnn
    public static void show(JFrame mainFrame, String backgroundImagePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        
        

        // Damnn, eto nmn hinohold nya lang main menu BG, parang object shit
        JPanel mainMenuBg = new JPanel(new BorderLayout());
    
        // Damnn, eto nmn hinohold nya lang main menu components, parang object shit
        mainMenuPanel = new JPanel(new BorderLayout());

        // Damnn, eto is para transparent ung mainMenuPanel
        mainMenuPanel.setBackground(new Color(0,0,0,0));

        // Damnn, eto is para macover nung mainMenuPanel ung buong screen
        mainMenuPanel.setLocation(0,0);
        mainMenuPanel.setSize(950,500);

        // damnn adding it sa taas ng mainmenubg plus other panels from mainselection(Psalm's package)
        mainMenuBg.add(mainMenuPanel);
        mainMenuBg.add(select);    
        mainMenuBg.add(select.pnlSubClasses);
        mainMenuBg.add(select.pnlLoadChar);

        // Damn eto nmn label pang display ng Background Image
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Damnn eto nmn niloload nya yung background image sa path na ginamit ko
        ImageIcon backgroundImage = new ImageIcon(backgroundImagePath);

        // Damn eto sineset nya lang yung bg image sa bg label
        backgroundLabel.setIcon(backgroundImage);

        // After nmn background label aadd nya nmn sa center ng mainmenu panel yung bg label, para gumitna lang
        mainMenuBg.add(backgroundLabel, BorderLayout.CENTER);

        // Create a panel for buttons
       // JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40,1));
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40,1));
        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.add(title, BorderLayout.NORTH);

        // code for create a new character button lang
        ImageIcon createCharacterIcon = new ImageIcon("character-selection/src/res/buttons/new.png");
        JButton createCharacterButton = new JButton(createCharacterIcon);
        createCharacterButton.setFocusable(false);
        createCharacterButton.setPreferredSize(new Dimension(130, 47));
        createCharacterButton.setContentAreaFilled(false); // Set button background to be transparent damn trash
        createCharacterButton.setBorderPainted(false); // Remove button border
        createCharacterButton.setOpaque(false); // Set button background to be transparent hayss
        createCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // button is clicked? then will go open the MainSelection.java file (IMMA CONTINUE THIS NYAN) DAMNN -P   
            MakeSound();
             select.RunStart();
             select.SwitchMainPanels = true;

             try {
                select.CountSaves();
            } catch (FileNotFoundException e1) {
            }
             
            }
        });
        
        ImageIcon loadIcon = new ImageIcon("character-selection/src/res/buttons/load.png");
        JButton loadButton = new JButton(loadIcon);
        loadButton.setFocusable(false);
        loadButton.setPreferredSize(new Dimension(130, 47));
        loadButton.setContentAreaFilled(false); // 
        loadButton.setBorderPainted(false); // just removing the border, useless
        loadButton.setOpaque(false); // Set button background to be transparent daw tae
        loadButton.addActionListener(new ActionListener() {
            @Override
         public void actionPerformed(ActionEvent e) {
             // this exits the program nmn if clicked
             MakeSound();
             select.RunStart();
             select.SwitchMainPanels = true;
             select.Load = true;

             try {
                select.CountSaves();
            } catch (FileNotFoundException e1) {
            }
            }
        });

        buttonPanel.add(loadButton);

        // whole code for exit button lang
        ImageIcon quitIcon = new ImageIcon("character-selection/src/res/buttons/x.png");
        JButton quitButton = new JButton(quitIcon);
        quitButton.setFocusable(false);
        quitButton.setPreferredSize(new Dimension(130, 47));
        quitButton.setContentAreaFilled(false); // 
        quitButton.setBorderPainted(false); // just removing the border, useless
        quitButton.setOpaque(false); // Set button background to be transparent daw tae
        quitButton.addActionListener(new ActionListener() {
            @Override
         public void actionPerformed(ActionEvent e) {
             // this exits the program nmn if clicked
             MakeSound();
              System.exit(0);
            }
        });
        
      
         // Add the load character button to the button panel
        buttonPanel.add(loadButton);
        
         // Add the quit button to the button panel
         buttonPanel.add(quitButton);

           // Add the create character button to the button panel
        buttonPanel.add(createCharacterButton);

        buttonPanel.setBackground(new Color(0,0,0,0));
        titlePanel.setBackground(new Color(0,0,0,0));

        // Add the button panel to the main menu panel

        mainMenuPanel.add(titlePanel, BorderLayout.NORTH);
        mainMenuPanel.add(buttonPanel, BorderLayout.CENTER);
       

        // Eto mini shits

        // Clearing yung main frame contents, para malinis
        mainFrame.getContentPane().removeAll();

        // Inaadd nmn nito yung main menu panel sa main frame
        mainFrame.getContentPane().add(mainMenuBg);

        // Damn revalidate means inaupdate nya lang yung layout ng frame
        mainFrame.revalidate();

        // Eto nmn nirerefresh nya lang yung main frame para gudshit na sya
        mainFrame.repaint();


    }

    public static void MakeSound(){
        File file = new File("character-selection/src/res/Sounds/Retro UI Sounds/Accept/ui_accept_6.wav" );
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

}
