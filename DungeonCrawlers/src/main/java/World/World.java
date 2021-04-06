package World;

import state.Game;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * World defines the game's environment
 * Implements graphics in a thread
 */
public class World{
    private int width, height; //width and height in array unit (cells)
    private int spawnX, spawnY;
    private int[][] tilesID;

    /**
     * World constructor
     * @param path
     */
    public World(String path){
        loadWorld(path);
    }

    /**
     * Populates the map with tiles accordingly
     * @param g graphic to populate on
     */
    public void populateMap(Graphics g){
        for(int j = 0; j<height; j++){
            for(int i = 0; i<width; i++) {
                getTile(i,j).render(g,i*Tile.TEXTUREWIDTH,j*Tile.TEXTUREHEIGHT);
            }
        }
    }

    /**
     * Retrieve a tile from the floor
     * @param x x-coordinate of the tile you want to get
     * @param y y-coordinate of the tile you want to get
     * @return the tile!
     */
    public Tile getTile(int x, int y){
        //error prevention
        if(x<0 || y<0 || x>=width || y>=height){
            return Tile.floorTile;
        }

        Tile t = Tile.tiles[tilesID[x][y]]; //in cell unit
        if(t == null){
            return Tile.floorTile;
        }
        return t;
    }

    /**
     * Load world according to level design
     * @param path path to the file indicating tile locations
     */
    private void loadWorld(String path){
        String file = loadFile(path);
        String [] value = file.split("\\s+"); //split by space
        width  = stringToInt(value[0]);
        height = stringToInt(value[1]);
        spawnX  = stringToInt(value[2]);
        spawnY = stringToInt(value[3]);

        tilesID = new int[width][height];
        for(int j = 0; j<height; j++){
            for(int i = 0; i<width; i++) {
                tilesID[i][j] = stringToInt(value[(i+j*width)+4]);
            }
        }
    }

    /**
     * Helper method for loading the file
     * @param path path location of the file
     * @return
     */
    public static String loadFile (String path){
        StringBuilder builder = new StringBuilder();

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null){
                builder.append(line + "\n");
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static int stringToInt (String number){
        try{
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}

