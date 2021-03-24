package GameObjects;

import World.Tile;
import World.World;
import graphics.Assets;
import state.Game;


import java.awt.*;

/**
 * Enemy class
 * Defines the moving enemies of the game
 */
public class Enemy extends GameObject implements Runnable{
    private int deductionValue;
    private Thread enemyThread;
    private int textureSize = Tile.TEXTUREWIDTH;
    private MainCharacter player;

    /**
     * Enemy constructor
     * @param location Defines the spawning location of the enemy
     * @param deductionValue defines the amount of points the player loses if they run into this enemy
     * @param player defines the player-controlled character in the game
     */
    public Enemy(World world, Point location, int deductionValue, MainCharacter player) {
        super(world,location);
        this.deductionValue = deductionValue;
        this.image = Assets.enemy;
        this.player = player;
    }

    /**
     * Enemy thread
     * updates the location of the enemy based on the location of the player
     */
    @Override
    public void run() {
        // enemy will prioritize moving in terms of left and right direction to
        // player then prioritizes moving up and down closer to player
        while(running){
            int xTowardsPlayer = 0;
            int yTowardsPlayer = 0;

            if (location.x < player.getX() && isWalkable(new Point(location.x + textureSize, location.y))) {
                xTowardsPlayer = textureSize;
            } else if (location.x > player.getX() && isWalkable(new Point(location.x - textureSize, location.y))) {
                xTowardsPlayer = -textureSize;
            } else if (location.y < player.getY() && isWalkable(new Point(location.x, location.y  + textureSize))) {
                yTowardsPlayer = textureSize;
            } else if (location.y > player.getY() && isWalkable(new Point(location.x, location.y - textureSize))) {
                yTowardsPlayer = -textureSize;
            }

            nextLocation.x = location.x + xTowardsPlayer;
            nextLocation.y = location.y + yTowardsPlayer;

            setLocation(nextLocation.x, nextLocation.y);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * @return whether the enemy is located on top of player
     */
    public boolean isOnPlayer(){
        return (location.x == player.getX() && location.y == player.getY());
    }

    /**
     * Starts enemy thread
     */
    public synchronized void start(){
        if(running)
            return;
        running = true;
        enemyThread = new Thread(this);
        enemyThread.start();
    }

    /**
     * stops enemy thread
     */
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            enemyThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
