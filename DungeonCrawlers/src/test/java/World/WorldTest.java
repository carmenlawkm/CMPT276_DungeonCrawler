package World;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void loadFile() {
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
                "1 1 1 1 1 1 1 1 1 1 1 1 1 1 1\n", World.loadFile("src/main/resources/fileTest.txt"));
    }

    @Test
    void loadWorld(){
        //loadTest passed
        //World world = new World("src/main/resources/fileTest.txt");
        //what should i be asserting? I won't be allowed to assert with getWidth, getHeight since they haven't been tested


    }

    @Test
    void getWidth() {
        World world = new World("src/main/resources/fileTest.txt");
        assertEquals(15, world.getWidth());
    }

    @Test
    void getHeight() {
        World world = new World("src/main/resources/fileTest.txt");
        assertEquals(10, world.getHeight());
    }



    @Test
    void getTile() {
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

        //case 2: in bound and not null should return the corresponding Tile type with correct id
        x = 0;
        y = 0;
        assertEquals(Tile.barrierTile, world.getTile(x,y));
    }

    @Test
    void stringToInt() {
        //should correctly convert string into integer
        assertEquals(10,World.stringToInt("10"));
    }


}