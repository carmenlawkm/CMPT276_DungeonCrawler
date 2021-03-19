package GameObjects;

import World.Tile;
import World.World;
import state.Game;
import state.Timer;
import java.awt.*;


/**
 * abstract class GameObject defines interface for objects used in the game
 */
public abstract class GameObject implements Runnable{
    protected Point location;
    public Image image;
    protected Thread objectThread;
    protected Game game;
    protected World w;
    protected Boolean running;
    protected Timer timer;
    protected Tile nextTile;
    protected Point nextLocation = new Point();
    protected int tileSize = Tile.TEXTUREWIDTH;



    /**
     * GameObject constructor
     * @param location defines the location of the object
     */
    GameObject(World w, Point location){ //currently no location upon creation as
        this.location = location;
        game = Game.getInstance();
        this.w = w;
        timer = game.getTimer();
    }

    /**
     * getLocation getter
     * @return current location of the object
     */
    public Point getLocation(){
        return location;
    }

    /**
     * location setter
     * @param x x co-ordinate of the location
     * @param y y co-ordinate of the location
     */
    public void setLocation(int x, int y){
        location.x = x;
        location.y = y;
    }

    /**
     * x coordinate getter
     * @return x coordinate of current location
     */
    public int getX(){
        return location.x;
    }

    /**
     * y coordinate getter
     * @return y coordinate of current location
     */
    public int getY(){
        return location.y;
    }

    /**
     * Abstract update method
     * Allows each individual game object to implement the way they move
     */
    public abstract void update();

    /**
     * GameObject thread
     * Runs in a loop while the game is running
     * Handles movement and visual render per tick
     * Synched to timer class, waits for signal of one tick before proceeding to next tick actions
     */
    public void run() {
        synchronized (timer){

            while(running) {

                game.render(image, location.x, location.y);
                //update location
                update();

                //wait for one tick controlled by Timer class
                try {
                    timer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Starts the thread
     */
    public synchronized void start() {
        running = true;
        objectThread = new Thread(this);
        objectThread.start();
    }

    /**
     * Stops the thread
     */
    public synchronized void stop() {
        if (!running) return;

        running = false;
        try {
            objectThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //determines if next tile is walkable (for both enemy and player)
    public boolean isWalkable(Point nextLocation){
        nextTile = w.getTile(nextLocation.x/tileSize , nextLocation.y /tileSize);
        System.out.println("Next tile is at "+nextLocation.x/tileSize+" "+nextLocation.y/tileSize);
        System.out.println("Next tile's ID is "+ nextTile.getID());
        if(nextTile.getID() != 1){
            return true;
        }else{
            return false;
        }
    }


}
