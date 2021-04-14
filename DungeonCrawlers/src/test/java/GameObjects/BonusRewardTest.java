package GameObjects;

import World.World;
import org.junit.Test;
import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;


class BonusRewardTest {
    private MainCharacter player;
    protected boolean notSteppedOn;
    private World world;
    private Point playerSpawn;
    private Point location;
    private BonusReward bonus;
    private int value;
    private int disappeartimer;

    @BeforeEach
    void setup(){
        disappeartimer=5;
        world = new World("src/main/resources/Level1.txt");
        value=200;
        playerSpawn=new Point(80,160);
        player=new MainCharacter(world,playerSpawn);
        location=new Point(80,120);
        bonus=new BonusReward(world,location,value,disappeartimer,player);
    }

    @Test
    void getRandomtime(){
    }
    @Test
    void run(){

    }
    @Test
    void start(){

    }
    @Test
    void stop(){

    }
    @Test
    void update(){

    }

}