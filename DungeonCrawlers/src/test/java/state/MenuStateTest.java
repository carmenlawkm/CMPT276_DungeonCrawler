package state;
import graphics.Assets;
import input.MouseInput;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public  class MenuStateTest {
    public Game game;
    public Image logo;
    public Image bg;
    public MenuState menustate;
    public Level1State level1;

    @Before
    public void setup(){
        game = Game.getInstance();
        menustate = new MenuState();
        level1 = new Level1State();
        game.menuState=menustate;
        game.gameState=level1;


    }
    @Test
    public void updateTest(){
        //not mouseclick
        menustate.update();
        assertFalse(State.getState()==game.gameState);

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