package input;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyInput class manages player key presses to move the character
 */
public class KeyInput implements KeyListener{
    private int keyCode;
    

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key "+ e.getKeyCode()+" has been pressed!");
        keyCode = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e){ }

    @Override
    public void keyTyped(KeyEvent e) { }

    public int getKeyCode(){
        return keyCode;
    }

}
