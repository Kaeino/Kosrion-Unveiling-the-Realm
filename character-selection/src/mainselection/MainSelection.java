package mainselection;

import javax.swing.*;
import java.awt.*;

public class MainSelection {

    public static void show(JFrame mainFrame) {
        // Create a panel for MainSelection screen
        JPanel mainSelectionPanel = new JPanel(new BorderLayout());
        mainSelectionPanel.setBackground(Color.WHITE); // Set background color

        
        // Eto mini shits
        
        mainFrame.getContentPane().removeAll(); // Clearing yung main frame contents, para malinis

        mainFrame.getContentPane().add(mainSelectionPanel); // Inaadd nmn nito yung main selection panel sa main frame

        mainFrame.revalidate();  // Damn revalidate means inaupdate nya lang yung layout ng frame

        mainFrame.repaint();  // Eto nmn nirerefresh nya lang yung main frame para gudshit na sya
    }
}
