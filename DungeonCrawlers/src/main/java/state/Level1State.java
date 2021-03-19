package state;

import GameObjects.*;
import World.World;
import graphics.Assets;

import java.awt.*;

/**
 * GameState defines when the game is actively running in gameplay mode
 */
public class Level1State extends State{
    private MainCharacter player;
    private Enemy enemy;
    private World world;
    private Game game;
    private RegularReward reward;
    private BonusReward bonus;
    private TrapCell trap;
    private Font eightBit;

    private static Point spawnPoint = new Point(100,100);
    private static Point spawnPoint2 = new Point(500,500);
    private static Point spawnPoint3= new Point (400,400);
    private static Point spawnPoint4= new Point(400,500);
    private static Point SpawnPoint5= new Point(300,100);




    /**
     * GameState constructor
     * Initializes GameObjects in the game according to level design
     */
    public Level1State(Game game){
        world = new World("DungeonCrawlers/src/main/resources/Level1.txt");
        this.game = game;
        player = new MainCharacter(game, world, spawnPoint);
        enemy = new Enemy(game, world, spawnPoint2, 100, player);
        player.start();
        enemy.start();
        reward = new RegularReward(game, world, spawnPoint3,100, player);
        bonus = new BonusReward(game, world, SpawnPoint5,200,0,player);
        trap = new TrapCell(game, world, spawnPoint4,100,0,player);

    }

    public void update(){
        reward.update();
        bonus.update();
    }

    public void render(Graphics g) {
        world.populateMap(g);

        player.render(g);
        enemy.render(g);
        reward.render(g);
        bonus.render(g);
        g.setColor(Color.white);
        g.setFont(Assets.eightBit);
        g.drawString("Score: "+player.getScore(), 500, 80);

    }
}
