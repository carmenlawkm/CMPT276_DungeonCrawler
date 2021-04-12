package World;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void shouldLoadFile() {
        assertEquals("15 10\n" +
                "0 0\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n" +
                "3 0 0 0 0 0 0 0 0 0 0 0 0 0 1\n" +
                "1 0 0 0 0 0 0 0 1 0 1 0 0 0 1\n" +
                "1 1 1 1 0 0 0 0 1 0 0 0 0 0 1\n" +
                "1 0 0 0 0 0 0 0 0 0 0 0 0 0 1\n" +
                "1 0 0 1 0 0 0 0 1 0 0 1 1 1 1\n" +
                "1 0 1 1 0 1 0 0 0 0 0 0 0 0 1\n" +
                "1 0 0 1 0 0 0 0 0 1 0 5 1 0 2\n" +
                "1 0 0 0 0 0 0 0 0 1 0 0 0 0 1\n" +
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n", World.loadFile("src/test/resources/fileTest.txt"));
    }

    @Test
    void shouldConvertStringToInt() {
        //should correctly convert string into integer
        assertEquals(10,World.stringToInt("10"));
    }


    //testing constructor & loadWorld
    @Test
    void shouldCreateWorld(){
        //loadTest passed
        World world = new World("src/test/resources/fileTest.txt");
        //check width, height has been assigned correctly
        assertEquals(15, world.getWidth());
        assertEquals(10, world.getHeight());
        //check spawnX, spawn Y has been assigned correctly
        assertEquals(0, world.getSpawnX());
        assertEquals(0, world.getSpawnY());
        //check tileArray has been transferred correctly
        int [][] testTilesID= {
                {1, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 5, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 2, 1, 1}
        };

        int [][] tilesID = world.getTilesID();

        for(int j = 0; j<world.getHeight(); j++) {
            for (int i = 0; i < world.getWidth(); i++) {
                assertEquals(testTilesID[i][j], tilesID[i][j]);
            }
        }
    }

    @Test
    void shouldGetOriginalTile() {
        World world = new World("src/main/resources/fileTest.txt");
        //case: in bound and not null should return the corresponding Tile type with correct id
        int x = 0;
        int y = 0;
        assertEquals(Tile.barrierTile, world.getTile(x,y));
    }

    @Test
    void shouldGetDefaultTile(){
        //need to test that loadWorld and loadFile correctly loads path first
        World world = new World("src/main/resources/fileTest.txt");
        int x, y = 0;
        //case 1.1: -x should return floorTile (0)
        x = -1;
        assertEquals(Tile.floorTile, world.getTile(x,y));
        //case 1.2: -y should return floorTile (0)
        y = -1;
        assertEquals(Tile.floorTile, world.getTile(x,y));
        //case 1.3: out of bound array width should return floorTile (0)
        x = 100;
        assertEquals(Tile.floorTile, world.getTile(x,y));
        //case 1.4: out of bound array height should return floorTile (0)
        y = 100;
        assertEquals(Tile.floorTile, world.getTile(x,y));
        //case 1.5: returned Tile is null should default to floorTile(0)
        y = 7;
        x = 11;
        assertEquals(Tile.floorTile, world.getTile(x,y));
    }



}