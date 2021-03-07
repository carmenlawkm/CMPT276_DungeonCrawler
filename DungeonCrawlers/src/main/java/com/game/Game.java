package main.java.com.game;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import main.java.com.game.GameObjects.*;

public class Game implements Runnable{
    private Window window;
    public int width, height;
    public String title;

    private Thread thread1; //game runs on thread1
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    //TEMPORARY CODE
    MainCharacter player = new MainCharacter("/main/resources/mainCharacter.png", new Point(0, 0), ID.MainCharacter);
    Enemy enemy1 = new Enemy("/main/resources/slime.png", new Point(50, 50), ID.Enemy, 50);


    public Game (int width, int height, String title){
        this.width = width;
        this.height = height;
        this.title = title;
    }


    //starts the thread
    public synchronized void start(){
        if(running) return;

        running = true;
        thread1 = new Thread (this);
        thread1.start();

    }

    //stops the thread
    public synchronized void stop(){
        if(!running) return;

        running = false;
        try{
            thread1.join();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //game loop's method
    public void update(){

    }

    //game loop's method
    public void render(){
        //buffer strategies allow the computer to draw things on the screen
        bs = window.getCanvas().getBufferStrategy();
        if(bs == null){
            window.getCanvas().createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();

        //draw graphics here
        g.drawImage(player.loadImage(), 0, 0, null);
        g.drawImage(enemy1.loadImage(), enemy1.getX(), enemy1.getY(), null);


        bs.show();
        g.dispose();
    }

    //initialize game graphics etc
    private void init(){
        window = new Window(width, height, title);
    }


    //game loop
    public void run (){ //runnable's method - runs whenever we start our thread
        init();

        while(running){
            update();//update all variables, position of objects..etc
            render();//render (draw) everything on the window ---- loop
        }

        stop();
    }


}
