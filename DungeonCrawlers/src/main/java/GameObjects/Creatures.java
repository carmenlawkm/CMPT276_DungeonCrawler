package GameObjects;

import state.Game;
import state.Timer;

import java.awt.*;

/**
 * Creatures class defines outline for Player and Enemy classes
 * Allows Creatures to run on threads concurrently
 * Extends GameObject class
 */
public abstract class Creatures extends GameObject implements Runnable{

    protected Game game;
    protected Timer timer;
    protected Thread creatureThread;
    protected boolean running;

    /**
     * Creatures constructor
     * @param location defines the spawning location of the creature object
     */
    Creatures(Point location) {
        super(location);
        this.game = Game.getInstance();
        this.timer = game.getTimer();
    }

    /**
     * Abstract update method
     * Allows each individual object to implement the way they move
     */
    @Override
    public abstract void update();

    /**
     * Creature object timer
     * Runs in a loop while the game is running
     * Handles movement and visual render per tick
     * Synched to timer class, waits for signal of one tick before proceeding to next tick actions
     */
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

    /**
     * Starts the thread
     */
    public synchronized void start() {
        if (running) return;

        running = true;
        creatureThread = new Thread(this);
        creatureThread.start();
    }

    /**
     * Stops the thread
     */
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
