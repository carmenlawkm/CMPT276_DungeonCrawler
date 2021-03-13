package GameObjects;

import graphics.Assets;
import graphics.Window;
import state.Game;
import state.State;
import state.Timer;

import java.awt.*;
import java.awt.image.BufferStrategy;

public abstract class GameObject implements Runnable{
    protected Point location;
    public Image image;
    protected Game game;
    protected Timer timer;
    protected Thread objectThread;
    protected boolean running;

    //constructor
    GameObject(Point location){ //currently no location upon creation as
        this.location = location;
        this.game = Game.getInstance();
        this.timer = game.getTimer();
    }

    public Point getLocation(){
        return location;
    }

    public void setLocation(int x, int y){
        location.x = x;
        location.y = y;
    }

    public abstract void update();

    //object thread
    public void run() {
        synchronized (timer){

            while(running) {

                game.render(image, location.x, location.y);
                //update location
                update();

                //wait for one tick controlled by Timer class
                try {
                    timer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //starts the thread
    public synchronized void start() {
        if (running) return;

        running = true;
        objectThread = new Thread(this);
        objectThread.start();
    }

    //stops the thread
    public synchronized void stop() {
        if (!running) return;

        running = false;
        try {
            objectThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
