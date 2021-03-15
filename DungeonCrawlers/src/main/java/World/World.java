package World;

import state.Game;
import state.Timer;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * World defines the game's environment
 * Implements graphics in a thread
 */
public class World implements Runnable{
    private int width, height;
    private int spawnX, spawnY;
    private int[][] tilesID;
    private Game game;
    private Timer timer;
    private Boolean running;
    private Thread worldThread;

    /**
     * World constructor
     * @param path
     */
    public World(String path){
        loadWorld(path);
        game = Game.getInstance();
        timer = game.getTimer();
    }

    public void render(Graphics g){
        for(int j = 0; j<height; j++){
            for(int i = 0; i<width; i++) {
                getTile(i,j).render(g,i*Tile.TEXTUREWIDTH,j*Tile.TEXTUREHEIGHT);
            }
        }
    }

    public Tile getTile(int x, int y){
        //error prevention
        if(x<0 || y<0 || x>=width || y>=height){
            return Tile.floorTile;
        }

        Tile t = Tile.tiles[tilesID[x][y]];
        if(t == null){
            return Tile.floorTile;
        }
        return t;
    }

    private void loadWorld(String path){
        String file = loadFile(path);
        String [] value = file.split("\\s+"); //split by space
        width  = stringToInt(value[0]);
        height = stringToInt(value[1]);
        spawnX  = stringToInt(value[2]);
        spawnY = stringToInt(value[3]);

        tilesID = new int[width][height];
        for(int j = 0; j<height; j++){
            for(int i = 0; i<width; i++) {
                tilesID[i][j] = stringToInt(value[(i+j*width)+4]);
            }
        }
    }

    //Helper methods for loading the world
    public static String loadFile (String path){
        StringBuilder builder = new StringBuilder();

        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while((line = br.readLine()) != null){
                builder.append(line + "\n");
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static int stringToInt (String number){
        try{
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Thread which loops to renders game environment
     * Synchronized to Game's Timer object
     * Awaits timer signal for one tick, then repeats the loop
     */
    public void run() {
        synchronized (timer){

            while(running) {
                

                render(game.g);
                //update location

                //wait for one tick controlled by Timer class
                try {
                    timer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * starts the World thread
     */
    public synchronized void start() {
        running = true;
        worldThread = new Thread(this);
        worldThread.start();
    }

    /**
     * stops the World thread
     */
    public synchronized void stop() {
        if (!running) return;

        running = false;
        try {
            worldThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

