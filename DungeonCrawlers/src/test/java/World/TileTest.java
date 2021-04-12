package World;

import graphics.Assets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {
    @Test
    void shouldCreateTile(){
        Tile floorTile = new Tile(Assets.floor,0);
        //test id is being assigned correctly
        assertEquals(0, floorTile.getID());
        //test texture is being assigned correctly
        assertEquals(Assets.floor, floorTile.getTexture());
        //test tile array has been assigned
        assertEquals(floorTile, Tile.tiles[0]);
    }

}