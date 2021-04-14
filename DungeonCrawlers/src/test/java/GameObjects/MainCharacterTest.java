package GameObjects;

import World.World;
import org.junit.*;
import state.Level1State;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainCharacterTest {

    private World world;
    private Point playerSpawn;
    private MainCharacter player;


    @Before
    public void setup(){
        world = new World("src/main/resources/Level1.txt");
        playerSpawn = new Point(0,80);
        player = new MainCharacter(world, playerSpawn);
    }

    @Test
    public void walkingOnNormalTiles() {
        //up

        //down

        //left

        //right
    }

    @Test
    public void tryingToWalkIntoBarrier() {
        //up

        //down

        //left

        //right
    }

    @Test
    public void tryingToWalkOffScreen() {
        //up

        //down

        //left

        //right
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