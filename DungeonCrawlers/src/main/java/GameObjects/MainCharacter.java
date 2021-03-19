package GameObjects;

import state.Game;
import graphics.*;
import World.*;

import java.awt.*;

/**
 * MainCharacter class defines the player-controlled character of the game
 */
public class MainCharacter extends GameObject implements Runnable{
    protected int score;
    private Thread thread;
    private int keyCode;
    boolean running;
    private Graphics g;

    /**
     * MainCharacter constructor
     * @param world defines the world the character is loaded in
     * @param location defines the spawning point of the player
     */
    public MainCharacter(Game game, World world, Point location) {
        super(game, world,location);
        score = 100;
        this.image = Assets.player;
    }

    public void render(Graphics g) {
        g.drawImage(image, location.x, location.y, tileSize, tileSize, null);
    }

    public void run(){

        while(true){
            keyCode = game.getKeyInput().getKeyCode();
            if(game.getKeyInput().up_W == keyCode && location.y > 0){
                System.out.println("Character is going up");
                nextLocation.x = location.x;
                nextLocation.y = location.y - tileSize;
                if(isWalkable(nextLocation)){
                    location.y -=tileSize;
                }
            }else if(game.getKeyInput().down_S == keyCode && location.y <800){
                System.out.println("Character is going down");
                nextLocation.x = location.x;
                nextLocation.y = location.y + tileSize;
                if(isWalkable(nextLocation)){
                    location.y +=tileSize;
                }
            }else if(game.getKeyInput().left_A == keyCode && location.x > 0){
                System.out.println("Character is going left");
                nextLocation.y = location.y;
                nextLocation.x = location.x - tileSize;
                if(isWalkable(nextLocation)){
                    location.x -=tileSize;
                }
            }else if(game.getKeyInput().right_D == keyCode && location.x < 1200){
                System.out.println("Character is going right");
                nextLocation.y = location.y;
                nextLocation.x = location.x + tileSize;
                if(isWalkable(nextLocation)){
                    location.x +=tileSize;
                }
            }else{
                System.out.println("Character is NOT moving");
            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
