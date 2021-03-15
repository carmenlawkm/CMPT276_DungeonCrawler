package state;

import GameObjects.Enemy;
import GameObjects.GameObject;
import GameObjects.ID;
import GameObjects.MainCharacter;
import graphics.*;
import graphics.Window;
import input.KeyInput;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.nio.Buffer;

/**
 * Game class manages state of the game
 */
public class Game{

    private static Game instance;
    private boolean isFirstRun;

    private Window window;
    private int width, height;
    private String title;

    private KeyInput keyInput;

    private Thread gameThread; //game runs on gameThread
    private boolean running = false;

    public BufferStrategy bs;
    public Graphics g;

    private State gameState;

    private Timer timer;

    /**
     * Game constructor
     * implements singleton design patterns
     * @param width defines width of Window to be created
     * @param height defines height of Window to be created
     * @param title defines title of Window to be created
     */
    public Game(int width, int height, String title) {

        //singleton initiation
        if(instance != null){
            isFirstRun = false;
        }else{
            isFirstRun = true;
        }

        this.width = width;
        this.height = height;
        this.title = title;

        keyInput = new KeyInput();
        timer = new Timer();
    }

    /**
     * Creates singleton Game
     * One Game object exists at all times
     * Allows classes to grab the one instance of Game object
     * @return the one instance of Game class
     */
    public static Game getInstance(){

        if(instance == null){
            instance = new Game(1200, 800, "DungeonCrawler");
        }
        return instance;
    }

    /**
     * @return Timer thread used by Game object
     */
    public Timer getTimer(){
        return timer;
    }

    /**
     * @return KeyInput class used by Game object
     */
    public KeyInput getKeyInput() {
        return keyInput;
    }

    /**
     * Initializes Window
     * Initiates assets
     * Initializes GameState
     * Repeatedly initiates buffer strategy
     */
    private void init() {

        //initiate windows
        window = new Window(width, height, title);
        //initializing a keylistener (allows access to keyboard)
        window.getFrame().addKeyListener(keyInput);
        Assets.initAssets();
        gameState = new GameState();
        State.setState(gameState);

        //initiate buffer strategy
        while(bs == null){
            initiateBs();
        }
    }

    /**
     * Initiates buffer strategy
     */
    public void initiateBs(){
        //buffer strategies allow the computer to draw things on the screen
        bs = window.getCanvas().getBufferStrategy();
        if (bs == null) {
            window.getCanvas().createBufferStrategy(2);
            return;
        }

        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height)    ;
    }

    /**
     * Renders an image to the window
     * @param image defines image to be rendered
     * @param x defines x position of image
     * @param y defines y position of image
     */
    public void render(Image image, int x, int y) {
        //draw here
        g.drawImage(image, x, y, 100, 100, null);
        bs.show();
    }

    /**
     * Clears the window of any images
     */
    public void resetGraphics() {
        g.clearRect(0, 0, width, height);
    }

    /**
     * Method to be run when game is started
     * Calls init() method
     * Initiates appropriate State class depending on the state of the game
     */
    public void run() {
        init();

        if (State.getState() != null) {
            State.getState().initiateState();
        }
    }
}
