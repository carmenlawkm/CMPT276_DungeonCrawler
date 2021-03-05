package main.java.com.game.GameObjects;

import java.awt.*;

public abstract class GameObject {
    private Image image;
    private Point location;
    private ID id;

    //constructor
    GameObject(Image image, Point location, ID id){ //currently no location upon creation as
        this.image = image;
        this.location = location;
        this.id = id;
    }

    //getters
    public Image getImage() {
        return image;
    }

    public Point getLocation(){
        return location;
    }

    public int getX(){
        return location.x;
    }

    public int getY(){
        return location.y;
    }

    public ID getId(){
        return id;
    }

    //setters
    public void setLocation(int x, int y){
        location.x = x;
        location.y = y;
    }

    public void setX(int x){
        location.x = x;
    }

    public void setY(int y){
        location.y = y;
    }
}
