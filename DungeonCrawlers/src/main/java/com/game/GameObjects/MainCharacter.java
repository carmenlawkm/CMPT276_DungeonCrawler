package main.java.com.game.GameObjects;

import java.awt.*;

public class MainCharacter extends GameObject {
    private Point spawn;

    //constructor
    MainCharacter(String image, Point location, ID id) {
        super(image, location, id);
    }

    //setters
    public void setSpawn(int x, int y){
        spawn.x = x;
        spawn.y = y;
    }
}
