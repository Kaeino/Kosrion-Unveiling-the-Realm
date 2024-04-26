package mainselection;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import characterselection.*;

public class MainSelection extends JPanel implements Runnable, ActionListener{

    MainSelectionVars vars = new MainSelectionVars();
    characterselection.MainMenu menu = new MainMenu();

    public MainSelection(){

        this.setSize(950,500);
        this.setLocation(950,0);
        this.setBackground(new Color(0,0,0,50));
        this.setLayout(null);

        for(int i = 0; i<4; i++){
            
            vars.btnMainClass[i] = new JButton();
            vars.btnMainClass[i].addActionListener(this);
            vars.btnMainClass[i].setSize(120,170);
            vars.btnMainClass[i].setLocation(vars.buttonMoveClasses,175);
            vars.btnMainClass[i].setFocusable(false);
            vars.btnMainClass[i].setIcon(vars.human);
            this.add(vars.btnMainClass[i]);
            vars.buttonMoveClasses += 200;
        }
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
            for( int i = 0; i<4; i++){
            if(e.getSource() == vars.btnMainClass[i]){
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
        }
   }
}	

