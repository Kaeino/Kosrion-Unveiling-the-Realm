package characterselection;

import javax.swing.*;

import mainselection.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {

    // Damnn eto yung method para mapakita yung main menu namay background image, which is yung lone hero, maintframe + imagepath = main menu with image damnn
    public static void show(JFrame mainFrame, String backgroundImagePath) {

        // Damnn, eto nmn hinohold nya lang main menu BG, parang object shit
        JPanel mainMenuBg = new JPanel(new BorderLayout());

        // Damnn, eto nmn hinohold nya lang main menu components, parang object shit
        JPanel mainMenuPanel = new JPanel(new BorderLayout());

        // Damnn, eto is para transparent ung mainMenuPanel
        mainMenuPanel.setBackground(new Color(0,0,0,0));

        // Damnn, eto is para macover nung mainMenuPanel ung buong screen
        mainMenuPanel.setBounds(0,0,950,500);

        // damnn adding it sa taas ng mainmenubg
        mainMenuBg.add(mainMenuPanel);

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
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));

        // code for create a new character button lang
        ImageIcon createCharacterIcon = new ImageIcon("character-selection/src/res/game-background/quit-button_dummy.png");
        JButton createCharacterButton = new JButton(createCharacterIcon);
        createCharacterButton.setFocusable(false);
        createCharacterButton.setPreferredSize(new Dimension(130, 47));
        createCharacterButton.setContentAreaFilled(false); // Set button background to be transparent damn trash
        createCharacterButton.setBorderPainted(false); // Remove button border
        createCharacterButton.setOpaque(false); // Set button background to be transparent hayss
        createCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // button is clicked? then will go open the MainSelection.java file (IMMA CONTINUE THIS NYAN) -P
            
            mainselection.MainSelection select = new MainSelection();
             mainMenuPanel.add(select);             
             select.RunStart();
             
            }
        });


        // Add the create character button to the button panel
        buttonPanel.add(createCharacterButton);
        

        // whole code for exit button lang
        ImageIcon quitIcon = new ImageIcon("character-selection/src/res/game-background/quit-button_dummy.png");
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
              System.exit(0);
            }
        });
        

        // Add the quit button to the button panel
        buttonPanel.add(quitButton);

        buttonPanel.setBackground(new Color(0,0,0,0));

        // Add the button panel to the main menu panel

        mainMenuPanel.add(buttonPanel, BorderLayout.SOUTH);
       

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

    public void RunStart(){

    }

}
