package Classes;

public class MiddleMan extends FinalPick {
    private int HP; // IDK what other stats are
    private int MP;
    private String Lore;
    private int subClass;

   public MiddleMan(int mainclass, int subclass){

        this.subClass = subclass;


    switch (mainclass) {
            case 0:
            switch (subClass) {
                case 1:
    
                    HP = 1500;
                    MP = 800;
                    Lore = "DAMN HE HERO";
    
                    break;
                case 0: 
    
                    HP = 1300;
                    MP = 800;
                    Lore = "DAMN HE ROUGE";
    
                    break;
            }
            break;     
            case 1:
            switch (subClass) {
                case 0:
    
                    HP = 1000;
                    MP = 1500;
                    Lore = "DAMN HE HIGH ELF";
    
                    break;
                case 1: 
    
                    HP = 1200;
                    MP = 1300;
                    Lore = "DAMN HE DARK ELF";
    
                    break;
            }
            break;  
            case 2:
            switch (subClass) {
                case 0:
    
                    HP = 2000;
                    MP = 1100;
                    Lore = "DAMN HE YOUKAI";
    
                    break;
                case 1: 
    
                    HP = 2500;
                    MP = 1000;
                    Lore = "DAMN HE ARCH DEMON";
    
                    break;
            }
    
            break;  
            case 3:
            switch (subClass) {
                case 0:
    
                    HP = 4000;
                    MP = 300;
                    Lore = "DAMN HE WARRIOR";
    
                    break;
                case 1: 
    
                    HP = 3000;
                    MP = 500;
                    Lore = "DAMN HE WEAPON<br>SMITH";
    
                    break;
            }
            break;    
        }

        super.CharacterStats(HP, MP, Lore);

    }

}
