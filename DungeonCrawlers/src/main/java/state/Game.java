package state;

import GameObjects.MainCharacter;
import graphics.*;
import graphics.Window;
import input.KeyInput;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.nio.Buffer;


public class Game implements Runnable {

    private static Game instance;
    private boolean isFirstRun;

    private Window window;
    public int width, height;
    public String title;

    private KeyInput keyInput;

    private Thread gameThread; //game runs on gameThread
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    private State gameState;

    public Timer timer;

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

    public Window getWindow(){
        return window;
    }

    public KeyInput getKeyInput() {
        return keyInput;
    }

    public boolean ifKeyPressed(){
        return keyInput.ifPressed;
    }

    //initialize game graphics etc
    private void init() {
        window = new Window(width, height, title);
        //initializing a keylistener (allows access to keyboard)
        window.getFrame().addKeyListener(keyInput);
        Assets.initAssets();
        gameState = new GameState(this);
        State.setState(gameState);
    }

    //game loop
    public void run() { //runnable's method - runs whenever we start our thread
        init();

        timer = new Timer();
        MainCharacter player = new MainCharacter( new Point(100, 100));
        timer.start();


        //while (running) {
            player.start();
            keyInput.ifPressed = false;
            //player.stop();
        //}

        stop();
    }


    //starts the thread
    public synchronized void start() {
        if (running) return;

        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    //stops the thread
    public synchronized void stop() {
        if (!running) return;

        running = false;
        try {
            gameThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
