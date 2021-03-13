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

    //creates one public instance of object Game
    //available to all classes, protects from creating duplicate Game objects
    public static Game getInstance(){

        if(instance == null){
            instance = new Game(1200, 800, "DungeonCrawler");
        }
        return instance;
    }

    public BufferStrategy getBs(){
        return bs;
    }

    public Graphics getG(){
        return g;
    }

    public Timer getTimer(){
        return timer;
    }

    public KeyInput getKeyInput() {
        return keyInput;
    }

    //initialize game graphics etc
    private void init() {

        //initiate windows
        window = new Window(width, height, title);
        //initializing a keylistener (allows access to keyboard)
        window.getFrame().addKeyListener(keyInput);
        Assets.initAssets();
        gameState = new GameState(this);
        State.setState(gameState);

        //initiate buffer strategy
        while(bs == null){
            initiateBs();
        }

        //initiate background graphics

    }

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

    public void render(Image image, int x, int y) {
        //draw here
        g.drawImage(image, x, y, 100, 100, null);
        bs.show();
    }

    public void resetGraphics() {
        g.clearRect(0, 0, width, height);
    }

    public void run() { //runnable's method - runs whenever we start our thread
        init();

        if (State.getState() != null) {
            State.getState().initiateState();
        }
    }
}
