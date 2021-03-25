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
    boolean running;
    protected Game game;
    protected World world;
    protected Tile nextTile;
    protected int trapDeduct = 100;
    protected Point nextLocation = new Point();
    protected int tileSize = Tile.TEXTUREWIDTH;

    /**
     * GameObject constructor
     * @param location defines the location of the object
     */
    GameObject(World world, Point location){ //currently no location upon creation as
        this.location = location;
        this.world = world;
        this.game = Game.getInstance();
    }

    /**
     * @return object's current location
     */
    public Point getLocation(){
        return location;
    }

    /**
     * @return x-value of object current location
     */
    public int getX(){
        return location.x;
    }

    /**
     * @return y-value of object current location
     */
    public int getY(){
        return location.y;
    }

    /**
     * Change the object's location
     * @param x x value of new location
     * @param y y value of new location
     */
    public void setLocation(int x, int y){
        location.x = x;
        location.y = y;
    }

    /**
     * draw the picture of the object
     * @param g graphic to render to
     */
    public void render(Graphics g){
        g.drawImage(image, location.x, location.y, tileSize, tileSize, null);
    }

    /**
     * abstract class for each game object's update method
     */
    public abstract void update();

    /**
     * determines if next tile is walkable
     * @param nextLocation the next location the object wishes to walk to
     * @return whether the location should be walkable or not
     */
    public boolean isWalkable(Point nextLocation){
        nextTile = world.getTile(nextLocation.x/tileSize , nextLocation.y /tileSize);
        if(nextTile.getID() != 1){
            return true;
        }else{
            return false;
        }
    }

    /**
     *determine if next tile is a trap
     * @param nextLocation the next location the object wishes to walk to
     * @return whether the location should be walkable or not
     */
    public boolean onLava(Point nextLocation){
        nextTile = world.getTile(nextLocation.x/tileSize , nextLocation.y /tileSize);
        if(nextTile.getID() == 3){
            return true;
        }else{
            return false;
        }
    }


}
