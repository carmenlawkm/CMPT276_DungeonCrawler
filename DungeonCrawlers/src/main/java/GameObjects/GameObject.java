package GameObjects;

import graphics.Assets;
import graphics.Window;
import state.Game;
import state.State;
import state.Timer;

import java.awt.*;
import java.awt.image.BufferStrategy;

public abstract class GameObject{
    protected Point location;
    public Image image;

    //constructor
    GameObject(Point location){ //currently no location upon creation as
        this.location = location;
    }

    public Point getLocation(){
        return location;
    }

    public void setLocation(int x, int y){
        location.x = x;
        location.y = y;
    }

    public abstract void update();

}
