package GameObjects;

import graphics.Assets;
import graphics.Window;
import state.Game;
import state.State;
import state.Timer;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * abstract class GameObject defines interface for objects used in the game
 */
public abstract class GameObject implements Runnable{
    protected Point location;
    public Image image;
    protected Thread objectThread;
    protected Game game;
    protected Boolean running;
    protected Timer timer;


    /**
     * GameObject constructor
     * @param location defines the location of the object
     */
    GameObject(Point location){ //currently no location upon creation as
        this.location = location;
        game = Game.getInstance();
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
     * Creature object timer
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
        if (running) return;

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

}
