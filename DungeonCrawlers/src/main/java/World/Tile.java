package World;

import GameObjects.ExitCell;
import com.sun.java.accessibility.util.TopLevelWindowListener;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public static Tile[] tiles = new Tile[256]; //holds every instance of every tile
    public static Tile floorTile = new FloorTile(0);
    public static Tile barrierTile = new BarrierTile(1);
    public static Tile exitTile = new ExitTile(2);




    public static final int  TEXTUREWIDTH = 100, TEXTUREHEIGHT =100;
    protected  BufferedImage texture;
    protected final int id; // to identify what type of tile

    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
        tiles[id] = this;
    }

    public void render(Graphics g, int x, int y){

        g.drawImage(texture, x,y, TEXTUREWIDTH, TEXTUREHEIGHT, null);
    }

    public boolean isWalkable(){
        return true;
    }

    public int getID(){
        return id;
    }

}
