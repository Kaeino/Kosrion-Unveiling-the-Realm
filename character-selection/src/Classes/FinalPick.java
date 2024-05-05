package Classes;

interface StatMethods{

    public void setCharacterStats(int hp, int mp, String lore, int strength, int intelligence, int magicControl, int speed, int luck, int agility, int charisma, int stamina);
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

}

public class FinalPick implements StatMethods{
    
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
    
    @Override
    public void setCharacterStats(int hp, int mp, String lore, int strength, int intelligence, int magicControl, int speed, int luck, int agility, int charisma, int stamina){
        this.HP = hp;
        this.MP = mp;
        this.Lore = lore;
        this.Strength = strength;
        this.Intelligence = intelligence;
        this.MagicControl = magicControl;
        this.Speed = speed;
        this.Luck = luck;
        this.Agility = agility;
        this.Charisma = charisma;
        this.Stamina = stamina;
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

}
