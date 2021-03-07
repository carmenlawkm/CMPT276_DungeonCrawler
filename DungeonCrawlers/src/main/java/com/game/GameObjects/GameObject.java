package main.java.com.game.GameObjects;

import main.java.com.game.ImageLoader;
import net.coobird.thumbnailator.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class GameObject {
    private String image;
    private Point location;
    private ID id;

    //constructor
    GameObject(String image, Point location, ID id){ //currently no location upon creation as
        this.image = image;
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

    public BufferedImage loadImage(){
        try {
            BufferedImage bImage;
            bImage = ImageIO.read(ImageLoader.class.getResource(image));
            return Thumbnails.of(bImage).size(100, 100).asBufferedImage();
        }catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
