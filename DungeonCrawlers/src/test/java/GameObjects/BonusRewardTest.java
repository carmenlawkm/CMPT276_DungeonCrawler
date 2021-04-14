package GameObjects;

import World.World;
import graphics.Assets;

import org.junit.Test;
import org.junit.*;

import java.awt.*;


import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertEquals;


public class BonusRewardTest {
    private MainCharacter player;
    private World world;
    private Point playerSpawn;
    private Point location;
    private BonusReward bonus;
    private int value;
    private int disappeartimer;


    @Before
    public void setup(){
        disappeartimer = 5;
        world = new World("src/test/resources/fileTest.txt");
        value = 200;
        playerSpawn = new Point(80, 160);
        player = new MainCharacter(world, playerSpawn);
        location = new Point(80, 120);
        bonus = new BonusReward(world, location, value, disappeartimer, player);
    }

    @Test
    public void StartandStopping() {
        bonus.start();
        assertTrue(bonus.getBonusrewardthread().isAlive());
        bonus.stop();
        assertFalse(bonus.getBonusrewardthread().isAlive());


    }

    @Test
    public void PlayerisOnreward() {
        player.setLocation(bonus.getX(), bonus.getY());
        player.setTimepassed(50);

        player.start();
        bonus.start();

        // Without the sleep, assertion will automatically execute, before the thread is able to run.
        // Need to sleep so that the bonus reward thread's code can be executed before we assert.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(200, player.getScore());

        player.stop();
        bonus.stop();

    }

    @Test
    public void PlayerisNotOnReward() {
        player.start();
        bonus.start();
        bonus.setLocation(80, 120);
        player.setLocation(120, 120);
        player.setTimepassed(25);
        if (player.getTime() == 25) {
            System.out.printf("hi");
            assertTrue(player.score == 0);
        }
        player.stop();
        bonus.stop();
    }

    @Test
    public void RewardAfterTimeInterval() {
        int randomtime = 0;
        randomtime = bonus.getRandomtime();
        assertTrue(randomtime >= 5 && randomtime <= 30);
    }
}