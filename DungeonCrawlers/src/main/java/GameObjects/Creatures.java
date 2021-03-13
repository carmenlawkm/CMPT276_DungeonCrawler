package GameObjects;

import state.Game;
import state.Timer;

import java.awt.*;

public abstract class Creatures extends GameObject implements Runnable{

    protected Game game;
    protected Timer timer;
    protected Thread creatureThread;
    protected boolean running;

    Creatures(Point location) {
        super(location);
        this.game = Game.getInstance();
        this.timer = game.getTimer();
    }

    @Override
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
        creatureThread = new Thread(this);
        creatureThread.start();
    }

    //stops the thread
    public synchronized void stop() {
        if (!running) return;

        running = false;
        try {
            creatureThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
