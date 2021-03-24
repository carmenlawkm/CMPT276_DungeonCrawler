package World;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Tile class defines tiles plained in the game world
 */
public class Tile {
    public static Tile[] tiles = new Tile[256]; //holds every instance of every tile
    public static Tile floorTile = new FloorTile(0);
    public static Tile barrierTile = new BarrierTile(1);
    public static Tile exitTile = new ExitTile(2);
    public static Tile trapTile = new TrapTile(3);
    public static Tile spawnTile = new SpawnTile(4);
    public static final int  TEXTUREWIDTH = 80, TEXTUREHEIGHT =80;
    protected  BufferedImage texture;
    protected final int id; // to identify what type of tile

    /**
     * Tile constructor
     * @param texture defines image of the tile
     * @param id defines ID of type of tile
     */
    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    /**
     * renders the image of the tile
     * @param g graphic of the tile
     * @param x x location of the tile
     * @param y y location of the time
     */
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x,y, TEXTUREWIDTH, TEXTUREHEIGHT, null);
    }


    /**
     * @return the type of the tile
     */
    public int getID(){
        return id;
    }

}
