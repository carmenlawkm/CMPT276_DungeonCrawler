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
    private static Point spawnPoint3= new Point (400,400);
    private static Point spawnPoint4= new Point(500,500);
    private Enemy enemy;
    private RegularReward reward;
    private TrapCell trap;

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
        reward= new RegularReward(spawnPoint3,100, player);
        trap= new TrapCell(spawnPoint4,100,0,player);
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
        reward.start();
        trap.start();
    }

    public void update() {
        player.update();
    }

}
