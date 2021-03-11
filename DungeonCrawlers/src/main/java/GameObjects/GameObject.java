package GameObjects;

import graphics.Assets;
import state.Game;

import java.awt.*;

public abstract class GameObject implements Runnable{
    protected Point location;
    protected Image image;
    protected Game game;

    //constructor
    GameObject(Point location){ //currently no location upon creation as
        this.location = location;
        this.game = Game.getInstance();
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

    public void run(){
        update();
    }
}
