package GameObjects;

import World.World;
import org.junit.*;

import java.awt.*;

import static org.junit.Assert.*;

public class TrapTest {
    private World world;
    private Point playerSpawn;
    private MainCharacter player;
    private Trap trap;


    @Before
    public void setup() {
        world = new World("src/main/resources/Level1.txt");
        playerSpawn = new Point(0, 80);
        player = new MainCharacter(world, playerSpawn);
        trap = new Trap(world, new Point(0, 80), 1, player);
    }



    /** ***
     * Check that update decreases player score when player and trap in the same location and trap not stepped on
    * */
    @Test
    public void updateWhenPlayerSameLocationAndTrapNotSteppedOn() {
        trap.update();
        assertEquals(-1, player.getScore());
        assertTrue(trap.steppedOn);
    }
    /** ***
     * Check that update decreases player score when player and trap in the same location and trap stepped on
     * */
    @Test
    public void updateWhenPlayerSameLocationAndTrapSteppedOn(){
        trap.update();
        assertEquals(-1, player.getScore());
        assertTrue(trap.steppedOn);

        // Expect score not to be further deducted, if trap already stepped on
        trap.update();
        assertEquals(-1, player.getScore());
    }
    /** ***
     * Check that update does not decrease player score when player at different X
     * */
    @Test
    public void updateWhenPlayerXDifferent(){
        player.setLocation(1, 80);

        trap.update();
        assertEquals(0, player.getScore());
        assertFalse(trap.steppedOn);
    }

    /** ***
     * Check that update does not decrease player score when player at different Y
     * */
    @Test
    public void updateWhenPlayerYDifferent(){
        player.setLocation(0, 81);

        trap.update();
        assertEquals(0, player.getScore());
        assertFalse(trap.steppedOn);
    }
}
