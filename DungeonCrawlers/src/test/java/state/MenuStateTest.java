package state;
import graphics.Assets;
import input.MouseInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

class MenuStateTest {
    public Game game;
    public Image logo;
    public Image bg;
    public MenuState menustate;
    public Level1State level1;

    @BeforeEach
    void setup(){
        game = Game.getInstance();
        menustate = new MenuState();
        level1 = new Level1State();
        game.menuState=menustate;
        game.gameState=level1;
        //game.initialize();
        //State.setState(menustate);

    }
    @Test
    void updateTest(){
        MouseInput m = new MouseInput();
        JPanel frame = new JPanel();
        frame.addMouseListener(m);
        MouseEvent mouseEvent = new MouseEvent(frame,MouseEvent.MOUSE_CLICKED,0,MouseEvent.BUTTON1_MASK ,100,100,1,false);
        m.mousePressed(mouseEvent);
        game.setMouseClick(m);
        assertTrue(game.getMouseInput().isLeftPressed());
        menustate.update();
        assertTrue(State.getState()==game.gameState);



    }

}