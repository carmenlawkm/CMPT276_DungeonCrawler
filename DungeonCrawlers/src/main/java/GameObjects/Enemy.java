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
    public Enemy(Game game, World world, Point location, int deductionValue, MainCharacter player) {
        super(game, world,location);
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
            if (location.x == player.getX() && location.y == player.getY()) {
                player.score = player.score - deductionValue;
                System.out.printf("Enemy is in the same spot as player: (%2d,%2d)%n", location.x, location.y);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (location.x < player.getX() ) {
                xTowardsPlayer = textureSize;
                System.out.printf("Enemy is to the left of player in position (%2d, %2d), Player: (%2d, %2d)%n", location.x, location.y, player.getX(), player.getY());
            } else if (location.x > player.getX() ) {
                xTowardsPlayer = -textureSize;
                System.out.printf("Enemy is to the right of player in position (%2d, %2d), Player: (%2d, %2d)%n", location.x, location.y, player.getX(), player.getY());
            } else if (location.y < player.getY() ) {
                yTowardsPlayer = textureSize;
                System.out.printf("Enemy is below player in position (%2d, %2d), Player: (%2d, %2d)%n", location.x, location.y, player.getX(), player.getY());
            } else if (location.y > player.getY() ) {
                yTowardsPlayer = -textureSize;
                System.out.printf("Enemy is above player in position (%2d, %2d), Player: (%2d, %2d)%n", location.x, location.y, player.getX(), player.getY());
            }

            nextLocation.x = location.x + xTowardsPlayer;
            nextLocation.y = location.y + yTowardsPlayer;

            if(isWalkable(nextLocation)){
                setLocation(location.x + xTowardsPlayer, location.y + yTowardsPlayer);
            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

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
