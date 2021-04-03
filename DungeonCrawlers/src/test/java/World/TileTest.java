package World;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {
    @Test
    void getID() {
        Tile floorTile = new FloorTile(0);
        assertEquals(0, floorTile.getID());
    }

}