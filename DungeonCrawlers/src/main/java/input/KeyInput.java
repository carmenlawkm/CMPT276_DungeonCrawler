package input;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyInput class manages player key presses to move the character
 */
public class KeyInput implements KeyListener{
    private boolean[] keys;
    public boolean up, down, left, right;

    /**
     * keyinput constructor
     * defines boolean array of 256 possible keys
     */
    public KeyInput(){
        keys=new boolean[256];
    }

    /**
     * updates the four possible input keys
     * turns true if being pressed
     */
    public void update(){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
    }

    /**
     * turns the boolean of the key being pressed true
     * @param e defines the key pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    /**
     * turns the boolean value of the key being released false
     * @param e defines the key released
     */
    public void keyReleased(KeyEvent e){
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
