package GameObjects;

import World.World;
import graphics.Assets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusRewardTest {
    private MainCharacter player;
    private World world;
    private Point playerSpawn;
    private Point location;
    private BonusReward bonus;
    private int value;
    private int disappeartimer;

    @BeforeEach
    void setup() {
        disappeartimer = 5;
        world = new World("src/test/resources/fileTest.txt");
        value = 200;
        playerSpawn = new Point(80, 160);
        player = new MainCharacter(world, playerSpawn);
        location = new Point(80, 120);
        bonus = new BonusReward(world, location, value, disappeartimer, player);
    }

    @Test
    void StartandStopping() {
        bonus.start();
        assertTrue(bonus.getBonusrewardthread().isAlive());
        bonus.stop();
        assertFalse(bonus.getBonusrewardthread().isAlive());


    }

    @Test
    void PlayerisOnreward() {
        player.setLocation(bonus.getX(), bonus.getY());
        player.setTimepassed(50);

        player.start();
        bonus.start();
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
    void PlayerisNotOnReward() {
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
    void RewardAfterTimeInterval() {
        int randomtime = 0;
        randomtime = bonus.getRandomtime();
        assertTrue(randomtime >= 5 && randomtime <= 30);
    }
}