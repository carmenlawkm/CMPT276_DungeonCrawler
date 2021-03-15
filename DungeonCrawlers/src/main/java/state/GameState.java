package state;

import GameObjects.*;
import GameObjects.Enemy;
import GameObjects.MainCharacter;
import World.World;

import java.awt.*;
import java.util.ArrayList;

/**
 * GameState defines when the game is actively running in gameplay mode
 */
public class GameState extends State{
    private Timer timer;
    private MainCharacter player;
    private World world;
    private static Point spawnPoint = new Point(100,100);
    private static Point spawnPoint2 = new Point(300,300);
    private Enemy enemy;

    /**
     * GameState constructor
     * Initializes GameObjects in the game according to level design
     */
    public GameState(){
        super();
        timer = game.getTimer();
        world = new World("src/main/resources/Level1.txt");
        player = new MainCharacter(world, spawnPoint);
        enemy = new Enemy(spawnPoint2, 100, player);
    }

    @Override
    public void render() {

    }

    /**
     * Starts the threads running in the game
     */
    @Override
    public void initiateState() {
        timer.start();
        world.start();
        player.start();
        enemy.start();
    }

    public void update() {
        player.update();
    }

}
