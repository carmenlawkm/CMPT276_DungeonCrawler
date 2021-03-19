package GameObjects;

import com.sun.tools.javac.Main;
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
            System.out.println("Character now moves "+ keyCode);
//            if(game.getKeyInput().up && location.y > 0){
//                nextLocation.x = location.x;
//                nextLocation.y = location.y - tileSize;
//                if(isWalkable(nextLocation)){
//                    location.y -=tileSize;
//                }
//            }else if(game.getKeyInput().down && location.y <800){
//                nextLocation.x = location.x;
//                nextLocation.y = location.y + tileSize;
//                if(isWalkable(nextLocation)){
//                    location.y +=tileSize;
//                }
//            }else if(game.getKeyInput().left && location.x > 0){
//                nextLocation.y = location.y;
//                nextLocation.x = location.x - tileSize;
//                if(isWalkable(nextLocation)){
//                    location.x -=tileSize;
//                }
//            }else if(game.getKeyInput().right && location.x < 1200){
//                nextLocation.y = location.y;
//                nextLocation.x = location.x + tileSize;
//                if(isWalkable(nextLocation)){
//                    location.x +=tileSize;
//                }
//            }
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
