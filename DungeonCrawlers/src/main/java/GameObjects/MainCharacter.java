package GameObjects;

import java.awt.*;

public class MainCharacter extends GameObject {
    private Point spawn;

    //constructor
    public MainCharacter(Point location, ID id) {
        super(location, id);
        this.setImage("/mainCharacter.png");
    }

    //setters
    public void setSpawn(int x, int y){
        spawn.x = x;
        spawn.y = y;
    }
}