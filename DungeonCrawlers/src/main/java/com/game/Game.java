package main.java.com.game;

import main.java.com.game.GameObjects.*;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game implements Runnable{
    private Window window;
    public int width, height;
    public String title;

    private Thread thread1; //game runs on thread1
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    //Game Objects
    MainCharacter player;
    ExitCell exitCell;

    ArrayList<BarrierCell> barriers = new ArrayList<BarrierCell>();
    ArrayList<Enemy> enemies;
    ArrayList<TrapCell> traps;
    ArrayList<RegularReward> regularRewards;
    ArrayList<BonusReward> bonusRewards;

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

    //initialize game graphics etc
    private void init(){
        window = new Window(width, height, title);

        //initialize based on level design, PROBABLY WILL SEPARATE INTO 5 METHODS, ONE PER LEVEL
        player = new MainCharacter(new Point(50, 50), ID.MainCharacter);

        //create barriers
        barriers.add(new BarrierCell("/main/resources/barrier.png", new Point(100, 100), ID.Barrier));

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

        /****DRAW GRAPHICS HERE ****/

        //draw background
        g.drawImage(ImageLoader.loadImage("/main/resources/dungeonBG_resized.png", false), 0, 0, null);

        //drawing floor tiles
        for (int x = 50; x < width - 50; x += 50){
            for (int y = 50; y < height - 50; y += 50){
                g.drawImage(ImageLoader.loadImage("/main/resources/floor.png", true), x, y, null);
            }
        }

        //draw barriers
        for (BarrierCell barrier: barriers){
            g.drawImage(ImageLoader.loadImage(barrier.getImage(), true), barrier.getX(), barrier.getY(), null);
        }

        //draw main character
        g.drawImage(ImageLoader.loadImage(player.getImage(), true), player.getX(), player.getY(), null);

        bs.show();
        g.dispose();
    }

    //game loop's method
    public void update(){

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
