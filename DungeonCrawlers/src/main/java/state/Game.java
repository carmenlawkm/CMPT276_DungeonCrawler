package state;

//import GameObjects.Enemy;
//import GameObjects.GameObject;
//import GameObjects.ID;
//import GameObjects.MainCharacter;
import World.World;
import graphics.*;
import graphics.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;
//import input.KeyInput;
import java.awt.*;
//import java.awt.image.BufferStrategy;
//import java.nio.Buffer;

/**
 * Game class manages state of the game
 */
public class Game{

    private static Game instance;
    private Window window;
    private int width, height;
    private String title;
    //private KeyInput keyInput;
    private boolean running = false;
    //private State gameState;
    private World world;
    private BufferStrategy bs;
    private Graphics g;

    public Game(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        //keyInput = new KeyInput();
        initialize();
    }

    public static Game getInstance(){

        if(instance == null){
            instance = new Game(1200, 800, "DungeonCrawler");
        }
        return instance;
    }

    //public KeyInput getKeyInput() { return keyInput; }

    private void initialize() {
        window = new Window(width, height, title);
        //window.getFrame().addKeyListener(keyInput);
        Assets.initAssets();
        System.out.println("Loading world...");
        world = new World("DungeonCrawlers/src/main/resources/Level1.txt");
        if(bs == null){
            window.getCanvas().createBufferStrategy(2);}
        render();
       // gameState = new GameState();
//        State.setState(gameState);
    }

    private void render(){

        bs = window.getCanvas().getBufferStrategy();
        g = bs.getDrawGraphics();

        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here!
        world.populateMap(g);
        //End Drawing!
        bs.show();
        g.dispose();
    }


}
