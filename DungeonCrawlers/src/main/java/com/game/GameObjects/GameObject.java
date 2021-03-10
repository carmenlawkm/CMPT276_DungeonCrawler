package main.java.com.game.GameObjects;

import java.awt.*;

public abstract class GameObject {
    protected Point location;

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
    public abstract void render(Graphics g);

}
