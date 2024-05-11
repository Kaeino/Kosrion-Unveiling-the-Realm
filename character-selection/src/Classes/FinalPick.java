package Classes;

import javax.swing.ImageIcon;

// Interface for Stat Methods
interface StatMethods{

    public int getHP();
    public int getMP();
    public String getLore();
    public int getStrength();
    public int getIntelligence();
    public int getMagicControl();
    public int getSpeed();
    public int getLuck();
    public int getAgility();
    public int getCharisma();
    public int getStamina();
    public ImageIcon getImg();
    public String getName();
    public ImageIcon getImg2();

}

//Abstract Class which is extended by the MiddleMan Class and implements the interface above
public abstract class FinalPick implements StatMethods{
    //Character Stats
    private int HP;
    private int MP;
    private String Lore;
    private int Strength;
    private int Intelligence;
    private int MagicControl;
    private int Speed;
    private int Luck;
    private int Agility;
    private int Charisma;
    private int Stamina;
    private ImageIcon subClassImg;
    private ImageIcon subClassImg2;
    private String Name;
    
    public void setCharacterStatsInt(int hp, int mp, int strength, int intelligence, int magicControl, int speed, int luck, int agility, int charisma, int stamina){
        this.HP = hp;
        this.MP = mp;
        this.Strength = strength;
        this.Intelligence = intelligence;
        this.MagicControl = magicControl;
        this.Speed = speed;
        this.Luck = luck;
        this.Agility = agility;
        this.Charisma = charisma;
        this.Stamina = stamina;
        }

    public void setCharacterStatsStr(String lore, String name){
        this.Lore = lore;
        this.Name = name;
    }

    public void setCharacterStatsImg(ImageIcon subclassimg, ImageIcon subclassimg2){
        this.subClassImg = subclassimg;
        this.subClassImg2 = subclassimg2;
    }

    @Override
    public int getHP(){
        return HP;
    }
    @Override
    public int getMP(){
        return MP;
    }
    @Override
    public String getLore(){
        return Lore;
    }
    @Override
    public int getStrength(){
        return Strength;
    }
    @Override
    public int getIntelligence(){
        return Intelligence;
    }
    @Override
    public int getMagicControl(){
        return MagicControl;
    }
    @Override
    public int getSpeed(){
        return Speed;
    }
    @Override
    public int getLuck(){
        return Luck;
    }
    @Override
    public int getAgility(){
        return Agility;
    }
    @Override
    public int getCharisma(){
        return Charisma;
    }
    @Override
    public int getStamina(){
        return Stamina;
    }
    @Override
    public ImageIcon getImg(){
        return subClassImg;
    }
    @Override
    public ImageIcon getImg2(){
        return subClassImg2;
    }
    @Override
    public String getName(){
        return Name;
    }
}
