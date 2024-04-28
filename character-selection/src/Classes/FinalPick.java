package Classes;

public class FinalPick {
    
    private int HP;
    private int MP;
    private String Lore;

    public void CharacterStats(int hp, int mp, String lore){
        this.HP = hp;
        this.MP = mp;
        this.Lore = lore;
        }

    public int getHP(){
        return HP;

    }
    public int getMP(){
        return MP;
    }
    public String getLore(){
        return Lore;
    }
}
