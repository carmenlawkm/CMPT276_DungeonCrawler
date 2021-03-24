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
    private RegularReward reward1, reward2, reward3, reward4, reward5;
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
        reward1 = new RegularReward(world, reward1Spawn,100, player);
        reward2 = new RegularReward(world, reward2Spawn,100, player);
        reward3 = new RegularReward(world, reward3Spawn,100, player);
        reward4 = new RegularReward(world, reward4Spawn,100, player);
        reward5 = new RegularReward(world, reward5Spawn,100, player);
        bonus1 = new BonusReward(world, bonusReward1Spawn,200,800,player);
        bonus2 = new BonusReward(world, bonusReward2Spawn,200,0,player);
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
        reward1.update();
        reward2.update();
        reward3.update();
        reward4.update();
        reward5.update();
        bonus1.update();
        bonus2.update();


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
        player.render(g);
        enemy.render(g);
        reward1.render(g);
        reward2.render(g);
        reward3.render(g);
        reward4.render(g);
        reward5.render(g);
        bonus1.render(g);
        bonus2.render(g);
        g.setColor(Color.white);
        g.setFont(Assets.eightBit_score);
        g.drawString("Score> "+player.getScore(), 50, 60);
        g.drawString("Coins collected> "+player.getRewardCount()+"/5", 600, 60);
        g.drawString("Time "+player.getTime(),50,750);

    }
}
