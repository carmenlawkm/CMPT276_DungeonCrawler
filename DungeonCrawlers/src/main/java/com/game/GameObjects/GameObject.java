package main.java.com.game.GameObjects;

//import net.coobird.thumbnailator.*;

import java.awt.*;

public abstract class GameObject {
    protected Point location;

    //constructor
    GameObject(Point location){ //currently no location upon creation as
        this.location = location;
    }

    public abstract void update();
    public abstract void render(Graphics g);

}
