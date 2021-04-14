package GameObjects;

import World.World;
import org.junit.Test;
import org.junit.*;

import java.awt.*;


public class BonusRewardTest {
    private MainCharacter player;
    protected boolean notSteppedOn;
    private World world;
    private Point playerSpawn;
    private Point location;
    private BonusReward bonus;
    private int value;
    private int disappeartimer;

    @Before
    public void setup(){
        disappeartimer=5;
        world = new World("src/main/resources/Level1.txt");
        value=200;
        playerSpawn=new Point(80,160);
        player=new MainCharacter(world,playerSpawn);
        location=new Point(80,120);
        bonus=new BonusReward(world,location,value,disappeartimer,player);
    }

    @Test
    public void getRandomtime(){
    }
    @Test
    public void run(){

    }
    @Test
    public void start(){

    }
    @Test
    public void stop(){

    }
    @Test
    public void update(){

    }

}