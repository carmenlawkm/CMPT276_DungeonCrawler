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
public abstract class GameObject{
    protected Point location;
    public Image image;

    /**
     * GameObject constructor
     * @param location defines the location of the object
     */
    GameObject(Point location){ //currently no location upon creation as
        this.location = location;
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

}
