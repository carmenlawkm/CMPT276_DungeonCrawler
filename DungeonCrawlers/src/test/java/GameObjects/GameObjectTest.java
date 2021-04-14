package GameObjects;

import World.World;
import org.junit.*;
import java.awt.*;

import static org.junit.Assert.*;

public class GameObjectTest {

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
    public void getLocation() {
        Point point = new Point(0, 80);
        assertEquals(point, player.getLocation());
    }

    @Test
    public void getX() {
        assertEquals(0, player.getX());
    }

    @Test
    public void getY() {
        assertEquals(80, player.getY());
    }

    @Test
    public void setLocation() {
        player.setLocation(80, 80);
        assertEquals(new Point(80, 80), player.getLocation());
    }

    @Test
    public void isWalkable() {
        //from the map, we know 0, 80 is walkable
        assertTrue(player.isWalkable(new Point(0, 80)));
    }

    @Test
    public void isNotWalkable(){
        //we know that 0, 160 is a barrier
        assertFalse(player.isWalkable(new Point(0, 160)));
    }
}