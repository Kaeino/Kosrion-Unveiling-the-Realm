package MainGame.Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener
{
    GamePanel gp;
    public  boolean upPressed, downPressed, leftPressed, rightPressed;

    public KeyHandler(GamePanel gp)
    {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        CharacterControls(code);
        PauseGamme(code);
        CharacterStats(code);

        BasicAttack(code);
        BasicAttack(code);
        SaySomething(code);
        TutorialState(code);
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W)
        {
            upPressed = false;
        }
        if(code == KeyEvent.VK_S)
        {
            downPressed = false;
        }
        if(code == KeyEvent.VK_A)
        {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D)
        {
            rightPressed = false;
        }
        if(code == KeyEvent.VK_Q)
        {
           gp.test = false;
        }
    }

    private  void TutorialState(int code)
    {
        if(code == KeyEvent.VK_ENTER)
        {
            if(gp.gameState == gp.playState)
            {
                gp.gameState = gp.tutorialState;
                System.out.println("SHOWED CONTROLS");
            }
            else if(gp.gameState == gp.tutorialState)
            {
                gp.gameState = gp.playState;
                System.out.println("GAME CONTINUED");
            }
        }
    }

    private  void CharacterControls(int code)
    {
        if(code == KeyEvent.VK_W)
        {
            upPressed = true;
        }
        if(code == KeyEvent.VK_S)
        {
            downPressed = true;
        }
        if(code == KeyEvent.VK_A)
        {
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D)
        {
            rightPressed = true;
        }
    }
    private  void PauseGamme(int code)
    {
        if(code == KeyEvent.VK_ESCAPE)
        {
            if(gp.gameState == gp.playState)
            {
                gp.gameState = gp.pauseState;
                System.out.println("GAME PAUSED");
            }
            else if(gp.gameState == gp.pauseState)
            {
                gp.gameState = gp.playState;
                System.out.println("GAME CONTINUED");
            }
        }
    }
    private  void CharacterStats(int code)
    {
        if(code == KeyEvent.VK_C)
        {
            if(gp.gameState == gp.playState)
            {
                System.out.println("SHOW STATS");
                gp.gameState = gp.characterState;
            }
            else if(gp.gameState == gp.characterState)
            {
                gp.gameState = gp.playState;
                System.out.println("GAME CONTINUED");
            }
        }
    }
    private  void BasicAttack(int code)
    {
        if(code == KeyEvent.VK_Q)
        {
            System.out.println("USED A SKILL");
        }
    }
    private  void SaySomething(int code)
    {
        if(code == KeyEvent.VK_E)
        {
            if(gp.gameState == gp.playState)
            {
                gp.gameState = gp.dialougeState;
            }
            else if (gp.gameState == gp.dialougeState)
            {
                gp.gameState = gp.playState;
            }
        }
    }



    // METHOD OVERLOADING SANA BUT WE CAN JUST SPLIT MGA MESSAGES WITH \n
    private void sayMessage(String line1, String line2, String line3)
    {

    }
    private void sayMessage(String line1, String line2)
    {

    }
    private void sayMessage(String line1)
    {

    }

}
