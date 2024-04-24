package characterselection;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MainMenu {

    // damnn eto yung method para mapakita yung main menu namay background image, which is yung lone hero, maintframe + imagepath = main menu with image damnn
    public static void show(JFrame mainFrame, String backgroundImagePath) {

        // damnn, eto nmn hinohold nya lang main menu components, parang object shit
        JPanel mainMenuPanel = new JPanel(new BorderLayout());

        // damn eto nmn label pang display ng Background Image
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //damnn eto nmn niloload nya yung background image sa path na ginamit ko
        ImageIcon backgroundImage = new ImageIcon(backgroundImagePath);
       
        //damn eto sineset nya lang yung bg image sa bg label
        backgroundLabel.setIcon(backgroundImage);

        //after nmn background label aadd nya nmn sa center ng mainmenu panel yung bg label, para gumitna lang
        mainMenuPanel.add(backgroundLabel, BorderLayout.CENTER);


        // eto mini shits

        //clearing yung main frame contents, para malinis
        mainFrame.getContentPane().removeAll();

        //Inaadd nmn nito yung main menu panel sa main frame
        mainFrame.getContentPane().add(mainMenuPanel);

        //damn revalidate means inaupdate nya lang  yung layout ng frame
        mainFrame.revalidate();

        //eto nmn nirerefresh nya lang yung main frame para gudshit na sya
        mainFrame.repaint();

    }
    
}
