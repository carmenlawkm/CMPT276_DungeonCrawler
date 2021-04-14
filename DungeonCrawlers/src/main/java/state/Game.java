package state;

import graphics.*;
import graphics.Window;
import input.KeyInput;
import input.MouseInput;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;


/**
 * Game class manages state of the game
 */
public class Game{

    private static Game instance;
    private Window window;
    private int width, height;
    private String title;
    private KeyInput k;
    private MouseInput m;
    private boolean running = false;
    public Level1State gameState;
    public MenuState menuState;
    public GameOverState gameOverState;
    public WinState winState;
    private BufferStrategy bs;
    private Graphics g;

    /**
     * Game constructor
     * @param width width size of the window to hold the game
     * @param height height size of the window to hold the game
     * @param title title of the game!
     */
    private Game(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        k = new KeyInput();
        m = new MouseInput();
    }

    /**
     * Singleton implementation of Game object
     * @return the one instance of Game
     */
    public static Game getInstance(){
        if(instance == null){
            instance = new Game(1200, 800, "DungeonCrawler");
        }
        return instance;
    }

    /**
     * initialize game window and graphics
     */
    public void initialize() {
        window = new Window(width, height, title);
        window.getFrame().addKeyListener(k);
        window.getFrame().addMouseListener(m);
        window.getFrame().addMouseMotionListener(m);
        window.getCanvas().addMouseListener(m);
        window.getCanvas().addMouseMotionListener(m);
        Assets.initAssets();
        System.out.println("Loading world...");
        if(bs == null){
            window.getCanvas().createBufferStrategy(2);
        }
        gameState = new Level1State();
        menuState = new MenuState();
        gameOverState = new GameOverState();
        winState = new WinState();
        running = true;
        State.setState(menuState);
        render();

    }

    /**
     * renders game graphics
     */
    protected void render(){
        while(running){
            bs = window.getCanvas().getBufferStrategy();
            g = bs.getDrawGraphics();
            //Clear Screen
            g.clearRect(0, 0, width, height);
            //Draw Here!
            if(State.getState() != null){
                State.getState().render(g);
                State.getState().update();
            }
            //End Drawing!
            bs.show();
            g.dispose();
        }

    }

    /**
     * set key input
     * @param k new key input
     */
    public void setKeyInput(KeyInput k){
        this.k = k;
    }

    /**
     * gets player key input
     * @return key input
     */
    public KeyInput getKeyInput(){return k;}

    /**
     * set mouse input
     * @param m new mouse input
     */
    public void setMouseClick(MouseInput m){
        this.m = m;
    }

    /**
     * gets player mouse clicks
     * @return mouse input
     */
    public MouseInput getMouseInput(){return m;}

    /**
     * renders the status of the game
     * @param running whether the game is running or not
     */
    public void setRunning(boolean running){
        this.running = running;
    }

    /**
     * getter for if the game is running
     * @return whether the game is running
     */
    public boolean getRunning(){
        return this.running;
    }



}
