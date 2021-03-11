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

        System.out.println("here1");

        window = new Window(width, height, title);
        //initializing a keylistener (allows access to keyboard)
        window.getFrame().addKeyListener(keyInput);
        Assets.initAssets();
        gameState = new GameState(this);
        State.setState(gameState);

        //buffer strategies allow the computer to draw things on the screen
        bs = window.getCanvas().getBufferStrategy();
        if (bs == null) {
            System.out.println("haha");
            window.getCanvas().createBufferStrategy(2);
        }

        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);
    }

        //game loop
    public void run() { //runnable's method - runs whenever we start our thread
        init();

        timer = new Timer();
        MainCharacter player = new MainCharacter( new Point(100, 100));
        Enemy enemy2 = new Enemy(new Point(600, 500), ID.Enemy, 100);
        Enemy enemy3 = new Enemy(new Point(200, 200), ID.Enemy, 100);

        timer.start();
        player.start();
        enemy2.start();
        enemy3.start();

        stop();
    }

    public void render(GameObject object) {
        //draw here
        System.out.println("here");
        g.drawImage(object.image, object.getLocation().x, object.getLocation().y, 40, 40, null);

        bs.show();
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
