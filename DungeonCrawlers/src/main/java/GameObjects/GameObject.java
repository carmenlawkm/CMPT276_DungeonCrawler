package GameObjects;

import graphics.Assets;
import graphics.Window;
import state.Game;
import state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public abstract class GameObject extends Thread{
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

    public void render() {

        BufferStrategy bs = game.getBs();
        Graphics g;
        Window window = game.getWindow();

        //buffer strategies allow the computer to draw things on the screen
        bs = window.getCanvas().getBufferStrategy();
        if (bs == null) {
            window.getCanvas().createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, game.width, game.height);

        //draw here
        g.drawImage(image, location.x, location.y, 40, 40, null);

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
            update();
            render();
    }
}
