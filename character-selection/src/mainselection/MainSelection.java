package mainselection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import characterselection.*;

public class MainSelection extends JPanel implements Runnable, ActionListener{

    MainSelectionVars vars = new MainSelectionVars();
    characterselection.MainMenu menu = new MainMenu();

    public MainSelection(){

        this.setSize(950,500);
        this.setLocation(950,0);
        this.setBackground(new Color(0,0,0,30));

    }

    public void RunStart() {
		vars.thread = new Thread(this);
		vars.thread.start();
		
	}

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
                if(vars.Switch == true){
                    System.out.println("DAMN");
                    SwitchPanels();
                }

	            	 delta--;
	            }
            if (timer >= 1000000000) {
                timer = 0;
            	}
	            
	        }
		}

       private void SwitchPanels(){
        vars.panelMoveSelect -= 50;
        vars.panelMoveMainMenu -= 50;
       
            if(vars.panelMoveSelect >= 0){
         
                characterselection.MainMenu.mainMenuPanel.setLocation(vars.panelMoveMainMenu,0);
                this.setLocation(vars.panelMoveSelect,0);

            }
            else{
                vars.Switch = false;
                System.out.println(vars.panelMoveSelect);
            }

        }

        @Override
        public void actionPerformed(ActionEvent e) {
           
        }
	
}
