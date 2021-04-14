package GameObjects;

import java.awt.*;
import World.World;
import graphics.Assets;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class RewardCellTest {
    private int value;
    private MainCharacter player;
    protected boolean isTaken;
    private World world;
    private Point playerSpawn;
    private Point location;
    private RegularReward reward;
    @Before
    public void setup(){
        value=50;
        isTaken=false;
        playerSpawn=new Point(240,80);
        location=new Point(120,240);
        world = new World("src/main/resources/Level1.txt");
        player=new MainCharacter(world,playerSpawn);
        reward= new RegularReward(world,location,value,player);

    }

    @Test
    public void notTaken(){
        //scenario one, player is on the reward
        player.setLocation(120,80);
        player.score=50;
        reward.setLocation(120,80);
        reward.update();
        assertTrue(reward.value==0);
        assertTrue(reward.notTaken==false);
        assertTrue(reward.image== Assets.rewardgone);
        assertTrue(player.score==100);

        //scenario two, player is NOT on the reward
        reward.notTaken=true;
        reward.value=50;
        player.setLocation(120,80);
        player.score=50;
        reward.setLocation(80,80);
        reward.update();
        assertTrue(reward.value==50);
        assertTrue(reward.notTaken==true);
        assertTrue(reward.image==Assets.regularReward);
        assertTrue(player.score==50);

    }

}