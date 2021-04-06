package GameObjects;

import state.Game;
import graphics.*;
import World.*;
import state.Level1State;

import java.awt.*;

/**
 * MainCharacter class defines the player-controlled character of the game
 */
public class MainCharacter extends GameObject implements Runnable{
    protected int score;
    private Thread playerThread;
    private int keyCode;
    private int rewardCount;
    private boolean win = false;
    private int timepassed;

    /**
     * MainCharacter constructor
     * @param world defines the world the character is loaded in
     * @param location defines the spawning point of the player
     */
    public MainCharacter(World world, Point location) {
        super(world,location);
        score = 0;
        this.image = Assets.player;
    }

    @Override
    public void update() {
        keyCode = game.getKeyInput().getKeyCode();
        if(game.getKeyInput().keyPressed){
            if(game.getKeyInput().up_W == keyCode){
                System.out.println("Character is going up");
                nextLocation.x = location.x;
                nextLocation.y = location.y - tileSize;
                if(isWalkable(nextLocation) && nextLocation.y >= 0){
                    location.y -=tileSize;
                }
            }else if(game.getKeyInput().down_S == keyCode){
                System.out.println("Character is going down");
                nextLocation.x = location.x;
                nextLocation.y = location.y + tileSize;
                if(isWalkable(nextLocation) && nextLocation.y <= 720){
                    location.y +=tileSize;
                }
            }else if(game.getKeyInput().left_A == keyCode){
                System.out.println("Character is going left");
                nextLocation.y = location.y;
                nextLocation.x = location.x - tileSize;
                if(isWalkable(nextLocation) && nextLocation.x >= 0){
                    location.x -=tileSize;
                }
            }else if(game.getKeyInput().right_D == keyCode){
                System.out.println("Character is going right");
                nextLocation.y = location.y;
                nextLocation.x = location.x + tileSize;
                if(isWalkable(nextLocation) && nextLocation.x <= 1120){
                    location.x +=tileSize;
                }
            }else{
                System.out.println("Character is NOT moving");
                nextLocation = location;
            }
        }
    }

    /**
     * Main character thread loop
     * Updates the location of main character
     */
    public void run(){
        while(running){
            timepassed++;
            update();

            try {
                game.getKeyInput().setKeyPressed(false);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * checks if player has successfully won
     * @return the status of whether the player won
     */
    public boolean getLevel1Win(){
        if(rewardCount==5 && location.x == Level1State.exitLocation.x && location.y == Level1State.exitLocation.y){
            return true;
        }else{
            return false;
        }
    }

    /**
     * To indicate the player acquired a reward
     */
    public void addRewardCount(){
        rewardCount++;
    }

    /**
     * @return the number of awards the player has collected
     */
    public int getRewardCount(){
        return rewardCount;
    }

    /**
     * @return the current score of the player
     */
    public int getScore(){
        return score;
    }

    /**
     * starts player thread
     */
    public int getTime(){
        return timepassed;
    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        playerThread = new Thread(this);
        playerThread.start();
    }

    /**
     * stops player thread
     */
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            playerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
