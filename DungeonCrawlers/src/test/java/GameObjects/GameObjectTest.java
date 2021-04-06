package GameObjects;

import World.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GameObjectTest {

    private World world;
    private Point playerSpawn;
    private MainCharacter player;

    @BeforeEach
    void setup(){
        world = new World("src/main/resources/Level1.txt");
        playerSpawn = new Point(0,80);
        player = new MainCharacter(world, playerSpawn);
    }

    @Test
    void getLocation() {
        Point point = new Point(0, 80);
        assertEquals(point, player.getLocation());
    }

    @Test
    void getX() {
        assertEquals(0, player.getX());
    }

    @Test
    void getY() {
        assertEquals(80, player.getLocation());
    }

    @Test
    void setLocation() {
        player.setLocation(80, 80);
        assertEquals(new Point(80, 80), player.getLocation());
    }

    @Test
    void isWalkable() {
        //from the map, we know 0, 80 is walkable
        assertTrue(player.isWalkable(new Point(0, 80)));
        //we also know that 0, 160 is a barrier
        assertFalse(player.isWalkable(new Point(0, 160)));
    }
}