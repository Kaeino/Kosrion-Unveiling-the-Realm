package Classes;

interface StatMethods{

    public void setCharacterStats(int hp, int mp, String lore);
    public int getHP();
    public int getMP();
    public String getLore();
}

public class FinalPick implements StatMethods{
    
    private int HP;
    private int MP;
    private String Lore;
    
    @Override
    public void setCharacterStats(int hp, int mp, String lore){
        this.HP = hp;
        this.MP = mp;
        this.Lore = lore;
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
}
