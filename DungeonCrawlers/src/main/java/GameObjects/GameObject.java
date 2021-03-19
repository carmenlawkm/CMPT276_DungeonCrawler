package GameObjects;

import World.Tile;
import World.World;
import state.Game;
import java.awt.*;

/**
 * abstract class GameObject defines interface for objects used in the game
 */
public abstract class GameObject{
    protected Point location;
    public Image image;
    protected Game game;
    protected World world;
    protected Tile nextTile;
    protected Point nextLocation = new Point();
    protected int tileSize = Tile.TEXTUREWIDTH;

    /**
     * GameObject constructor
     * @param location defines the location of the object
     */
    GameObject(Game game, World world, Point location){ //currently no location upon creation as
        this.location = location;
        this.world = world;
        this.game = game;
    }

    public abstract void render(Graphics g);
    public Point getLocation(){
        return location;
    }
    public int getX(){
        return location.x;
    }
    public int getY(){
        return location.y;
    }

    public void setLocation(int x, int y){
        location.x = x;
        location.y = y;
    }

    //determines if next tile is walkable (for both enemy and player)
    public boolean isWalkable(Point nextLocation){
        nextTile = world.getTile(nextLocation.x/tileSize , nextLocation.y /tileSize);
        if(nextTile.getID() != 1){
            return true;
        }else{
            return false;
        }
    }

}
