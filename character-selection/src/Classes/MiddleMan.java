package Classes;

import java.awt.Image;

import javax.management.loading.PrivateClassLoader;
import javax.swing.ImageIcon;

public class MiddleMan extends FinalPick {
    private int HP; // IDK what other stats are
    private int MP;
    private int Strength;
    private int Intelligence;
    private int MagicControl;
    private int Speed;
    private int Luck;
    private int Agility;
    private int Charisma;
    private int Stamina;
    private String Lore;
    private int subClass;
    private ImageIcon subClassImg;
    private ImageIcon subClassImg2;
    private String Name;

   public MiddleMan(int mainclass, int subclass){

        this.subClass = subclass;


    switch (mainclass) {
            case 0:
            switch (subClass) {
                case 1:
                    Name = "Hero";
                    subClassImg = new ImageIcon("character-selection/src/res/sprites/Hero.gif");
                    subClassImg2 = new ImageIcon("character-selection/src/res/sprites/Hero2.gif");
                    HP = 1500;
                    MP = 800;
                    Strength = 1800;
                    Intelligence = 2500;
                    MagicControl = 3800;
                    Speed = 2000;
                    Luck = 3000;
                    Agility = 2800;
                    Charisma = 4000;
                    Stamina = 3000;
                    Lore = "DAMN HE HERO";
    
                    break;
                case 0: 
                    Name = "Rouge";
                    subClassImg = new ImageIcon("character-selection/src/res/sprites/Rogue.gif");
                    subClassImg2 = new ImageIcon("character-selection/src/res/sprites/Rogue2.gif");
                    HP = 1300;
                    MP = 800;
                    Strength = 1200;
                    Intelligence = 3000;
                    MagicControl = 2000;
                    Speed = 4000;
                    Luck = 2000;
                    Agility = 4000;
                    Charisma = 2000;
                    Stamina = 3000;
                    Lore = "DAMN HE ROUGE";
    
                    break;
            }
            break;     
            case 1:
            switch (subClass) {
                case 0:
                    Name = "High Guy";
                    subClassImg = new ImageIcon("character-selection/src/res/sprites/HighElf.gif");
                    subClassImg2 = new ImageIcon("character-selection/src/res/sprites/HighElf2.gif");
                    HP = 1000;
                    MP = 1500;
                    Strength = 500;
                    Intelligence = 4000;
                    MagicControl = 3500;
                    Speed = 500;
                    Luck = 1800;
                    Agility = 500;
                    Charisma = 1000;
                    Stamina = 500;
                    Lore = "DAMN HE HIGH ELF";
    
                    break;
                case 1: 
                    Name = "Black Guy";
                    subClassImg = new ImageIcon("character-selection/src/res/sprites/DarkElf.gif");
                    subClassImg2 = new ImageIcon("character-selection/src/res/sprites/DarkElf2.gif");
                    HP = 1200;
                    MP = 1300;
                    Strength = 800;
                    Intelligence = 2500;
                    MagicControl = 2800;
                    Speed = 1000;
                    Luck = 1800;
                    Agility = 1800;
                    Charisma = 500;
                    Stamina = 1000;
                    Lore = "DAMN HE DARK ELF";
    
                    break;
            }
            break;  
            case 2:
            switch (subClass) {
                case 0:
                    Name = "Youkai Watch";
                    subClassImg = new ImageIcon("character-selection/src/res/sprites/Youkai.gif");
                    subClassImg2 = new ImageIcon("character-selection/src/res/sprites/Youkai2.gif");
                    HP = 2000;
                    MP = 1100;
                    Strength = 500;
                    Intelligence = 4000;
                    MagicControl = 3500;
                    Speed = 1500;
                    Luck = 2800;
                    Agility = 1500;
                    Charisma = 0;
                    Stamina = 4000;
                    Lore = "DAMN HE YOUKAI";
    
                    break;
                case 1: 
                    Name = "Death Scythe";
                    subClassImg = new ImageIcon("character-selection/src/res/sprites/ArchDemon.gif");
                    subClassImg2 = new ImageIcon("character-selection/src/res/sprites/ArchDemon2.gif");
                    HP = 2500;
                    MP = 1000;
                    Strength = 2000;
                    Intelligence = 1800;
                    MagicControl = 2800;
                    Speed = 2000;
                    Luck = 2000;
                    Agility = 1800;
                    Charisma = 0;
                    Stamina = 2000;
                    Lore = "DAMN HE ARCH DEMON";
    
                    break;
            }
    
            break;  
            case 3:
            switch (subClass) {
                case 0:
                    Name = "War Guy";
                    subClassImg = new ImageIcon("character-selection/src/res/sprites/Warrior.gif");
                    subClassImg2 = new ImageIcon("character-selection/src/res/sprites/Warrior2.gif");
                    HP = 4000;
                    MP = 0  ;
                    Strength = 4000;
                    Intelligence = 1000;
                    MagicControl = 0;
                    Speed = 2000;
                    Luck = 1000;
                    Agility = 3000;
                    Charisma = 1000;
                    Stamina = 4000;
                    Lore = "DAMN HE WARRIOR";
    
                    break;
                case 1: 
                    Name = "Hephaestus";
                    subClassImg = new ImageIcon("character-selection/src/res/sprites/Weaponsmith.gif");
                    subClassImg2 = new ImageIcon("character-selection/src/res/sprites/Weaponsmith2.gif");
                    HP = 3000;
                    MP = 1000;
                    Strength = 1800;
                    Intelligence = 2800;
                    MagicControl = 4000;
                    Speed = 500;
                    Luck = 3000;
                    Agility = 500;
                    Charisma = 0;
                    Stamina = 3000;
                    Lore = "DAMN HE WEAPON<br>SMITH";
    
                    break;
            }
            break;    
        }

        super.setCharacterStatsInt(HP, MP, Strength, Intelligence, MagicControl, Speed, Luck, Agility, Charisma, Stamina);
        super.setCharacterStatsStr(Lore, Name);
        super.setCharacterStatsImg(subClassImg, subClassImg2);

    }

}
