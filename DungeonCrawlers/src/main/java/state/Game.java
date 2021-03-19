package state;

//import GameObjects.Enemy;
//import GameObjects.GameObject;
//import GameObjects.ID;
//import GameObjects.MainCharacter;
import graphics.*;
import graphics.Window;
import input.KeyInput;

import java.awt.*;
import java.awt.image.BufferStrategy;
//import input.KeyInput;

/**
 * Game class manages state of the game
 */
public class Game{

    private static Game instance;
    private Window window;
    private int width, height;
    private String title;
    private KeyInput k;
    private boolean running = false;
    private State gameState;
    private BufferStrategy bs;
    private Graphics g;

    public Game(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        k = new KeyInput();
        initialize();
    }

    public static Game getInstance(){
        if(instance == null){
            instance = new Game(1200, 800, "DungeonCrawler");
        }
        return instance;
    }

    private void initialize() {
        window = new Window(width, height, title);
        window.getFrame().addKeyListener(k);
        Assets.initAssets();
        System.out.println("Loading world...");
        if(bs == null){
            window.getCanvas().createBufferStrategy(2);
        }
        gameState = new Level1State(this);
        State.setState(gameState);
        render();
    }

    private void render(){
        bs = window.getCanvas().getBufferStrategy();
        g = bs.getDrawGraphics();

        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here!
        gameState.render(g);
        //End Drawing!
        bs.show();
        g.dispose();
    }

    public KeyInput getKeyInput(){return k;}

}
