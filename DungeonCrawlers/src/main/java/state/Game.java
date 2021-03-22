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

    public Game(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        k = new KeyInput();
        m = new MouseInput();
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
        window.getFrame().addMouseListener(m);
        window.getFrame().addMouseMotionListener(m);
        window.getCanvas().addMouseListener(m);
        window.getCanvas().addMouseMotionListener(m);
        Assets.initAssets();
        System.out.println("Loading world...");
        if(bs == null){
            window.getCanvas().createBufferStrategy(2);
        }
        gameState = new Level1State(this);
        menuState = new MenuState(this);
        gameOverState = new GameOverState(this);
        winState = new WinState(this);
        running = true;
        State.setState(menuState);
        render();

    }

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

    public KeyInput getKeyInput(){return k;}
    public MouseInput getMouseInput(){return m;}

    public void setRunning(boolean running){
        this.running = running;
    }

}
