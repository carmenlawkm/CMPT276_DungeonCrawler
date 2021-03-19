package input;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyInput class manages player key presses to move the character
 */
public class KeyInput implements KeyListener{
    private int keyCode;
    public int up_W = KeyEvent.VK_W;
    public int left_A = KeyEvent.VK_A;
    public int down_S = KeyEvent.VK_S;
    public int right_D = KeyEvent.VK_D;

    @Override
    public void keyPressed(KeyEvent e) {
        keyCode = e.getKeyCode();
        System.out.println("Key "+ keyCode +" has been pressed!");
    }

    @Override
    public void keyReleased(KeyEvent e){ }

    @Override
    public void keyTyped(KeyEvent e) { }

    public int getKeyCode(){
        return keyCode;
    }

}
