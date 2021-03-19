package state;

//import GameObjects.*;
//import GameObjects.Enemy;
//import GameObjects.MainCharacter;
import World.World;

import java.awt.*;

/**
 * GameState defines when the game is actively running in gameplay mode
 */
public class GameState extends State{
    //private MainCharacter player;
    private World world;

//    private static Point spawnPoint = new Point(100,100);
//    private static Point spawnPoint2 = new Point(300,300);
//    private static Point spawnPoint3= new Point (400,400);
//    private static Point spawnPoint4= new Point(500,500);
//    private static Point SpawnPoint5= new Point(300,100);
//    private Enemy enemy;
//    private RegularReward reward;
//    private TrapCell trap;
//    private BonusReward bonus;
    /**
     * GameState constructor
     * Initializes GameObjects in the game according to level design
     */
    public GameState(){
        world = new World("DungeonCrawlers/src/main/resources/Level1.txt");
//        player = new MainCharacter(world, spawnPoint);
//        enemy = new Enemy(world, spawnPoint2, 100, player);
//        reward = new RegularReward(world, spawnPoint3,100, player);
//        trap = new TrapCell(world, spawnPoint4,100,0,player);
//        bonus = new BonusReward(world, SpawnPoint5,200,0,player);
    }

    public void render(Graphics g) {
        world.populateMap(g);
    }
}
