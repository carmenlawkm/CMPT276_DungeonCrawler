package GameObjects;

import graphics.Assets;

import java.awt.*;

public abstract class GameObject {
    protected Point location;
    protected Image image;

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

    public void render(Graphics g) {
        g.drawImage(this.image, location.x,location.y, 40,40,null);
    }

}
