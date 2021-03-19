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
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tilesID;
    private Game game;
    private Boolean running;
    private Thread worldThread;

    /**
     * World constructor
     * @param path
     */
    public World(String path){
        loadWorld(path);
    }

    public void populateMap(Graphics g){
        for(int j = 0; j<height; j++){
            for(int i = 0; i<width; i++) {
                getTile(i,j).render(g,i*Tile.TEXTUREWIDTH,j*Tile.TEXTUREHEIGHT);
            }
        }
    }

    public Tile getTile(int x, int y){
        //error prevention
        if(x<0 || y<0 || x>=width || y>=height){
            return Tile.floorTile;
        }

        Tile t = Tile.tiles[tilesID[x][y]];
        if(t == null){
            return Tile.floorTile;
        }
        return t;
    }

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

    //Helper methods for loading the world
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
}

