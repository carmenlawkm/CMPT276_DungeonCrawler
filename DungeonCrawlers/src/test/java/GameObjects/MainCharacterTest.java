package GameObjects;

import World.World;
import World.Tile;

import input.KeyInput;
import org.junit.*;
import state.Game;
import state.Level1State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

public class MainCharacterTest {

    private World world;
    private Point playerSpawn;
    private MainCharacter player;
    private Game game;


    @Before
    public void setup(){
        world = new World("src/main/resources/Level1.txt");
        playerSpawn = new Point(0,80);
        player = new MainCharacter(world, playerSpawn);
        game = Game.getInstance();
    }

    @Test
    public void walkingUp() {
        //Press W key
        KeyInput k = new KeyInput();
        JPanel frame = new JPanel();
        frame.addKeyListener(k);
        KeyEvent keyEvent = new KeyEvent(frame,KeyEvent.KEY_PRESSED,0,0, KeyEvent.VK_W);
        k.keyPressed(keyEvent);
        game.setKeyInput(k);

        //on normal tile
        player.setLocation(80, 160);
        player.update();
        assertEquals(new Point(80, 160-Tile.TEXTUREHEIGHT), player.getLocation());

        //into barrier
        player.setLocation(80, 80);
        player.update();
        assertEquals(new Point(80, 80), player.getLocation());

        //out-of-bounds
        player.setLocation(0, 0);
        player.update();
        assertEquals(new Point(0, 0), player.getLocation());
    }

    @Test
    public void walkingDown() {
        //Press S key
        KeyInput k = new KeyInput();
        JPanel frame = new JPanel();
        frame.addKeyListener(k);
        KeyEvent keyEvent = new KeyEvent(frame,KeyEvent.KEY_PRESSED,0,0, KeyEvent.VK_S);
        k.keyPressed(keyEvent);
        game.setKeyInput(k);

        //on normal tile
        player.setLocation(80, 80);
        player.update();
        assertEquals(new Point(80, 80+Tile.TEXTUREHEIGHT), player.getLocation());

        //into barrier
        player.setLocation(80, 160);
        player.update();
        assertEquals(new Point(80, 160), player.getLocation());

        //out-of-bounds
        player.setLocation(80, 720);
        player.update();
        assertEquals(new Point(80, 720), player.getLocation());
    }

    @Test
    public void walkingLeft() {
        //Press A key
        KeyInput k = new KeyInput();
        JPanel frame = new JPanel();
        frame.addKeyListener(k);
        KeyEvent keyEvent = new KeyEvent(frame,KeyEvent.KEY_PRESSED,0,0, KeyEvent.VK_A);
        k.keyPressed(keyEvent);
        game.setKeyInput(k);

        //on normal tile
        player.setLocation(240, 160);
        player.update();
        assertEquals(new Point(240-Tile.TEXTUREWIDTH, 160), player.getLocation());

        //into barrier
        player.setLocation(80, 160);
        player.update();
        assertEquals(new Point(80, 160), player.getLocation());

        //out-of-bounds
        player.setLocation(0, 0);
        player.update();
        assertEquals(new Point(0, 0), player.getLocation());
    }

    @Test
    public void walkingRight() {
        //Press D key
        KeyInput k = new KeyInput();
        JPanel frame = new JPanel();
        frame.addKeyListener(k);
        KeyEvent keyEvent = new KeyEvent(frame,KeyEvent.KEY_PRESSED,0,0, KeyEvent.VK_D);
        k.keyPressed(keyEvent);
        game.setKeyInput(k);

        //on normal tile
        player.setLocation(80, 80);
        player.update();
        assertEquals(new Point(80+Tile.TEXTUREWIDTH, 80), player.getLocation());

        //into barrier
        player.setLocation(560, 160);
        player.update();
        assertEquals(new Point(560, 160), player.getLocation());

        //out-of-bounds
        player.setLocation(1120, 160);
        player.update();
        assertEquals(new Point(1120, 160), player.getLocation());
    }


    @Test
    public void getRewardCount() {
        assertTrue(player.getRewardCount() == 0);
    }

    @Test
    public void addRewardCount() {
        int firstRewardCount = player.getRewardCount();
        player.addRewardCount();
        int newRewardCount = player.getRewardCount();
        assertTrue(firstRewardCount == newRewardCount - 1);
    }

    @Test
    public void level1ShouldWin() {
        //case 1: 5 rewards and on location
        player.setLocation(Level1State.exitLocation.x, Level1State.exitLocation.y);
        for (int i = 0; i < 5; i++){
            player.addRewardCount();
        }
        assertEquals(true, player.getLevel1Win());
    }

    @Test
    public void level1ShouldNotWin(){
        //case 1: not 5 rewards and not on location
        assertEquals(false, player.getLevel1Win());

        //case 2: not 5 rewards but on location
        player.setLocation(Level1State.exitLocation.x, Level1State.exitLocation.y);
        assertEquals(false, player.getLevel1Win());

        //case 3: 5 rewards but not on location
        for (int i = 0; i < 5; i++){
            player.addRewardCount();
        }
        player.setLocation(Level1State.exitLocation.x - 40, Level1State.exitLocation.y - 40);
        assertEquals(false, player.getLevel1Win());
    }

    @Test
    public void getScore(){
        assertEquals(0, player.getScore());
    }

    @Test
    public void getTime() {
        System.out.println(player.getTime());
        assertEquals(0, player.getTime());
    }

    @Test
    public void startAndStoppingThread() {
        player.start();
        assertTrue(player.getPlayerThread().isAlive());
        player.stop();
        assertFalse(player.getPlayerThread().isAlive());
    }

}