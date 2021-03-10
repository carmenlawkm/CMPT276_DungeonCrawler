package state;

import GameObjects.*;
import graphics.*;
import graphics.Window;
import input.KeyInput;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game implements Runnable {
    private Window window;
    public int width, height;
    public String title;

    private KeyInput keyInput;

    private Thread thread1; //game runs on thread1
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    private State gameState;


    public Game(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyInput = new KeyInput();
    }

    public KeyInput getKeyInput() {
        return keyInput;
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

    //game loop's method
    public void render() {
        //buffer strategies allow the computer to draw things on the screen
        bs = window.getCanvas().getBufferStrategy();
        if (bs == null) {
            window.getCanvas().createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        //draw here

        if (State.getState() != null) {
            State.getState().render(g);
        }

        //end draw

        bs.show();
        g.dispose();
    }

    //game loop's method
    public void update() {
        keyInput.update();

        if (State.getState() != null) {

            State.getState().update();
        }

    }

    //game loop
    public void run() { //runnable's method - runs whenever we start our thread
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                update();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }


    //starts the thread
    public synchronized void start() {
        if (running) return;

        running = true;
        thread1 = new Thread(this);
        thread1.start();
    }

    //stops the thread
    public synchronized void stop() {
        if (!running) return;

        running = false;
        try {
            thread1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
