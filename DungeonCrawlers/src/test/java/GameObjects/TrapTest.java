package GameObjects;

import World.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TrapTest {
    private World world;
    private Point playerSpawn;
    private MainCharacter player;
    private Trap trap;


    @BeforeEach
    void setup() {
        world = new World("src/main/resources/Level1.txt");
        playerSpawn = new Point(0, 80);
        player = new MainCharacter(world, playerSpawn);
        trap = new Trap(world, new Point(0, 80), 1, player);
    }

    @Test
    void updateWhenPlayerSameLocationAndTrapNotSteppedOn() {
        trap.update();
        assertEquals(-1, player.getScore());
        assertTrue(trap.steppedOn);
    }

    @Test
    void updateWhenPlayerSameLocationAndTrapSteppedOn(){
        trap.update();
        assertEquals(-1, player.getScore());
        assertTrue(trap.steppedOn);

        // Expect score not to be further deducted, if trap already stepped on
        trap.update();
        assertEquals(-1, player.getScore());
    }

    @Test
    void updateWhenPlayerXDifferent(){
        player.setLocation(1, 80);

        trap.update();
        assertEquals(0, player.getScore());
        assertFalse(trap.steppedOn);
    }

    @Test
    void updateWhenPlayerYDifferent(){
        player.setLocation(0, 81);

        trap.update();
        assertEquals(0, player.getScore());
        assertFalse(trap.steppedOn);
    }
}
