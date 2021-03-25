package state;

import GameObjects.*;
import World.World;
import graphics.Assets;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * GameState defines when the game is actively running in gameplay mode
 */
public class Level1State extends State{
    private MainCharacter player;
    private Enemy enemy;
    private World world;
    private Game game;

    private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    private BonusReward bonus1, bonus2;

    private static Point playerSpawn = new Point(0,80);

    private static Point enemySpawn = new Point(1040,640);

    private static Point reward1Spawn = new Point (160,640);
    private static Point reward2Spawn = new Point (1040,80);
    private static Point reward3Spawn = new Point (800,640);
    private static Point reward4Spawn = new Point (80,320);
    private static Point reward5Spawn = new Point (560,240);

    private static Point bonusReward1Spawn= new Point(720,80);
    private static Point bonusReward2Spawn= new Point(1040,240);

    private static Point trap1Spawn = new Point(320, 80);
    private static Point trap2Spawn = new Point(480, 160);
    private static Point trap3Spawn = new Point(400, 400);
    private static Point trap4Spawn = new Point(480, 560);
    private static Point trap6Spawn = new Point(1040, 160);
    private static Point trap7Spawn = new Point(880, 80);

    public static Point exitLocation = new Point (1120,560);

    /**
     * GameState constructor
     * Initializes GameObjects in the game according to level design
     */
    public Level1State(){
        System.out.println("Creating level!");
        world = new World("src/main/resources/Level1.txt");
        this.game = Game.getInstance();
        player = new MainCharacter(world, playerSpawn);
        enemy = new Enemy(world, enemySpawn, 100, player);

        gameObjects.add(new RegularReward(world, reward1Spawn,100, player));
        gameObjects.add(new RegularReward(world, reward2Spawn,100, player));
        gameObjects.add(new RegularReward(world, reward3Spawn,100, player));
        gameObjects.add(new RegularReward(world, reward4Spawn,100, player));
        gameObjects.add(new RegularReward(world, reward5Spawn,100, player));
        gameObjects.add(new Trap(world, trap1Spawn, 100, player));
        gameObjects.add(new Trap(world, trap2Spawn, 100, player));
        gameObjects.add(new Trap(world, trap3Spawn, 100, player));
        gameObjects.add(new Trap(world, trap4Spawn, 100, player));
        gameObjects.add(new Trap(world, trap6Spawn, 100, player));
        gameObjects.add(new Trap(world, trap7Spawn, 100, player));
        Random ran = new Random();
        gameObjects.add(new BonusReward(world, bonusReward1Spawn,200, ran.nextInt(10000),player));
        gameObjects.add(new BonusReward(world, bonusReward2Spawn,200,ran.nextInt(10000),player));
    }

    /**
     * start the required threads of the level
     */
    public void startThreads(){
        player.start();
        enemy.start();
    }

    /**
     * Update the status of various game objects
     * Checks if the player has won or lost the game
     */
    public void update(){

        for(GameObject object: gameObjects){
            object.update();
        }

        if(player.getScore() == 0 || enemy.isOnPlayer()){
            System.out.println("Game over");
            player.stop();
            enemy.stop();
            State.setState(game.gameOverState);
        }

        if(player.getLevel1Win()) {
            System.out.println("Player Wins");
            player.stop();
            enemy.stop();
            State.setState(game.winState);
        }

    }

    /**
     * renders graphics of the level
     * @param g the Graphic to be rendered on
     */
    public void render(Graphics g) {
        world.populateMap(g);

        for(GameObject object: gameObjects){
            object.render(g);
        }

        player.render(g);
        enemy.render(g);

        g.setColor(Color.white);
        g.setFont(Assets.eightBit_score);
        g.drawString("Score> "+player.getScore(), 50, 60);
        g.drawString("Coins collected> "+player.getRewardCount()+"/5", 600, 60);
        g.drawString("Time "+player.getTime()+" s",50,770);

    }
}
