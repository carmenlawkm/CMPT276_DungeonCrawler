package GameObjects;

import java.awt.*;

public abstract class GameObject {
    private String image;
    private Point location;
    private ID id;

    //constructor
    GameObject(Point location, ID id){ //currently no location upon creation as
        this.location = location;
        this.id = id;
    }

    //getters
    public String getImage() {
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

    public Point moveNorth(){
        this.location.y += 50;
        return this.location;
    }

    public Point moveWest(){
        this.location.x -= 50;
        return this.location;
    }

    public Point moveEast(){
        this.location.x += 50;
        return this.location;
    }

    public Point moveSouth(){
        this.location.y -= 50;
        return this.location;
    }

    public ID getId(){
        return id;
    }

    //setters
    public void setImage(String image){
        this.image = image;
    }

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