package MainGame.Main;

import java.io.*;
import java.util.Scanner;

import MainGame.Entity.Player;

public class WriteLocation {
    
    int loadX;
    int loadY;
    public StringBuilder CharacterLoc = new StringBuilder();
    File[]saveLoc = new File[4];
    FileWriter[] SaveLoc = new FileWriter[4];
    String[] saveText = new String[4];
    BufferedReader[] Saveloc = new BufferedReader[4];


    public void SaveLocation(int x, int y, int loadpick) throws IOException{
        readLines();

        for(int i =0; i<4; i ++){
            saveText[i] = Saveloc[i].readLine();    
        }

        SaveLoc[0] = new FileWriter("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation1.txt");
        SaveLoc[1] = new FileWriter("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation2.txt");
        SaveLoc[2] = new FileWriter("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation3.txt");
        SaveLoc[3] = new FileWriter("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation4.txt");
        
        for(int i = 0; i < 4; i ++){
            if(i == loadpick){
            }else{
                    SaveLoc[i].write(saveText[i]); 
                    SaveLoc[i].close();
            }
        }

       // System.out.println(x +" " + y);
        SaveLoc[loadpick].write(x+" "+y);
        SaveLoc[loadpick].close();

    }

    public void DeleteLocation(int loadPick) throws IOException{

        readLines();

        for(int i = 0; i<4; i ++){
            saveText[i] = Saveloc[i].readLine();    
        }

        SaveLoc[0] = new FileWriter("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation1.txt");
        SaveLoc[1] = new FileWriter("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation2.txt");
        SaveLoc[2] = new FileWriter("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation3.txt");
        SaveLoc[3] = new FileWriter("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation4.txt");

        for(int i = 0; i<4; i ++){
            if(i >= loadPick && i != 3){
                SaveLoc[i].write(saveText[i+1]);     
                SaveLoc[i].close();
             } else if(i == 3){
                SaveLoc[3].write(saveText[3]);     
                SaveLoc[3].close();
            }
            else{
                SaveLoc[i].write(saveText[i]);     
                SaveLoc[i].close();
            }
            
        }
                
    }

    public void LoadLocation(int loadPick) throws IOException{
        readLines();

        String loc;
      
        loc = Saveloc[loadPick].readLine();

        System.out.println(loc);

        String[] characterLocation = loc.split(" ");

        loadX = Integer.parseInt(characterLocation[0]);
        loadY = Integer.parseInt(characterLocation[1]);
        
    }

    public int LoadX(){

        return loadX;

    }

    
    public int LoadY(){

        return loadY;

    }

    public void readLines() throws FileNotFoundException{
        saveLoc[0] = new File("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation1.txt");
        saveLoc[1] = new File("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation2.txt");
        saveLoc[2] = new File("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation3.txt");
        saveLoc[3] = new File("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation4.txt");

        Saveloc[0] = new BufferedReader(new FileReader("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation1.txt"));
        Saveloc[1] = new BufferedReader(new FileReader("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation2.txt"));
        Saveloc[2] = new BufferedReader(new FileReader("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation3.txt"));
        Saveloc[3] = new BufferedReader(new FileReader("character-selection/src/res/MainGameResources/LoadClass/SavesWorldLocation4.txt"));


    }


}
